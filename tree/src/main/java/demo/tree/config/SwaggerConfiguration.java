package demo.tree.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.service.*;
import io.swagger.annotations.Api;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;


@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes(AuthenticationPrincipal.class, Authentication.class, Locale.class)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Arrays.asList(authToken(), basicAuth()))
                .securityContexts(Arrays.asList(publicContext(), defaultContext()))
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Tree DemoREST API",
                "[ Base URL: localhost:8080/ ]",
                "API V1.0",
                "Terms of service",
                new Contact("Alexey Kudinov", "", "akudinov@mail.ru"),
                "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
    }

    private SecurityContext publicContext() {
        return SecurityContext.builder()
                .forPaths(PathSelectors.regex("/auth(/.*)?"))
                .build();
    }

    private SecurityContext defaultContext() {
        return SecurityContext.builder()
                .forPaths(PathSelectors.any())
                .securityReferences(defaultAuth())
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        final AuthorizationScope[] authScopes = {};
        return Arrays.asList(
                new SecurityReference(basicAuth().getName(), authScopes),
                new SecurityReference(authToken().getName(), authScopes)
        );
    }

    private BasicAuth basicAuth() {
        return new BasicAuth("basic");
    }

    private ApiKey authToken() {
        return new ApiKey("token", "X-Auth-Token", "header");
    }
}
