package com.luoxinxin.mapper;

import com.luoxinxin.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {
    /**
     * 查询用户信息
     *
     * @param userId 用户信息主键
     * @return 用户信息
     */
    public SysUser selectSysUserByUserId(Long userId);

    /**
     * 查询用户信息列表
     *
     * @param sysUser 用户信息
     * @return 用户信息集合
     */
    public List<SysUser> selectSysUserList(SysUser sysUser);

    /**
     * 新增用户信息
     *
     * @param sysUser 用户信息
     * @return 结果
     */
    public int insertSysUser(SysUser sysUser);

    /**
     * 修改用户信息
     *
     * @param sysUser 用户信息
     * @return 结果
     */
    public int updateSysUser(SysUser sysUser);

    /**
     * 删除用户信息
     *
     * @param userId 用户信息主键
     * @return 结果
     */
    public int deleteSysUserByUserId(Long userId);

    /**
     * 批量删除用户信息
     *
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysUserByUserIds(Long[] userIds);
}
