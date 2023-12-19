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
public class WechatBillStreamUploadData {
    /**
     * 交易时间
     */
    @ExcelProperty(value = {"交易时间"})
    private String tradeTime;

    /**
     * 交易类型
     */
    @ExcelProperty(value = {"交易类型"})
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
//    @ExcelProperty(value = {"商品说明", ""})
    @ExcelProperty(value = {"商品"})
    private String goodsDescription;

    /**
     * 交易金额
     */
//    @ExcelProperty(value = {"金额", ""})
    @ExcelProperty(value = {"金额(元)"})
    private String totalAmount;

    /**
     * 收入支出类型 0-支出 1-收入
     */
    @ExcelProperty(value = {"收/支"})
    private String inExType;

    /**
     * 收/付款方式
     */
//    @ExcelProperty(value = {"收/付款方式",""})
    @ExcelProperty(value = {"支付方式"})
    private String inExWay;

    /**
     * 交易状态
     */
//    @ExcelProperty(value = {"交易状态", ""})
    @ExcelProperty(value = {"当前状态"})
    private String tradeStatus;

    /**
     * 交易订单号
     */
//    @ExcelProperty(value = {"交易订单号", ""})
    @ExcelProperty(value = {"交易单号"})
    private String tradeNo;

    /**
     * 商家订单号
     */
//    @ExcelProperty(value = {"商家订单号", ""})
    @ExcelProperty(value = {"商户单号"})
    private String merchantOrderNo;

    /**
     * 备注
     */
    @ExcelProperty(value = {"备注"})
    private String note;
}
