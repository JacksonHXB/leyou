package com.leyou;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.purge.starter.dispose.annotation.EnableGlobalDispose;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * @ClassName LeyouItemApplication
 * @Description TODO
 * @Author Administrator
 * @Date 2019/7/28 0028 下午 8:23
 * @Version 1.0
 **/
@EnableSwagger2
@SpringBootApplication
@EnableDiscoveryClient
//@EnableGlobalDispose        //第三方自定义全局返回结果处理
@MapperScan("com.leyou.item.mapper")
public class LeyouItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeyouItemApplication.class, args);
    }
}
