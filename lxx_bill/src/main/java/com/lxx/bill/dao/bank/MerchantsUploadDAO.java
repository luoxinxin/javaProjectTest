package com.lxx.bill.dao.bank;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import com.lxx.bill.bean.excel.MerchantsBillStreamUploadData;
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

@Repository
public class MerchantsUploadDAO {

    @Autowired
    private BillStreamService billStreamService;


    @Autowired
    private CommonDictTypeService commonDictTypeService;

    public void save(List<MerchantsBillStreamUploadData> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
        List<BillStream> billStreams = list.stream().map(v -> {
            BillStream billStream = new BillStream();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            billStream.setTradeTime(Date.from(LocalDateTime.parse(v.getTradeTime()+" 00:00:00", dateTimeFormatter).atZone(ZoneId.systemDefault()).toInstant()));
            billStream.setTradeType(commonDictTypeService.insertCommonDictType(DictTypeConstants.DICT_TYPE_TRADE_TYPE,v.getTradeType(),DictTypeConstants.DICT_TYPE_DICT_FROM_5, null));
            billStream.setTradeObject(v.getTradeObject());
            billStream.setTotalAmount(NumberUtil.toBigDecimal(totalAmountHandle(v.getTotalAmount())));
            billStream.setBalance(NumberUtil.toBigDecimal(v.getBalance()));
            billStream.setInExType(inExTypeHandle(v.getTotalAmount()));
            billStream.setInExWay(commonDictTypeService.getStreamSource("招商银行"));
            billStream.setTradeStatus("交易成功");
            billStream.setTradeNo(IdUtil.fastSimpleUUID());
            billStream.setStreamSource(commonDictTypeService.getStreamSource("招商银行"));
            billStream.setUserId(0L);
            billStream.setCreateTime(new Date());
            billStream.setUpdateTime(new Date());
            return billStream;
        }).collect(Collectors.toList());
        if(!list.isEmpty()){
            billStreamService.saveBatch(billStreams, billStreams.size());
        }
    }


    public String totalAmountHandle(String totalAmount){
        if (totalAmount.startsWith("-")) {
            totalAmount = totalAmount.replace("-", "");
        }
        return totalAmount;
    }


    public String inExTypeHandle(String totalAmount) {
        String typeName = "";
        if (totalAmount.startsWith("-")) {
            typeName = DictTypeConstants.DICT_TYPE_IN_EX_TYPE_2;
        }else{
            typeName = DictTypeConstants.DICT_TYPE_IN_EX_TYPE_1;
        }
        return commonDictTypeService.getDictTypeCodeByName(DictTypeConstants.DICT_TYPE_IN_EX_TYPE, typeName, null);
    }

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(Date.from(LocalDateTime.parse( "2023-12-13" +" 00:00:00", dateTimeFormatter).atZone(ZoneId.systemDefault()).toInstant()));
    }

}
