package com.smm.rockscissorspaper.configuration;

import com.google.common.base.Predicates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration Class for Swagger.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  /**
   * The Spring Environment.
   */
  @Autowired
  private Environment environment;

  /**
   * Creates a Docket for the Swagger UI.
   * @return Docket initialised with the ApiInfo and requests sources.
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.any())
        .apis(
            Predicates.not(RequestHandlerSelectors
                .basePackage("org.springframework.boot")))
        .paths(PathSelectors.any()).build();
  }

  /**
   * Create the ApiInfo for the Docket.
   * @return ApiInfo set up with the properties defined in
   *         RockScissorsPaper.properties.
   */
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title(environment.getProperty("api.title"))
        .description(environment.getProperty("api.description"))
        .license(environment.getProperty("api.repo.name"))
        .licenseUrl(environment.getProperty("api.repo.url"))
        .version(environment.getProperty("api.version")).build();
  }
}
