package com.luoxinxin.mapper;

import com.luoxinxin.domain.SysOperLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author xinsilinwang
* @description 针对表【sys_oper_log(操作日志记录)】的数据库操作Mapper
* @createDate 2022-01-20 09:09:27
* @Entity com.luoxinxin.domain.SysOperLog
*/
@Mapper
public interface SysOperLogMapper extends BaseMapper<SysOperLog> {

}




