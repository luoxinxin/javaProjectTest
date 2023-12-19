package com.lxx.bill.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class DownloadData {
    /**
     * 交易时间
     */
    @ExcelProperty(value = {"交易时间"})
    private Date tradeTime;

    /**
     * 交易类型
     */
    @ExcelProperty(value = {"交易类型"})
    private Long tradeType;

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
    @ExcelProperty(value = {"商品说明", "商品"})
    private String goodsDescription;

    /**
     * 交易金额
     */
    @ExcelProperty(value = {"金额", "金额(元)"})
    private BigDecimal totalAmount;

    /**
     * 收入支出类型 0-支出 1-收入
     */
    @ExcelProperty(value = {"收/支"})
    private Long inExType;

    /**
     * 收/付款方式
     */
    @ExcelProperty(value = {"收/付款方式","支付方式"})
    private Long inExWay;

    /**
     * 交易状态
     */
    @ExcelProperty(value = {"交易状态", "当前状态"})
    private Long tradeStatus;

    /**
     * 交易订单号
     */
    @ExcelProperty(value = {"交易订单号", "交易单号"})
    private String tradeNo;

    /**
     * 商家订单号
     */
    @ExcelProperty(value = {"商家订单号", "商户单号"})
    private String merchantOrderNo;

    /**
     * 备注
     */
    private String note;

    /**
     * 流水来源 1-支付宝 2-微信
     */
    private Long streamSource;

    /**
     * 账单类型
     */
    private Long billType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
