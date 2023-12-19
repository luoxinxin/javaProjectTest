package com.lxx.bill.dao;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lxx.bill.bean.excel.AliBillStreamUploadData;
import com.lxx.bill.component.RedisCache;
import com.lxx.bill.constant.DictTypeConstants;
import com.lxx.bill.domain.BillStream;
import com.lxx.bill.domain.InExType;
import com.lxx.bill.service.BillStreamService;
import com.lxx.bill.service.CommonDictTypeService;
import com.lxx.bill.service.InExTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

/**
 * 支付宝账单流水入库
 */
@Repository
public class AliUploadDAO {

    @Autowired
    private BillStreamService billStreamService;

    @Autowired
    private InExTypeService inExTypeService;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private CommonDictTypeService commonDictTypeService;

    private static final String INEX_TYPE_REDIS_KEY_PREFIX = "INEX_TYPE:";
    public void save(List<AliBillStreamUploadData> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
        List<BillStream> billStreams = list.stream().map(v -> {
            BillStream billStream = new BillStream();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            billStream.setTradeTime(Date.from(LocalDateTime.parse(timeHandle(v.getTradeTime()), dateTimeFormatter).atZone(ZoneId.systemDefault()).toInstant()));
            billStream.setTradeType(commonDictTypeService.commonDictType(DictTypeConstants.DICT_TYPE_TRADE_TYPE,v.getTradeType(),null));
            billStream.setTradeObject(v.getTradeObject());
            billStream.setObjectNo(v.getObjectNo());
            billStream.setGoodsDescription(v.getGoodsDescription());
            billStream.setTotalAmount(NumberUtil.toBigDecimal(v.getTotalAmount()));
            billStream.setInExType(commonDictTypeService.commonDictType(DictTypeConstants.DICT_TYPE_IN_EX_TYPE,v.getInExType(),null));
            billStream.setInExWay((inExTypeHandle(v.getInExWay(), 1000L, DictTypeConstants.DICT_TYPE_IN_EX_WAY)));
            billStream.setTradeStatus(commonDictTypeService.commonDictType(DictTypeConstants.DICT_TYPE_TRADE_STATUS, v.getTradeStatus(), null));
            billStream.setTradeNo(v.getTradeNo());
            billStream.setMerchantOrderNo(v.getMerchantOrderNo());
            billStream.setNote(v.getNote());
            billStream.setStreamSource(commonDictTypeService.getStreamSource("支付宝"));
            billStream.setUserId(1000L);
            billStream.setCreateTime(new Date());
            billStream.setUpdateTime(new Date());
            return billStream;
        }).collect(Collectors.toList());
        if(!list.isEmpty()){
            billStreamService.saveBatch(billStreams, billStreams.size());
        }
    }

    private static String timeHandle(String tradeTime) {
        String[] split = tradeTime.split("/");
        split[1]= split[1].length()<2?split[1]="0"+split[1]:split[1];
        String[] split1 = split[2].split(" ");
        split1[0]= split1[0].length()<2?split1[0]="0"+split1[0]:split1[0];
        String[] split2 = split1[1].split(":");
        split2[0]= split2[0].length()<2?split2[0]="0"+split2[0]:split2[0];
        String split21 = split2[0].concat(":").concat(split2[1]);
        String split11 = split1[0].concat(" ").concat(split21);
        String concat = split[0].concat("/").concat(split[1]).concat("/").concat(split11);
        return concat;
    }

    public String inExTypeHandle(String inExType, long userId) {
        StringBuilder sb = new StringBuilder();
        if(StrUtil.isEmpty(inExType)){ return null;}
        String[] type = inExType.split("&");
        List<String> list = Arrays.asList(type);

        String key = INEX_TYPE_REDIS_KEY_PREFIX.concat(String.valueOf(userId));
        Map<String, Object> cacheMap = redisCache.getCacheMap(key);

        if(CollectionUtil.isEmpty(cacheMap)){
            QueryWrapper<InExType> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", userId);
            inExTypeService.list(queryWrapper).forEach(v -> {
                cacheMap.put(v.getTypeName(), v.getId());
            });
            redisCache.setCacheMap(key, cacheMap);
            redisCache.expire(key, 24*60*60);
        }

        List<String> notInList = list.stream().filter(v -> !cacheMap.containsKey(v)).collect(Collectors.toList());

        if (CollectionUtil.isNotEmpty(notInList)) {
            notInList.forEach(v -> {
                QueryWrapper<InExType> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("user_id", userId).eq("type_name", v);
                InExType one = inExTypeService.getOne(queryWrapper);
                if (one == null) {
                    String typeCode = IdUtil.fastSimpleUUID();
                    InExType inExTypePO = new InExType();
                    inExTypePO.setUserId(userId);
                    inExTypePO.setTypeCode(typeCode);
                    inExTypePO.setTypeName(v);
                    inExTypePO.setStatus(1L);
                    inExTypePO.setCreateTime(new Date());
                    inExTypePO.setUpdateTime(new Date());
                    inExTypeService.save(inExTypePO);
                    cacheMap.put(v, typeCode);
                }
            });
            redisCache.setCacheMap(key, cacheMap);
            redisCache.expire(key, 24 * 60 * 60);
        }

        list.forEach(v -> {
            sb.append(cacheMap.get(v)).append("&");
        });

        if (sb.length() > 0 && sb.lastIndexOf("&") == sb.length()-1) {
            sb.delete(sb.length()-1, sb.length());
        }
        return sb.toString();
    }

    public String inExTypeHandle(String inExType, long userId, String dictType) {
        if(StrUtil.isEmpty(inExType)){ return null;}
        StringBuilder sb = new StringBuilder();
        List<String> list = Arrays.asList(inExType.split("&"));
        list.forEach(v -> {
            String s = commonDictTypeService.commonDictType(dictType, v, userId);
            sb.append(s).append("&");
        });
        if (sb.length() > 0 && sb.lastIndexOf("&") == sb.length()-1) {
            sb.delete(sb.length()-1, sb.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(timeHandle("2023/11/30 5:06" ));
        String[] split = "中信银行信用卡(3095)&红包".split("&");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
