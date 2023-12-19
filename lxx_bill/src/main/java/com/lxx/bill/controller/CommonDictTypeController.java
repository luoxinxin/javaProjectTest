package com.lxx.bill.controller;


import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lxx.bill.bean.AjaxResult;
import com.lxx.bill.bean.vo.DictTypeReqVO;
import com.lxx.bill.domain.CommonDictType;
import com.lxx.bill.service.CommonDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/dict/")
public class CommonDictTypeController {

    @Autowired
    private CommonDictTypeService commonDictTypeService;

    @RequestMapping("save")
    public AjaxResult saveDictType(DictTypeReqVO reqVO) {
        CommonDictType commonDictType = new CommonDictType();
        commonDictType.setUserId(0L);
        commonDictType.setDictType(reqVO.getDictType());
        commonDictType.setDictCode(StrUtil.isEmpty(reqVO.getDictCode()) ? IdUtil.fastSimpleUUID() : reqVO.getDictCode());
        commonDictType.setDictName(reqVO.getDictName());
        commonDictType.setStatus(1L);
        commonDictType.setCreateTime(new Date());
        commonDictType.setUpdateTime(new Date());
        commonDictTypeService.save(commonDictType);
        return AjaxResult.success();
    }

    @RequestMapping("update")
    public AjaxResult updateDictType(DictTypeReqVO reqVO) {
        CommonDictType commonDictType = new CommonDictType();
        commonDictType.setUserId(0L);
        commonDictType.setDictType(reqVO.getDictType());
        commonDictType.setDictName(reqVO.getDictName());
        commonDictType.setUpdateTime(new Date());
        commonDictTypeService.updateById(commonDictType);
        return AjaxResult.success();
    }

    @RequestMapping("delete")
    public AjaxResult deleteDictType(DictTypeReqVO reqVO) {
        CommonDictType commonDictType = new CommonDictType();
        commonDictType.setUserId(0L);
        commonDictType.setDictType(reqVO.getDictType());
        commonDictType.setStatus(0L);
        commonDictType.setUpdateTime(new Date());
        commonDictTypeService.updateById(commonDictType);
        return AjaxResult.success();
    }

    @RequestMapping("list")
    public AjaxResult listDictType(DictTypeReqVO reqVO) {
        QueryWrapper<CommonDictType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_type", reqVO.getDictType())
                .eq("status", 1L)
                .eq("user_id", 0L);
        List<CommonDictType> list = commonDictTypeService.list(queryWrapper);
        return AjaxResult.success();
    }

}
