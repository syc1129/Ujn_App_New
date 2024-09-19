package com.lssl.medical.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author : 黑渊白花
 * @ClassName Swagger
 * @date : 2024/9/19 18:31
 * @Description
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Medical-API")
                .apiInfo(webApiInfo())
                .select()
                .paths(PathSelectors.any())
                // .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                // .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();

    }
    private ApiInfo webApiInfo(){

        return new ApiInfoBuilder()
                .title("慧医数字医疗应用系统-API文档")
                .description("本文档描述了慧医数字医疗应用系统的接口定义")
                .version("1.0")
                .contact(new Contact("lssl","www.lssl.com","114514@qq.com"))
                .build();
    }
}
