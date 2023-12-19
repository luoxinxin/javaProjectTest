package com.lxx.bill.bean.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 基础数据类
 *
 * @author Jiaju Zhuang
 **/
@Getter
@Setter
@EqualsAndHashCode
public class CITICBillStreamUploadData {
    /**
     * 交易日期
     */
    @ExcelProperty(value = {"交易日期"})
    private String tradeTime;

    /**
     * 交易摘要
     */
    @ExcelProperty(value = {"交易摘要"})
    private String tradeType;

    /**
     * 对方户名
     */
    @ExcelProperty(value = {"对方户名"})
    private String tradeObject;


    /**
     * 收入金额
     */
    @ExcelProperty(value = {"收入金额"})
    private String totalAmount;

    @ExcelProperty(value = {"支出金额"})
    private String totalAmount1;

    /**
     * 余额
     */
    @ExcelProperty(value = {"账户余额"})
    private String balance;

    /**
     * 备注
     */
    @ExcelProperty(value = {"冲账标识"})
    private String note;
}
