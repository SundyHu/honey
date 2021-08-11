package io.ryan.honey.oauth2.demo.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger2Config
 *
 * @author hkc
 * @version 1.0.0
 * @date 2021-08-10 14:05
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket productApi() {

        //schema
        List<GrantType> grantTypes = new ArrayList<>();
        //密码模式
        String passwordTokenUrl = "http://localhost:18010/oauth/token";
        ResourceOwnerPasswordCredentialsGrant resourceOwnerPasswordCredentialsGrant = new ResourceOwnerPasswordCredentialsGrant(passwordTokenUrl);
        grantTypes.add(resourceOwnerPasswordCredentialsGrant);
        OAuth oAuth = new OAuthBuilder().name("oauth2")
                .grantTypes(grantTypes).build();
        //context
        //scope方位
        List<AuthorizationScope> scopes = new ArrayList<>();
        scopes.add(new AuthorizationScope("read", "read  resources"));
        scopes.add(new AuthorizationScope("write", "write resources"));

        SecurityReference securityReference = new SecurityReference("oauth2", scopes.toArray(new AuthorizationScope[]{}));
        SecurityContext securityContext = new SecurityContext(Lists.newArrayList(securityReference), PathSelectors.ant("/api/**"), each -> true, o -> o.requestMappingPattern().matches("/api/.*"));
        //schemas
        List<SecurityScheme> securitySchemes = Lists.newArrayList(oAuth);
        //securyContext
        List<SecurityContext> securityContexts = Lists.newArrayList(securityContext);
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.ryan.honey.oauth2.demo.controller"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(securityContexts)
                .securitySchemes(securitySchemes)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("honey-oauth2-demo")
                .description("")
                .termsOfServiceUrl("Honey")
                .contact(new Contact("Ryan", "https://honey.honey4cloud.io", "Ryan@honey.io"))
                .license("OpenSource")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0.0")
                .build();
    }
}
