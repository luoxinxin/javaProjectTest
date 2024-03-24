package com.lxx.bill.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lxx.bill.bean.vo.IncomeExpenditureBalanceRespVO;
import com.lxx.bill.bean.vo.PayOutOrInComeReqVO;
import com.lxx.bill.bean.vo.StatisticsRespVO;
import com.lxx.bill.bean.vo.StatistiscReqVO;
import com.lxx.bill.constant.Constants;
import com.lxx.bill.constant.DictTypeConstants;
import com.lxx.bill.domain.BillStream;
import com.lxx.bill.domain.ClassifyRule;
import com.lxx.bill.mapper.BillStreamMapper;
import com.lxx.bill.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private BillStreamMapper billStreamMapper;

    @Autowired
    BillStreamService billStreamService;

    @Autowired
    private CommonDictTypeService commonDictTypeService;

    @Autowired
    private FilterRuleService filterRuleService;

    @Autowired
    private ClassifyRuleService classifyRuleService;

    public List<StatisticsRespVO> list(StatistiscReqVO reqVO){
        QueryWrapper<BillStream> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", reqVO.getUserId())
                .eq("status", Constants.STATUS_NORMAL)
                .eq("ignore", Constants.STATUS_NORMAL)
//                .ge("trade_time", DateUtil.offsetDay(new Date(), 1).getTime())
//                .le("trade_time", DateUtil.offsetDay(new Date(), 0).getTime())
        ;
        billStreamService.list(queryWrapper);
        return null;
    }

    public Map<String, String> payOutOrInCome(PayOutOrInComeReqVO reqVO){
        LocalDateTime startLocalTime;
        LocalDateTime stopLocalTime;
        Integer month = reqVO.getMonth();
        Integer year = reqVO.getYear();
        String typeName = reqVO.getTypeName();

        if(month != null){
            // 假设你有一个 LocalDateTime 对象，只有年和月
            LocalDateTime localDateTime = LocalDateTime.of(year, month, 1, 0, 0);
            // 获取该月的开始日期
            startLocalTime = localDateTime.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
            // 获取该月的结束日期
            stopLocalTime = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(59);
        }else{
            // 假设你有一个 LocalDateTime 对象，只有年和月
            LocalDateTime localDateTime = LocalDateTime.of(year, 1, 1, 0, 0);
            // 获取该月的开始日期
            startLocalTime = localDateTime.withDayOfYear(1).withHour(0).withMinute(0).withSecond(0);
            // 获取该月的结束日期
            stopLocalTime = localDateTime.with(TemporalAdjusters.lastDayOfYear()).withHour(23).withMinute(59).withSecond(59);
        }

        String inExType = commonDictTypeService.getDictTypeCodeByName(DictTypeConstants.DICT_TYPE_IN_EX_TYPE, typeName, 0L);
        Map<String, Object> map = commonDictTypeService.getDictTypeNameMapByCode(DictTypeConstants.DICT_TYPE_TRADE_TYPE, 0L);
        QueryWrapper<BillStream> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("user_id", 0L)
                .eq("ignore_status", Constants.STATUS_NORMAL)
                .eq("in_ex_type", inExType)
                .ge("trade_time", startLocalTime)
                .le("trade_time", stopLocalTime)
        ;
        List<BillStream> list = billStreamService.list(queryWrapper);
        Map<String, String> result = list.stream()
                .collect(Collectors.groupingBy(
                        v-> {
                        if(StrUtil.isNotEmpty(v.getBillType())){
                            return v.getBillType();
                        }else{
                            return (String)map.get(v.getTradeType());
                        }
                    },
                        Collectors.reducing(BigDecimal.ZERO, BillStream::getTotalAmount, BigDecimal::add)))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().toString()));
        return result;
    }

    public IncomeExpenditureBalanceRespVO incomeExpenditureBalance(PayOutOrInComeReqVO reqVO){
        LocalDateTime startLocalTime;
        LocalDateTime stopLocalTime;
        Integer month = reqVO.getMonth();
        Integer year = reqVO.getYear();

        if(month != null){
            // 假设你有一个 LocalDateTime 对象，只有年和月
            LocalDateTime localDateTime = LocalDateTime.of(year, month, 1, 0, 0);
            // 获取该月的开始日期
            startLocalTime = localDateTime.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
            // 获取该月的结束日期
            stopLocalTime = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(59);
        }else{
            // 假设你有一个 LocalDateTime 对象，只有年和月
            LocalDateTime localDateTime = LocalDateTime.of(year, 1, 1, 0, 0);
            // 获取该月的开始日期
            startLocalTime = localDateTime.withDayOfYear(1).withHour(0).withMinute(0).withSecond(0);
            // 获取该月的结束日期
            stopLocalTime = localDateTime.with(TemporalAdjusters.lastDayOfYear()).withHour(23).withMinute(59).withSecond(59);
        }

        Map<String, Object> map = commonDictTypeService.getDictTypeNameMapByCode(DictTypeConstants.DICT_TYPE_IN_EX_TYPE, 0L);

        QueryWrapper<BillStream> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("user_id", 0L)
                .eq("ignore_status", Constants.STATUS_NORMAL)
                .ge("trade_time", startLocalTime)
                .le("trade_time", stopLocalTime)
        ;
        List<BillStream> list = billStreamService.list(queryWrapper);
        Map<String, String> inExTypeMap = list.stream().collect(Collectors.groupingBy(v-> (String)map.get(v.getInExType()), Collectors.reducing(BigDecimal.ZERO, BillStream::getTotalAmount, BigDecimal::add)))
                .entrySet().stream().collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().toString()
                ));
        IncomeExpenditureBalanceRespVO respVO = new IncomeExpenditureBalanceRespVO();
        respVO.setInComeAmount(inExTypeMap.get("收入"));
        respVO.setPayOutAmount(inExTypeMap.get("支出"));
        respVO.setBalance(NumberUtil.toStr(NumberUtil.toBigDecimal(inExTypeMap.get("收入")).subtract(NumberUtil.toBigDecimal(inExTypeMap.get("支出")))));
        return respVO;
    }

    public Map<Integer,IncomeExpenditureBalanceRespVO> monthIncomeExpenditureBalance(PayOutOrInComeReqVO reqVO){
        LocalDateTime startLocalTime;
        LocalDateTime stopLocalTime;
        Integer year = reqVO.getYear();

        // 假设你有一个 LocalDateTime 对象，只有年和月
        LocalDateTime localDateTime = LocalDateTime.of(year, 1, 1, 0, 0);
        // 获取该月的开始日期
        startLocalTime = localDateTime.withDayOfYear(1).withHour(0).withMinute(0).withSecond(0);
        // 获取该月的结束日期
        stopLocalTime = localDateTime.with(TemporalAdjusters.lastDayOfYear()).withHour(23).withMinute(59).withSecond(59);


        Map<String, Object> map = commonDictTypeService.getDictTypeNameMapByCode(DictTypeConstants.DICT_TYPE_IN_EX_TYPE, 0L);

        QueryWrapper<BillStream> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("user_id", 0L)
                .eq("ignore_status", Constants.STATUS_NORMAL)
                .ge("trade_time", startLocalTime)
                .le("trade_time", stopLocalTime)
        ;
        List<BillStream> list = billStreamService.list(queryWrapper);
        Map<String, String> inExTypeMap = list.stream().collect(Collectors.groupingBy(v-> (String)map.get(v.getInExType()), Collectors.reducing(BigDecimal.ZERO, BillStream::getTotalAmount, BigDecimal::add)))
                .entrySet().stream().collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().toString()
                ));
        Map<Integer, Map<String, BigDecimal>> monthInExTypeMap = list.stream().collect(Collectors.groupingBy(v -> v.getTradeTime().getMonth()+1, Collectors.groupingBy(v -> (String) map.get(v.getInExType()), Collectors.reducing(BigDecimal.ZERO, BillStream::getTotalAmount, BigDecimal::add))));
