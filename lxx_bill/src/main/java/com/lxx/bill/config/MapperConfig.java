package com.lxx.bill.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.lxx.bill.mapper")
public class MapperConfig {

}
