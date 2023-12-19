package com.lxx.bill.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 通用字典
 * @TableName common_dict_type
 */
@TableName(value ="common_dict_type")
@Data
public class CommonDictType implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 字典code
     */
    private String dictCode;

    /**
     * 字典中文
     */
    private String dictName;

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