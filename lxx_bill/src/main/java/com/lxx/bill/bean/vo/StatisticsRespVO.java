package com.lxx.bill.bean.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付宝/微信流水记录
 * @TableName bill_stream
 */
@Data
public class StatisticsRespVO implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 交易时间
     */
    private Date tradeTime;

    /**
     * 交易类型
     */
    private String tradeType;

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
     * 余额
     */
    private BigDecimal balance;

    /**
     * 收入支出类型
     */
    private String inExType;

    /**
     * 收/付款方式
     */
    private String inExWay;

    /**
     * 交易状态
     */
    private String tradeStatus;

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
     * 流水来源
     */
    private String streamSource;

    /**
     * 账单类型
     */
    private String billType;

    /**
     * 用户id
     */
    private Long userId;

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