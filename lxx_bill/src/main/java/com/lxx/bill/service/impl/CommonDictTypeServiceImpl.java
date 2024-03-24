package com.lxx.bill.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxx.bill.component.RedisCache;
import com.lxx.bill.constant.DictTypeConstants;
import com.lxx.bill.domain.CommonDictType;
import com.lxx.bill.domain.InExType;
import com.lxx.bill.service.CommonDictTypeService;
import com.lxx.bill.mapper.CommonDictTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author xinsilinwang
* @description 针对表【common_dict_type(通用字典)】的数据库操作Service实现
* @createDate 2023-12-18 09:33:41
*/
@Service
public class CommonDictTypeServiceImpl extends ServiceImpl<CommonDictTypeMapper, CommonDictType>
    implements CommonDictTypeService{

    @Autowired
    private RedisCache redisCache;

    private static final String COMMON_REDIS_KEY_PREFIX = "Common_Dict_Type:";
    private static final String CODE_BY_NAME = "code_by_name:";
    private static final String NAME_BY_CODE = "name_by_code:";

    /**
     * 通用字典
     * @param dictType
     * @param dictName
     * @param dictFrom
     * @param userId
     * @return
     */
    public String insertCommonDictType(String dictType, String dictName, String dictFrom, Long userId) {
        if (userId == null) {
            userId = 0L;
        }
        String key = COMMON_REDIS_KEY_PREFIX.concat(CODE_BY_NAME).concat(dictType).concat(":").concat(String.valueOf(userId));
        Map<String, Object> cacheMap = redisCache.getCacheMap(key);
        if(CollectionUtil.isEmpty(cacheMap)){
            QueryWrapper<CommonDictType> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", userId).eq("dict_type", dictType);
            this.list(queryWrapper).forEach(v -> {
                cacheMap.put(v.getDictName(), v.getDictCode());
            });
            redisCache.setCacheMap(key, cacheMap);
            redisCache.expire(key, 24*60*60);
        }
        if (cacheMap.containsKey(dictName)) {
            return cacheMap.get(dictName).toString();
        } else {
            String dictCode = IdUtil.fastSimpleUUID();
            CommonDictType commonDictType = new CommonDictType();
            commonDictType.setDictType(dictType);
            commonDictType.setDictCode(dictCode);
            commonDictType.setDictName(dictName);
            commonDictType.setStatus(1L);
            commonDictType.setCreateTime(new Date());
            commonDictType.setUpdateTime(new Date());
            commonDictType.setUserId(userId);
            commonDictType.setDictFrom(dictFrom);
            this.save(commonDictType);
            cacheMap.put(dictName, dictCode);
            redisCache.setCacheMap(key, cacheMap);
            redisCache.expire(key, 24*60*60);
            return dictCode;
        }
    }

    /**
     * 获取流水来源字典
     * @param dictName
     * @return
     */
    public String getStreamSource(String dictName){
        QueryWrapper<CommonDictType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_type", DictTypeConstants.DICT_TYPE_STREAM_SOURCE)
                .eq("dict_name", dictName);
        List<CommonDictType> list = list(queryWrapper);
        if(!list.isEmpty()){
            return list.get(0).getDictCode();
        }
        return null;
    }




    @Override
    public Map<String, Object> getDictTypeCodeMapByName(String dictType, Long userId) {
        if (userId == null) {
            userId = 0L;
        }
        String key = COMMON_REDIS_KEY_PREFIX.concat(CODE_BY_NAME).concat(dictType).concat(":").concat(String.valueOf(userId));
        Map<String, Object> cacheMap = redisCache.getCacheMap(key);
        if(CollectionUtil.isEmpty(cacheMap)){
            QueryWrapper<CommonDictType> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", userId).eq("dict_type", dictType);
            this.list(queryWrapper).forEach(v -> {
                cacheMap.put(v.getDictName(), v.getDictCode());
            });
            redisCache.setCacheMap(key, cacheMap);
            redisCache.expire(key, 24*60*60);
        }
        return cacheMap;
    }

    @Override
    public Map<String, Object> getDictTypeNameMapByCode(String dictType, Long userId) {
        if (userId == null) {
            userId = 0L;
        }
        String key = COMMON_REDIS_KEY_PREFIX.concat(NAME_BY_CODE).concat(dictType).concat(":").concat(String.valueOf(userId));
        Map<String, Object> cacheMap = redisCache.getCacheMap(key);
        if(CollectionUtil.isEmpty(cacheMap)){
            QueryWrapper<CommonDictType> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", userId).eq("dict_type", dictType);
            this.list(queryWrapper).forEach(v -> {
                cacheMap.put(v.getDictCode(), v.getDictName());
            });
            redisCache.setCacheMap(key, cacheMap);
            redisCache.expire(key, 24*60*60);
        }
        return cacheMap;
    }


    @Override
    public String getDictTypeCodeByName(String dictType, String typeName, Long userId) {
        if (userId == null) {
            userId = 0L;
        }
        String key = COMMON_REDIS_KEY_PREFIX.concat(CODE_BY_NAME).concat(dictType).concat(":").concat(String.valueOf(userId));
        Map<String, Object> cacheMap = redisCache.getCacheMap(key);
        if(CollectionUtil.isEmpty(cacheMap)){
            QueryWrapper<CommonDictType> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", userId).eq("dict_type", dictType);
            this.list(queryWrapper).forEach(v -> {
                cacheMap.put(v.getDictName(), v.getDictCode());
            });
            redisCache.setCacheMap(key, cacheMap);
            redisCache.expire(key, 24*60*60);
        }
        return (String)cacheMap.get(typeName);

    }

    @Override
    public String getDictTypeNameByCode(String dictType, String typeCode, Long userId) {
        if (userId == null) {
            userId = 0L;
        }
        String key = COMMON_REDIS_KEY_PREFIX.concat(NAME_BY_CODE).concat(dictType).concat(":").concat(String.valueOf(userId));
        Map<String, Object> cacheMap = redisCache.getCacheMap(key);
        if(CollectionUtil.isEmpty(cacheMap)){
            QueryWrapper<CommonDictType> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", userId).eq("dict_type", dictType);
            this.list(queryWrapper).forEach(v -> {
                cacheMap.put(v.getDictCode(), v.getDictName());
            });
            redisCache.setCacheMap(key, cacheMap);
            redisCache.expire(key, 24*60*60);
        }
        return (String) cacheMap.get(typeCode);
    }


}




