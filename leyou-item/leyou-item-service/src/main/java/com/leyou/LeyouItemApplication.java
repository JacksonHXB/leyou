package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName LeyouItemApplication
 * @Description TODO
 * @Author Administrator
 * @Date 2019/7/28 0028 下午 8:23
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class LeyouItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeyouItemApplication.class, args);
    }
}
