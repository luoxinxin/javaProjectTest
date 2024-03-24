package com.lxx.bill.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 归类规则
 * @TableName classify_rule
 */
@TableName(value ="classify_rule")
@Data
public class ClassifyRule implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 交易类型字典code
     */
    private String ruleTradeCode;

    /**
     * 交易类型字典中文
     */
    private String ruleTradeType;

    /**
     * 分类后类型中文
     */
    private String ruleClassifyName;

    /**
     * 用户id
     */
    private Long userId;

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