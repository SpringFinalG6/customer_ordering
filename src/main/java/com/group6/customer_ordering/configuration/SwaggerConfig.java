package com.group6.customer_ordering.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Spring")
                        .version("1.0.0")
                        .description("Spring")
                        .termsOfService("#")
                        .license(new License().name("#").url("#"))
                );
    }


}
