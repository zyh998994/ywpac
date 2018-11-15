package com.wzzm.show;

import com.mangofactory.swagger.plugin.EnableSwagger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.wzzm.show.cn.dao")
@EnableSwagger2
public class ShowApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowApplication.class, args);
    }
}
