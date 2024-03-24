package com.lxx.bill.service.impl;
import java.util.Date;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxx.bill.bean.vo.BillStreamReqVO;
import com.lxx.bill.bean.vo.BillStreamRespVO;
import com.lxx.bill.constant.DictTypeConstants;
import com.lxx.bill.domain.BillStream;
import com.lxx.bill.service.BillStreamService;
import com.lxx.bill.mapper.BillStreamMapper;
import com.lxx.bill.service.CommonDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author xinsilinwang
* @description 针对表【bill_stream(支付宝/微信流水记录)】的数据库操作Service实现
* @createDate 2023-12-18 20:15:07
*/
@Service
public class BillStreamServiceImpl extends ServiceImpl<BillStreamMapper, BillStream>
    implements BillStreamService{

    @Autowired
    private CommonDictTypeService commonDictTypeService;

    @Override
    public Page<BillStreamRespVO> listBillStream(BillStreamReqVO reqVO) {
        QueryWrapper<BillStream> queryWrapper = new QueryWrapper<>();
// todo        queryWrapper.eq()
        Page<BillStream> list = this.page(new Page<>(reqVO.getPage(), reqVO.getPageSize()), queryWrapper);
        List<BillStreamRespVO> respVOList = list.getRecords().stream().map(v -> {
            BillStreamRespVO billStreamRespVO = new BillStreamRespVO();
            billStreamRespVO.setId(v.getId());
            billStreamRespVO.setTradeTime(v.getTradeTime());
            billStreamRespVO.setTradeType(commonDictTypeService.getDictTypeNameByCode(DictTypeConstants.DICT_TYPE_TRADE_TYPE, v.getTradeType(), null));
            billStreamRespVO.setTradeObject(v.getTradeObject());
            billStreamRespVO.setObjectNo(v.getObjectNo());
            billStreamRespVO.setGoodsDescription(v.getGoodsDescription());
            billStreamRespVO.setTotalAmount(v.getTotalAmount());
            billStreamRespVO.setBalance(v.getBalance());
            billStreamRespVO.setInExType(commonDictTypeService.getDictTypeNameByCode(DictTypeConstants.DICT_TYPE_IN_EX_TYPE, v.getTradeType(), null));
            billStreamRespVO.setInExWay(commonDictTypeService.getDictTypeNameByCode(DictTypeConstants.DICT_TYPE_IN_EX_WAY, v.getBillType(), 0L));
            billStreamRespVO.setTradeStatus(commonDictTypeService.getDictTypeNameByCode(DictTypeConstants.DICT_TYPE_TRADE_STATUS, v.getTradeStatus(), null));
            billStreamRespVO.setTradeNo(v.getTradeNo());
            billStreamRespVO.setMerchantOrderNo(v.getMerchantOrderNo());
            billStreamRespVO.setNote(v.getNote());
            billStreamRespVO.setStreamSource(commonDictTypeService.getDictTypeNameByCode(DictTypeConstants.DICT_TYPE_STREAM_SOURCE, v.getStreamSource(), null));
            billStreamRespVO.setBillType(v.getBillType());
            billStreamRespVO.setUserId(0L);
            billStreamRespVO.setCreateTime(new Date());
            billStreamRespVO.setUpdateTime(new Date());
            return billStreamRespVO;
        }).collect(Collectors.toList());
        Page<BillStreamRespVO> respVOPage = new Page<>();
        BeanUtil.copyProperties(list, respVOPage);
        respVOPage.setRecords(respVOList);
        return respVOPage;
    }

    @Override
    public boolean updateBillType(BillStreamReqVO reqVO) {
        BillStream billStream = new BillStream();
        billStream.setId(reqVO.getId());
        billStream.setBillType(reqVO.getBillType());
        billStream.setIgnoreStatus(reqVO.getIgnoreStatus());
        billStream.setUpdateTime(new Date());
        return saveOrUpdate(billStream);
    }
}




