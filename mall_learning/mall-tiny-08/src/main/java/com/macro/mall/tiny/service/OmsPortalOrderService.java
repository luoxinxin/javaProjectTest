package com.macro.mall.tiny.service;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

public interface OmsPortalOrderService {
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);
    @Transactional
    void cancelOrder(Long orderId);
}
