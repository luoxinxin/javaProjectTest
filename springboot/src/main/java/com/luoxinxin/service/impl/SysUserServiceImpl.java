package com.luoxinxin.service.impl;

import com.luoxinxin.domain.SysUser;
import com.luoxinxin.mapper.SysUserMapper;
import com.luoxinxin.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements ISysUserService
{
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 查询用户信息
     *
     * @param userId 用户信息主键
     * @return 用户信息
     */
    @Override
    public SysUser selectSysUserByUserId(Long userId)
    {
        return sysUserMapper.selectSysUserByUserId(userId);
    }

    /**
     * 查询用户信息列表
     *
     * @param sysUser 用户信息
     * @return 用户信息
     */
    @Override
    public List<SysUser> selectSysUserList(SysUser sysUser)
    {
        return sysUserMapper.selectSysUserList(sysUser);
    }

    /**
     * 新增用户信息
     *
     * @param sysUser 用户信息
     * @return 结果
     */
    @Override
    public int insertSysUser(SysUser sysUser)
    {
        //sysUser.setCreateTime(new Date());
        return sysUserMapper.insertSysUser(sysUser);
    }

    /**
     * 修改用户信息
     *
     * @param sysUser 用户信息
     * @return 结果
     */
    @Override
    public int updateSysUser(SysUser sysUser)
    {
        //sysUser.setUpdateTime(DateUtils.getNowDate());
        return sysUserMapper.updateSysUser(sysUser);
    }

    /**
     * 批量删除用户信息
     *
     * @param userIds 需要删除的用户信息主键
     * @return 结果
     */
    @Override
    public int deleteSysUserByUserIds(Long[] userIds)
    {
        return sysUserMapper.deleteSysUserByUserIds(userIds);
    }

    /**
     * 删除用户信息信息
     *
     * @param userId 用户信息主键
     * @return 结果
     */
    @Override
    public int deleteSysUserByUserId(Long userId)
    {
        return sysUserMapper.deleteSysUserByUserId(userId);
    }
}