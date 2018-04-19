package com.rafael.cr.swagger.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class Swagger2Configuration.
 *
 * @author carpinteyror
 * @version 1.1
 * @since 18/04/2018 (update)
 */
@EnableSwagger2
@Configuration
public class Swagger2Configuration {
	
	@Value("${spring.application.name}")
	private String applicationName;

	/**
     * Create Swagger Api configuration
     * 
     * @author carpinteyror
     * @return Swagger Docket
     */
    @Bean
    public Docket sadrApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("rafael")
                .apiInfo(apiInfo())
                .select()
                    .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                    .paths(PathSelectors.any())
                    .build()
                .pathMapping("/")
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false);
    }
    

    /**
     * Generate Api Info
     * 
     * @author carpinteyror
     * @return Swagger API Info
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(projectName())
                .description("")
                .version("")
                .termsOfServiceUrl("")
                .license("")
                .licenseUrl("")
                .build();
    }

    /**
     * Project name.
     *
     * @author carpinteyror
     * @return the string
     */
    private String projectName(){
    	String name = "";
    	if(applicationName != null && !applicationName.equals("") ) 
    		name = applicationName.replaceAll("[_-]", " ");
    	return name;
    }
    
}

