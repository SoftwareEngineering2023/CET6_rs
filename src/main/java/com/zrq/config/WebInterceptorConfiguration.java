package com.zrq.config;

import com.zrq.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * Created by zrq on 2018-4-26.
 */
//@Configuration
public class WebInterceptorConfiguration extends WebMvcConfigurationSupport {
    @Value("${interceptor.path.exclude}")
    private String[] excludePaths;
    @Value("${server.servlet.path}")
    private String path;

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //用户登录拦截器
        // .excludePathPatterns("/static/**")静态连接不做拦截
        registry.addInterceptor(loginInterceptor).addPathPatterns(path+"/**")// /**表示所有请求（即所有链接）
                .excludePathPatterns("res/**");//拦截
        super.addInterceptors(registry);
    }
}
