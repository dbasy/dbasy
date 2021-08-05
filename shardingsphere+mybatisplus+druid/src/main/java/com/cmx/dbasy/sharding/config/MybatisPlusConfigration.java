package com.cmx.dbasy.sharding.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wh
 * @Date: 2021/8/5 14:43
 */
@Configuration
@MapperScan("com.cmx.dbasy.sharding.mapper")
public class MybatisPlusConfigration {
}
