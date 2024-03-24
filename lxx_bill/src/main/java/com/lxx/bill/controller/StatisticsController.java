package com.lxx.bill.controller;


import com.lxx.bill.bean.AjaxResult;
import com.lxx.bill.bean.vo.BillStreamReqVO;
import com.lxx.bill.bean.vo.PayOutOrInComeReqVO;
import com.lxx.bill.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
@CrossOrigin(origins = "http://localhost:5173/")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping("list")
    public AjaxResult list(BillStreamReqVO reqVO) {
        return AjaxResult.success();
    }

    /**
     * 自动过滤
     * @return
     */
    @RequestMapping("autoFilter")
    public AjaxResult autoFilter() {
        statisticsService.autoFilter("1", 0L);
        return AjaxResult.success();
    }

    /**
     * 自动分类
     * @return
     */
    @RequestMapping("autoClassify")
    public AjaxResult autoClassify() {
        statisticsService.autoClassify(0L);
        return AjaxResult.success();
    }

    /**
     * 收入或支出金额
     * @param reqVO
     * @return
     */
    @RequestMapping("payOutOrInCome")
    public AjaxResult payOutOrInCome(@RequestBody PayOutOrInComeReqVO reqVO) {
        return AjaxResult.success(statisticsService.payOutOrInCome(reqVO));
    }

    /**
     * 收入支出余额
     * @param reqVO
     * @return
     */
    @RequestMapping("incomeExpenditureBalance")
    public AjaxResult incomeExpenditureBalance(@RequestBody PayOutOrInComeReqVO reqVO) {
        return AjaxResult.success(statisticsService.incomeExpenditureBalance(reqVO));
    }

    /**
     * 年收入支出余额
     * @param reqVO
     * @return
     */
    @RequestMapping("monthIncomeExpenditureBalance")
    public AjaxResult monthIncomeExpenditureBalance(@RequestBody PayOutOrInComeReqVO reqVO) {
        return AjaxResult.success(statisticsService.monthIncomeExpenditureBalance(reqVO));
    }

}
