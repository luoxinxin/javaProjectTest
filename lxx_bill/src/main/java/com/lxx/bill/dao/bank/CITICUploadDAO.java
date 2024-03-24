package com.lxx.bill.dao.bank;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.lxx.bill.bean.excel.CITICBillStreamUploadData;
import com.lxx.bill.constant.DictTypeConstants;
import com.lxx.bill.domain.BillStream;
import com.lxx.bill.service.BillStreamService;
import com.lxx.bill.service.CommonDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 支付宝账单流水入库
 */
@Repository
public class CITICUploadDAO {

    @Autowired
    private BillStreamService billStreamService;


    @Autowired
    private CommonDictTypeService commonDictTypeService;

    public void save(List<CITICBillStreamUploadData> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
        List<BillStream> billStreams = list.stream().map(v -> {
            BillStream billStream = new BillStream();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
            billStream.setTradeTime(Date.from(LocalDateTime.parse(v.getTradeTime() + " 00:00:00", dateTimeFormatter).atZone(ZoneId.systemDefault()).toInstant()));
            billStream.setTradeType(commonDictTypeService.insertCommonDictType(DictTypeConstants.DICT_TYPE_TRADE_TYPE,v.getTradeType(),DictTypeConstants.DICT_TYPE_DICT_FROM_6, null));
            billStream.setTradeObject(v.getTradeObject());
            billStream.setTotalAmount(NumberUtil.toBigDecimal(totalAmountHandle(v.getTotalAmount(), v.getTotalAmount1())));
            billStream.setInExType(inExTypeHandle(v.getTotalAmount(), v.getTotalAmount1()));
            billStream.setInExWay(commonDictTypeService.getStreamSource("中信银行"));
            billStream.setTradeStatus("交易成功");
            billStream.setTradeNo(IdUtil.fastSimpleUUID());
            billStream.setNote(v.getNote());
            billStream.setStreamSource(commonDictTypeService.getStreamSource("中信银行"));
            billStream.setUserId(0L);
            billStream.setCreateTime(new Date());
            billStream.setUpdateTime(new Date());
            return billStream;
        }).collect(Collectors.toList());
        if(!list.isEmpty()){
            billStreamService.saveBatch(billStreams, billStreams.size());
        }
    }


    public String totalAmountHandle(String totalAmount, String totalAmount1){
        if(StrUtil.isNotEmpty(totalAmount) && StrUtil.startWith(totalAmount, "RMB")){
            return totalAmount.substring(3).trim();
        }else if(StrUtil.isNotEmpty(totalAmount1) && StrUtil.startWith(totalAmount1, "RMB")){
            return totalAmount1.substring(3).trim();
        }else{
            return null;
        }
    }

    public String inExTypeHandle(String totalAmount, String totalAmount1) {
        String typeName = "";
        if (StrUtil.isNotEmpty(totalAmount)) {
            typeName = DictTypeConstants.DICT_TYPE_IN_EX_TYPE_1;
        }else if(StrUtil.isNotEmpty(totalAmount1)){
            typeName = DictTypeConstants.DICT_TYPE_IN_EX_TYPE_2;
        }
        return commonDictTypeService.getDictTypeCodeByName(DictTypeConstants.DICT_TYPE_IN_EX_TYPE, typeName, null);
    }


    public static void main(String[] args) {
//        System.out.println(timeHandle("2023/11/30 5:06" ));
        String[] split = "中信银行信用卡(3095)&红包".split("&");
        for (String s : split) {
            System.out.println(s);
        }
        StringBuilder stringBuilder = new StringBuilder();
        hello(stringBuilder);
        System.out.println(stringBuilder.toString());
    }

    public static void hello(StringBuilder a){
        a.append("hello");
    }
}
