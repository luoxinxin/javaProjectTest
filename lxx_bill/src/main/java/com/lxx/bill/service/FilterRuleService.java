package com.lxx.bill.service;

import com.lxx.bill.domain.FilterRule;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author xinsilinwang
* @description 针对表【filter_rule(过滤/归类规则)】的数据库操作Service
* @createDate 2023-12-20 14:30:30
*/
public interface FilterRuleService extends IService<FilterRule> {

    List<String> getFilterRule(String ruleObject, Long userId);

}
