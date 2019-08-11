package com.leyou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


//跨域请求配置,这里的CORS是专门处理图片的跨域问题的
@Configuration
public class LeyouCorsConfiguration {

	@Bean
	public CorsFilter corsFilter() {
		
		//初始化cors配置对象
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedOrigin("http://manage.leyou.com");//设置域名，如果不携带cookie可以设置为任意域名“*”
		configuration.setAllowCredentials(true);//允许是否携带cookie， 当为true时，头信息必须是具体的域名manage.leyou.com
		configuration.addAllowedMethod("*");//允许任意请求方式，包括PUT DELETE HEAD等请求
		configuration.addAllowedHeader("*");//允许携带任何头信息
		
		//初始化cors配置源对象
		UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
		configurationSource.registerCorsConfiguration("/**", configuration);
		
		
		//返回corsFilter实例，参数：cors配置源对象
		return new CorsFilter(configurationSource);
	}
}




























