package org.example.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhout
 * @date 2020/9/3 17:26
 */
@Configuration
@ConditionalOnProperty(name = "swagger.api-docs.enable", havingValue = "true", matchIfMissing = false)
@EnableSwagger2
@EnableKnife4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SwaggerConfigurer {
  @Value("${spring.application.name}")
  private String groupName;

  @Value("${swagger.version}")
  private String version;

  @Value("${swagger.api-docs.title:${spring.application.name}}")
  private String title;

  @Value("${swagger.api-docs.description:${spring.application.name}}")
  private String description;

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .groupName(groupName)
            .apiInfo(
                    new ApiInfoBuilder().title(title).version(version).description(description).build())
            .useDefaultResponseMessages(false)
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
            .build();
  }
}
