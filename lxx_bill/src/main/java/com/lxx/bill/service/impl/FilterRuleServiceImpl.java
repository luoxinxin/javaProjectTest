package com.lxx.bill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxx.bill.domain.FilterClassifyRule;
import com.lxx.bill.domain.FilterRule;
import com.lxx.bill.service.FilterRuleService;
import com.lxx.bill.mapper.FilterRuleMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author xinsilinwang
* @description 针对表【filter_rule(过滤/归类规则)】的数据库操作Service实现
* @createDate 2023-12-20 14:30:30
*/
@Service
public class FilterRuleServiceImpl extends ServiceImpl<FilterRuleMapper, FilterRule>
    implements FilterRuleService{

    public List<String> getFilterRule(String ruleObject, Long userId){
        QueryWrapper<FilterRule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId)
                .eq("rule_object", ruleObject);
        return this.list(queryWrapper).stream().map(FilterRule::getRuleValue).collect(Collectors.toList());
    }
}




