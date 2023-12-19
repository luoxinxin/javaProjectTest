package com.lxx.bill.service;

import com.lxx.bill.domain.CommonDictType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xinsilinwang
* @description 针对表【common_dict_type(通用字典)】的数据库操作Service
* @createDate 2023-12-18 09:33:41
*/
public interface CommonDictTypeService extends IService<CommonDictType> {

    String commonDictType(String dictType, String dictName, Long userId);

    String getStreamSource(String dictName);

    String getINEXType(String dictName);
}
