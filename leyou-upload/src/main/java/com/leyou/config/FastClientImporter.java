package com.leyou.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

import com.github.tobato.fastdfs.FdfsClientConfig;

/**
 * @Author JacksonDemo
 * @Time 2019年8月11日 下午5:22:39
 * @Description: fastDFS分布式文件系统配置类
 */
@Configuration
@Import(FdfsClientConfig.class)
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)   //解决JMX重复注册bean的问题
public class FastClientImporter {

}































































