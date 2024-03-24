package com.lxx.bill.bean.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PayOutOrInComeReqVO {

    @NotNull
    private Integer year;

    @NotNull
    private Integer month;

    @NotNull
    private Integer startDay;

    @NotNull
    private Integer endDay;

    @NotNull
    private String typeName;

}
