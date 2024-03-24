package com.lxx.bill.service;

import com.lxx.bill.bean.vo.IncomeExpenditureBalanceRespVO;
import com.lxx.bill.bean.vo.PayOutOrInComeReqVO;
import com.lxx.bill.bean.vo.StatisticsRespVO;
import com.lxx.bill.bean.vo.StatistiscReqVO;

import java.util.List;
import java.util.Map;

public interface StatisticsService {
    List<StatisticsRespVO> list(StatistiscReqVO reqVO);

    void autoClassify(Long userId);

    void autoFilter(String ruleObject, Long userId);

    Map<String, String> payOutOrInCome(PayOutOrInComeReqVO reqVO);
    IncomeExpenditureBalanceRespVO incomeExpenditureBalance(PayOutOrInComeReqVO reqVO);
    Map<Integer, IncomeExpenditureBalanceRespVO> monthIncomeExpenditureBalance(PayOutOrInComeReqVO reqVO);
}
