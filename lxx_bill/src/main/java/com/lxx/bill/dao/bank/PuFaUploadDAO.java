package com.lxx.bill.dao.bank;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.lxx.bill.bean.excel.PuFaBillStreamUploadData;
import com.lxx.bill.bean.excel.WechatBillStreamUploadData;
import com.lxx.bill.constant.DictTypeConstants;
import com.lxx.bill.domain.BillStream;
import com.lxx.bill.service.BillStreamService;
import com.lxx.bill.service.CommonDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class PuFaUploadDAO {

    @Autowired
    private BillStreamService billStreamService;


    @Autowired
    private CommonDictTypeService commonDictTypeService;

    public void save(List<PuFaBillStreamUploadData> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
        List<BillStream> billStreams = list.stream().map(v -> {
            BillStream billStream = new BillStream();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            billStream.setTradeTime(Date.from(LocalDateTime.parse(v.getTradeTime()+timeHandle(v.getTradeTime1()), dateTimeFormatter).atZone(ZoneId.systemDefault()).toInstant()));
            billStream.setTradeType(commonDictTypeService.commonDictType(DictTypeConstants.DICT_TYPE_TRADE_TYPE,v.getTradeType(),null));
            billStream.setTradeObject(v.getTradeObject());
            billStream.setObjectNo(v.getObjectNo());
            billStream.setTotalAmount(NumberUtil.toBigDecimal(totalAmountHandle(v.getTotalAmount())));
            billStream.setInExType(inExTypeHandle(v.getTotalAmount()));
            billStream.setInExWay(v.getInExWay());
            billStream.setTradeStatus("交易成功");
            billStream.setTradeNo(IdUtil.fastSimpleUUID());
            billStream.setNote(v.getNote());
            billStream.setStreamSource(commonDictTypeService.getStreamSource("浦发银行"));
            billStream.setUserId(1000L);
            billStream.setCreateTime(new Date());
            billStream.setUpdateTime(new Date());
            return billStream;
        }).collect(Collectors.toList());
        if(!list.isEmpty()){
            billStreamService.saveBatch(billStreams, billStreams.size());
        }
    }

    public String timeHandle(String time) {
        if(time.length()<6){
            time = StrUtil.padPre(time,6,"0");
        }
        return time;
    }


    public String totalAmountHandle(String totalAmount){
        if (totalAmount.startsWith("-")) {
            totalAmount = totalAmount.replace("-", "");
        }
        return totalAmount;
    }


    public String inExTypeHandle(String totalAmount) {
        String type = "";
        if (totalAmount.startsWith("-")) {
            type = commonDictTypeService.getINEXType("支出");
        }else{
            type = commonDictTypeService.getINEXType("收入");
        }
        return type;
    }

}
