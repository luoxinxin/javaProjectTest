package com.lxx.bill.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class IncomeExpenditureBalanceRespVO {

    /**
     * 收入
     */
    private String inComeAmount;
    /**
     * 支出
     */
    private String payOutAmount;

    /**
     * 余额
     */
    private String balance;
}
