package com.rafael.cr.swagger.configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

/**
 * Annotation that implement the configuration swagger2.
 * 
 * To take the swagger2 configuration, add the annotation { @EnableSwagger2Configuration }
 * in the main class of each microservice where is required
 * 
 * @author carpinteyror
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(Swagger2Configuration.class)
public @interface EnableSwagger2Configuration {

}
