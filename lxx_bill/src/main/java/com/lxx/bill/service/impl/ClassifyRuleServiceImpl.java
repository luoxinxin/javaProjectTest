package com.lxx.bill.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxx.bill.component.RedisCache;
import com.lxx.bill.domain.ClassifyRule;
import com.lxx.bill.service.ClassifyRuleService;
import com.lxx.bill.mapper.ClassifyRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author xinsilinwang
* @description 针对表【classify_rule(归类规则)】的数据库操作Service实现
* @createDate 2023-12-20 14:28:13
*/
@Service
public class ClassifyRuleServiceImpl extends ServiceImpl<ClassifyRuleMapper, ClassifyRule>
    implements ClassifyRuleService{

    @Autowired
    private RedisCache redisCache;

    public List<ClassifyRule> getRuleClassifyName(Long userId) {
        String key = "";
        List<ClassifyRule> cacheList = redisCache.getCacheList(key);
        if (CollectionUtil.isEmpty(cacheList)) {
            QueryWrapper<ClassifyRule> query = new QueryWrapper<>();
            query.eq("user_id", userId);
            List<ClassifyRule> list = list(query);
            redisCache.setCacheList(key, list);
            redisCache.expire(key, 10);
            return list;
        }else{
            return cacheList;
        }


    }
}




