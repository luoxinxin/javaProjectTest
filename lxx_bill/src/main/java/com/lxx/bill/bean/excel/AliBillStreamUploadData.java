package com.lxx.bill.bean.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.lxx.bill.annotation.CustomStringToIntegerConverter;
import com.lxx.bill.annotation.StringToIntegerConverterAnnotation;
import com.lxx.bill.enumbean.StringToIntegerConverterEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 基础数据类
 *
 * @author Jiaju Zhuang
 **/
@Getter
@Setter
@EqualsAndHashCode
public class AliBillStreamUploadData {
    /**
     * 交易时间
     */
    @ExcelProperty(value = {"交易时间"})
    private String tradeTime;

    /**
     * 交易类型
     */
    @ExcelProperty(value = {"交易分类"})
    private String tradeType;

    /**
     * 交易对象
     */
    @ExcelProperty(value = {"交易对方"})
    private String tradeObject;

    /**
     * 交易对象编号
     */
    @ExcelProperty(value = {"对方账号"})
    private String objectNo;

    /**
     * 商品描述
     */
//    @ExcelProperty(value = {"商品说明", "商品"})
    @ExcelProperty(value = {"商品说明"})
    private String goodsDescription;

    /**
     * 交易金额
     */
//    @ExcelProperty(value = {"金额", "金额(元)"})
    @ExcelProperty(value = {"金额"})
    private String totalAmount;

    /**
     * 收入支出类型 0-支出 1-收入 2-不计收支
     */
    @ExcelProperty(value = {"收/支"})
    private String inExType;

    /**
     * 收/付款方式
     */
//    @ExcelProperty(value = {"收/付款方式","支付方式"})
    @ExcelProperty(value = {"收/付款方式"})
    private String inExWay;

    /**
     * 交易状态
     */
//    @ExcelProperty(value = {"交易状态", "当前状态"})
//    @StringToIntegerConverterAnnotation(converterEnums = {StringToIntegerConverterEnum.TRADE_STATU_SUCCESS,
//            StringToIntegerConverterEnum.TRADE_STATUS_CLOSE,
//            StringToIntegerConverterEnum.TRADE_STATUS_WAIT_CONFIRM,
//            StringToIntegerConverterEnum.TRADE_STATUS_REFUND_SUCCESS,
//            StringToIntegerConverterEnum.TRADE_STATUS_REPAY_SUCCESS
//    })
    @ExcelProperty(value = {"交易状态"})
    private String tradeStatus;

    /**
     * 交易订单号
     */
//    @ExcelProperty(value = {"交易订单号", "交易单号"})
    @ExcelProperty(value = {"交易订单号"})
    private String tradeNo;

    /**
     * 商家订单号
     */
//    @ExcelProperty(value = {"商家订单号", "商户单号"})
    @ExcelProperty(value = {"商家订单号"})
    private String merchantOrderNo;

    /**
     * 备注
     */
    @ExcelProperty(value = {"备注"})
    private String note;


}
