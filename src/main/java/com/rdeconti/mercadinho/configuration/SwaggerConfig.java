package com.rdeconti.mercadinho.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2

public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(getApiInfo());
    }

    // TODO CORRIGIR TEXTOS DA APi
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Contact Application API",
                "This is a sample Spring Boot RESTful service using SpringFox + Swagger 2",
                "V1",
                "urn:tos",
                new Contact("Dariawan", "https://www.dariawan.com", "hello@dariawan.com"),
                "CC BY-SA 3.0",
                "https://creativecommons.org/licenses/by-sa/3.0/",
                Collections.emptyList()
        );
    }
}
// TODO ELIMINAR
/*
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket mercadinhoParaleloApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rdeconti.mercadinho"))
                .build()
                .apiInfo(metaData());

    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("MERCADINHO PARALELO REST API")
                .description("\" Mercadinho Paralelo REST API documentation\"")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/js/**")
                .addResourceLocations("/js/")
                .addResourceLocations("/resources/**")
                .addResourceLocations("/static/**")
                .addResourceLocations("/css/**")
                .addResourceLocations("/images/**")
                .setCachePeriod(31556926);

    }
}

 */
