package com.lxx.bill.bean.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.lxx.bill.annotation.CustomStringToOneLineConverter;
import com.lxx.bill.annotation.StringToOneLineConverterAnnotation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 基础数据类
 *
 * @author Jiaju Zhuang
 **/
@Getter
@Setter
@EqualsAndHashCode
public class PuFaBillStreamUploadData {
    /**
     * 交易时间
     */
    @ExcelProperty(value = {"交易日期"})
    private String tradeTime;

    /**
     * 交易时间
     */
    @ExcelProperty(value = {"交易时间"})
    private String tradeTime1;

    /**
     * 交易名称
     */
    @ExcelProperty(value = {"交易名称"}, converter = CustomStringToOneLineConverter.class)
    @StringToOneLineConverterAnnotation
    private String tradeType;

    /**
     * 对手姓名
     */
    @ExcelProperty(value = {"对手姓名"}, converter = CustomStringToOneLineConverter.class)
    @StringToOneLineConverterAnnotation
    private String tradeObject;

    /**
     * 对手账号
     */
    @ExcelProperty(value = {"对手账号"}, converter = CustomStringToOneLineConverter.class)
    @StringToOneLineConverterAnnotation
    private String objectNo;


    /**
     * 交易金额
     */
    @ExcelProperty(value = {"交易金额"})
    private String totalAmount;

    /**
     * 余额
     */
    @ExcelProperty(value = {"账户余额"})
    private String balance;

    /**
     * 交易账号
     */
//    @ExcelProperty(value = {"收/付款方式",""})
    @ExcelProperty(value = {"交易账号"}, converter = CustomStringToOneLineConverter.class)
    @StringToOneLineConverterAnnotation
    private String inExWay;


    /**
     * 备注
     */
    @ExcelProperty(value = {"交易摘要"}, converter = CustomStringToOneLineConverter.class)
    @StringToOneLineConverterAnnotation
    private String note;
}
