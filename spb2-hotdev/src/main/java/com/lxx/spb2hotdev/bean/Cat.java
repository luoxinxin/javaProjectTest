package com.lxx.spb2hotdev.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat {


    /**
     * 名字
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;

    @DecimalMin(value = "0.00", inclusive = false, message = "价格不能小于0")
    @DecimalMax(value = "100000", inclusive = true, message = "价格不能大于100000")
    private BigDecimal price;
}
