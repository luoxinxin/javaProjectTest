package com.lxx.bill.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxx.bill.bean.AjaxResult;
import com.lxx.bill.bean.vo.BillStreamReqVO;
import com.lxx.bill.bean.vo.BillStreamRespVO;
import com.lxx.bill.bean.vo.DictTypeReqVO;
import com.lxx.bill.service.BillStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billStream")
public class BillStreamController {

    @Autowired
    private BillStreamService billStreamService;

    @RequestMapping("list")
    public AjaxResult list(BillStreamReqVO reqVO) {
        Page<BillStreamRespVO> page = billStreamService.listBillStream(reqVO);
        return AjaxResult.success(page);
    }

    @RequestMapping("udpate")
    public AjaxResult update(BillStreamReqVO reqVO) {
        boolean resp = billStreamService.updateBillType(reqVO);
        if (resp) {
            return AjaxResult.success();
        }else{
            return AjaxResult.error();
        }
    }
}
