package com.lxx.bill.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxx.bill.bean.vo.BillStreamReqVO;
import com.lxx.bill.bean.vo.BillStreamRespVO;
import com.lxx.bill.domain.BillStream;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xinsilinwang
* @description 针对表【bill_stream(支付宝/微信流水记录)】的数据库操作Service
* @createDate 2023-12-18 20:15:07
*/
public interface BillStreamService extends IService<BillStream> {

    Page<BillStreamRespVO> listBillStream(BillStreamReqVO reqVO);

    boolean updateBillType(BillStreamReqVO reqVO);
}
