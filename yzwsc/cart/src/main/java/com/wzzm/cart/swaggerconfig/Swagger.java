package com.wzzm.cart.swaggerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wzzm.cart.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private  ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("swaggerconfig")
                .description("更多详情访问我的github：https://github.com/wangnian666/")
                .termsOfServiceUrl("https://github.com/wangnian666/")
                .contact("liangxu")
                .version("1.0")
                .build();
    }
}
