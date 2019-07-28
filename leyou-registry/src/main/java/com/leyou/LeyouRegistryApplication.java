package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName LeyouRegistryApplication
 * @Description 服务注册中心
 * @Author Administrator
 * @Date 2019/7/28 0028 下午 4:43
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaServer
public class LeyouRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeyouRegistryApplication.class, args);
    }
}
