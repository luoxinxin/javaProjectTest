package com.ltx.mpcode.service.impl;

import com.ltx.mpcode.entity.AuthUser;
import com.ltx.mpcode.dao.AuthUserMapper;
import com.ltx.mpcode.service.AuthUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author lxx
 * @since 2024-04-29
 */
@Service
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser> implements AuthUserService {

}
