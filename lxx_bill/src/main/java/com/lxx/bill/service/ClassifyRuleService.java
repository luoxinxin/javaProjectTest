package com.lxx.bill.service;

import com.lxx.bill.domain.ClassifyRule;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author xinsilinwang
* @description 针对表【classify_rule(归类规则)】的数据库操作Service
* @createDate 2023-12-20 14:28:13
*/
public interface ClassifyRuleService extends IService<ClassifyRule> {

    List<ClassifyRule> getRuleClassifyName(Long userId);
}
