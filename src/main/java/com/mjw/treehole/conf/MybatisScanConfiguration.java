package com.mjw.treehole.conf;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
 
/**
 * 配置Mapper的扫描包路径 
 */
@Configuration
@MapperScan("com.mjw.treehole.mapper")
public class MybatisScanConfiguration {

}
