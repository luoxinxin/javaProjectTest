package com.lxx.bill.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 支付宝/微信流水记录
 * @TableName bill_stream
 */
@TableName(value ="bill_stream")
@Data
public class BillStream implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 交易时间
     */
    private Date tradeTime;

    /**
     * 交易类型
     */
    private Long tradeType;

    /**
     * 交易对象
     */
    private String tradeObject;

    /**
     * 交易对象编号
     */
    private String objectNo;

    /**
     * 商品描述
     */
    private String goodsDescription;

    /**
     * 交易金额
     */
    private BigDecimal totalAmount;

    /**
     * 收入支出类型 0-支出 1-收入
     */
    private Long inExType;

    /**
     * 收/付款方式
     */
    private Long inExWay;

    /**
     * 交易状态
     */
    private Long tradeStatus;

    /**
     * 交易订单号
     */
    private String tradeNo;

    /**
     * 商家订单号
     */
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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}