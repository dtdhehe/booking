package com.dtdhehe.common.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Optional;
import java.util.function.Function;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // 定义分隔符,配置Swagger多包
    private static final String splitor = ";";

    private static final String apiPackage = "com.dtdhehe.controller" + splitor + "com.dtdhehe.system.controller";

    @Bean
    public Docket createApi(){
        //Docket是Swagger重要的构造器，为swagger配置提供默认值和方法
        //DocumentationType.SWAGGER_2表示使用swagger版本2.0
        return new Docket(DocumentationType.SWAGGER_2)
                //传入自定义api描述
                .apiInfo(apiInfo())
                //返回一个api选择构建器
                .select()
                //指定扫描的包
                .apis(basePackage(apiPackage))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 生成一个包含自定义信息的ApiInfo类
     * @return ApiInfo类
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("booking接口文档")
                //指定访问的路径
                .termsOfServiceUrl("http://42.192.219.17:9090/")
                //添加联系人信息
                .contact(new Contact("dtdhehe","URL","dtdhehe@sina.com"))
                //版本描述
                .version("1.0")
                .build();
    }

    /**
     * 重写basePackage方法，使能够实现多包访问
     * @param basePackage
     */
    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).map(handlerPackage(basePackage)).orElse(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage)     {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(splitor)) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.ofNullable(input.declaringClass());
    }

}
