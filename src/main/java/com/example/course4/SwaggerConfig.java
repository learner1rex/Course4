package com.example.course4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {
//    Swagger的实例是Docket，所以我们需要通过Docket来配置Swagger
    @Bean
    public Docket createRestApi() {//配置文件
        return new Docket(DocumentationType.OAS_30).apiInfo(
                //配置文档信息
                new ApiInfoBuilder()
                        .contact(new Contact("puyinyu", "", "3212033431@qq.com"))
                        .title("学生信息管理系统API")
                        .build()
        );
    }
}
