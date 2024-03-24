package com.lxx.spb2hotdev.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxx.spb2hotdev.domain.Students;
import com.lxx.spb2hotdev.service.StudentsService;
import com.lxx.spb2hotdev.mapper.StudentsMapper;
import org.springframework.stereotype.Service;

/**
* @author xinsilinwang
* @description 针对表【Students】的数据库操作Service实现
* @createDate 2023-12-04 13:42:01
*/
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students>
    implements StudentsService{

}




