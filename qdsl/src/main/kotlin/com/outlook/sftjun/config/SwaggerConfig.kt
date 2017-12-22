package com.outlook.sftjun.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.request.async.DeferredResult
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * Created by yinjun on 20/12/2017
 */
@Configuration
@EnableSwagger2
open class SwaggerConfig {

    @Bean
    open fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
            .enable(true)
            .groupName("report bi")
            .genericModelSubstitutes(DeferredResult::class.java)
            .useDefaultResponseMessages(false)
            .forCodeGeneration(false)
            .pathMapping("/")
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.outlook.sftjun"))
            .build()
            .apiInfo(apiInfo())

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("练手项目")//大标题
                .description("测试接口")//详细描述
                .version("1.0")//版本
                .termsOfServiceUrl("tst-url")
                .contact(Contact("", "", "")) //作者
                .license("License of api")
                .licenseUrl("license url")
                .build()

    }
}