//        Map<Integer, Map<String, BigDecimal>> monthInExTypeMap = new HashMap<>();
//                monthInExTypeMap.entrySet().stream().map(v -> {
//            Map<String, BigDecimal> map1 = v.getValue();
//            IncomeExpenditureBalanceRespVO respVO = new IncomeExpenditureBalanceRespVO();
//            BigDecimal income = map1.get("收入") == null ? BigDecimal.ZERO : map1.get("收入");
//            BigDecimal payOut = map1.get("支出") == null? BigDecimal.ZERO : map1.get("支出");
//            respVO.setInComeAmount(NumberUtil.toStr(income));
//            respVO.setInComeAmount(NumberUtil.toStr(payOut));
//            respVO.setBalance(NumberUtil.toStr(NumberUtil.sub(income, payOut)));
//            return respVO;
//        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))

        Map<Integer, IncomeExpenditureBalanceRespVO> result = monthInExTypeMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            Map<String, BigDecimal> map1 = entry.getValue();
                            IncomeExpenditureBalanceRespVO respVO = new IncomeExpenditureBalanceRespVO();
                            BigDecimal income = map1.get("收入") == null ? BigDecimal.ZERO : map1.get("收入");
                            BigDecimal payOut = map1.get("支出") == null ? BigDecimal.ZERO : map1.get("支出");
                            respVO.setInComeAmount(NumberUtil.toStr(income));
                            respVO.setPayOutAmount(NumberUtil.toStr(payOut));
                            respVO.setBalance(NumberUtil.toStr(NumberUtil.sub(income, payOut)));
                            return respVO;
                        }
                ));
        TreeMap<Integer, IncomeExpenditureBalanceRespVO> stringIncomeExpenditureBalanceRespVOTreeMap = new TreeMap<>(result);


