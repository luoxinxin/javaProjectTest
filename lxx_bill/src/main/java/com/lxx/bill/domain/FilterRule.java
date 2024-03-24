package com.lxx.bill.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 过滤/归类规则
 * @TableName filter_rule
 */
@TableName(value ="filter_rule")
@Data
public class FilterRule implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;


    /**
     * 规则对象 1-支付宝 2-微信 3-浦发 4-招商 5-中信
     */
    private String ruleObject;

    /**
     * 规则中文
     */
    private String ruleValue;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 来源
     */
    private String ruleFrom;

    /**
     * 状态 0-异常 1-正常
     */
    private Long status;

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