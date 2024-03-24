package com.lxx.bill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxx.bill.domain.BillStream;
import com.lxx.bill.service.BillStreamService;
import com.lxx.bill.mapper.BillStreamMapper;
import org.springframework.stereotype.Service;

/**
* @author xinsilinwang
* @description 针对表【bill_stream(支付宝/微信流水记录)】的数据库操作Service实现
* @createDate 2023-12-17 07:51:51
*/
@Service
public class BillStreamServiceImpl extends ServiceImpl<BillStreamMapper, BillStream>
    implements BillStreamService{

}