//        List<IncomeExpenditureBalanceRespVO> collect = monthInExTypeMap.values().stream().map(v -> {
//            IncomeExpenditureBalanceRespVO respVO = new IncomeExpenditureBalanceRespVO();
//            respVO.setInComeAmount(String.valueOf(v.get("收入")));
//            respVO.setPayOutAmount(String.valueOf(v.get("支出")));
//            respVO.setBalance(NumberUtil.toStr(NumberUtil.sub(v.get("收入"), v.get("支出"))));
//            return respVO;
//        }).collect(Collectors.toList());
//
//
//        IncomeExpenditureBalanceRespVO respVO = new IncomeExpenditureBalanceRespVO();
//        respVO.setInComeAmount(inExTypeMap.get("收入"));
//        respVO.setPayOutAmount(inExTypeMap.get("支出"));
//        respVO.setBalance(NumberUtil.toStr(NumberUtil.toBigDecimal(inExTypeMap.get("收入")).subtract(NumberUtil.toBigDecimal(inExTypeMap.get("支出")))));
        return stringIncomeExpenditureBalanceRespVOTreeMap;
    }


    public void autoClassify(Long userId){
        QueryWrapper<BillStream> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<BillStream> list = billStreamService.list(queryWrapper);
        markClassify(list);
    }

    public void autoFilter(String ruleObject, Long userId){
        QueryWrapper<BillStream> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<BillStream> list = billStreamService.list(queryWrapper);
        markClassify(list);
        markFilter(list, ruleObject);
    }

    /**
     * 标记过滤
     * @param billStreams 流水
     * @param ruleObject 规则对象(流水来源)
     * @return
     */
    public void markFilter(List<BillStream> billStreams, String ruleObject){
        Map<String, Object> tradeTypeNameMap = commonDictTypeService.getDictTypeNameMapByCode(DictTypeConstants.DICT_TYPE_TRADE_TYPE, null);
        List<String> filterRules = filterRuleService.getFilterRule(ruleObject, 0L);
        List<BillStream> billStreamsUpdates = new ArrayList<>();
        billStreams.stream().forEach(v -> {
            String tradeTypeName = (String) tradeTypeNameMap.get(v.getTradeType());
            if(filterRules.contains(tradeTypeName)){
                v.setIgnoreStatus(1);
                v.setUpdateTime(new Date());
                billStreamsUpdates.add(v);
            }
        });
        billStreamService.updateBatchById(billStreamsUpdates);
    }

    /**
     * 标记分类
     * @param billStreams 流水
     * @return
     */
    public void markClassify(List<BillStream> billStreams){
        List<BillStream> billStreamsUpdates = new ArrayList<>();
        List<ClassifyRule> classifyRules = classifyRuleService.getRuleClassifyName(0L);
        Map<String, String> classifyRuleMap = classifyRules.stream().collect(Collectors.toMap(ClassifyRule::getRuleTradeCode, v -> v.getRuleClassifyName()));
        billStreams.stream().forEach(v -> {
            v.setBillType(classifyRuleMap.get(v.getTradeType()));
            v.setUpdateTime(new Date());
        });
        billStreamService.updateBatchById(billStreamsUpdates);
    }


}
