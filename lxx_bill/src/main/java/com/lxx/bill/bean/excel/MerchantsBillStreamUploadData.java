package com.lxx.bill.bean.excel;

import com.alibaba.excel.annotation.ExcelProperty;
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
public class MerchantsBillStreamUploadData {
    /**
     * 记账日期
     */
    @ExcelProperty(value = {"记账日期"})
    private String tradeTime;

    /**
     * 交易摘要
     */
    @ExcelProperty(value = {"交易摘要"})
    private String tradeType;

    /**
     * 对手信息
     */
    @ExcelProperty(value = {"对手信息"})
    private String tradeObject;

    /**
     * 交易金额
     */
//    @ExcelProperty(value = {"金额", ""})
    @ExcelProperty(value = {"交易金额"})
    private String totalAmount;

    /**
     * 联机余额
     */
    @ExcelProperty(value = {"联机余额"})
    private String balance;



}
