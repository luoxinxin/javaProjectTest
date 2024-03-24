package com.lxx.bill.service;

import com.lxx.bill.domain.CommonDictType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author xinsilinwang
* @description 针对表【common_dict_type(通用字典)】的数据库操作Service
* @createDate 2023-12-18 09:33:41
*/
public interface CommonDictTypeService extends IService<CommonDictType> {

    String insertCommonDictType(String dictType, String dictName, String dictFrom, Long userId);

    String getStreamSource(String dictName);

    Map<String, Object> getDictTypeCodeMapByName(String dictType, Long userId);
    String getDictTypeCodeByName(String dictType, String typeName, Long userId);
    Map<String, Object> getDictTypeNameMapByCode(String dictType, Long userId);
    String getDictTypeNameByCode(String dictType, String typeCode, Long userId);
}
