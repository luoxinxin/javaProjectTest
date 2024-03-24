package com.luoxinxin.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Hand implements Serializable {
    private static final long serialVersionUID = 816603200968798394L;
    private Integer size;
}
