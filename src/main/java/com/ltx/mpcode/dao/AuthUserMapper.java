package com.ltx.mpcode.dao;

import com.ltx.mpcode.entity.AuthUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author lxx
 * @since 2024-04-29
 */
@Mapper
public interface AuthUserMapper extends BaseMapper<AuthUser> {
    selectByPrimaryKey(Integer id);

}
