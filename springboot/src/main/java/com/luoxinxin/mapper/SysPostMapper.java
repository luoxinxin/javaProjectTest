package com.luoxinxin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luoxinxin.domain.SysPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author xinsilinwang
* @description 针对表【sys_post(岗位信息表)】的数据库操作Mapper
* @createDate 2022-01-20 08:55:19
* @Entity com.luoxinxin.domain.SysPost
*/
@Mapper
public interface SysPostMapper extends BaseMapper<SysPost> {

    List<SysPost> selectAllByPostId(@Param("postId") Long postId);
}




