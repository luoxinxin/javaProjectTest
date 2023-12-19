package com.lxx.bill.bean.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class DictTypeReqVO {

    /**
     * 字典类型
     */
    @NotBlank(message = "字典类型不能为空")
    private String dictType;

    /**
     * 字典code
     */
    private String dictCode;

    /**
     * 字典中文
     */
    @NotBlank(message = "字典中文不能为空")
    private String dictName;

    /**
     * 状态 0-异常 1-正常
     */
    private Long status;

}
