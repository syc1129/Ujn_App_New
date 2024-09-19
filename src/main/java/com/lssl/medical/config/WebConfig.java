package com.lssl.medical.config;

import com.lssl.medical.intereception.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements  WebMvcConfigurer {
    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // 指定controller统一的接口前缀
        configurer.addPathPrefix("/api",
                clazz -> clazz.isAnnotationPresent(RestController.class));
    }
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //添加默认的静态资源访问路径
        registry.addResourceHandler("images/**")
                .addResourceLocations("file:D:/WebProjects/images/");
    }
    // 加自定义拦截器JwtInterceptor，设置拦截规则
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).
                addPathPatterns("/api/**").
                excludePathPatterns("/api/admin/login")
                .excludePathPatterns("/api/userInfo/**");
    }


}
