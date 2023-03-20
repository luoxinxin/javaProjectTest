package com.macro.mall.tiny.service;

import com.macro.mall.tiny.common.api.CommonResult;

public interface UmsMemberService {

    CommonResult generateAuthCode(String telephone);

    CommonResult verifyAuthCode(String telephone, String authCode);
}
