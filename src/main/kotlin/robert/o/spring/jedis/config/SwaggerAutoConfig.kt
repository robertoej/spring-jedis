package robert.o.spring.jedis.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerAutoConfig {

    @Bean
    fun productApi() = Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("robert.o.spring.jedis"))
            .build()
            .apiInfo(metaData())!!

    private fun metaData() = ApiInfoBuilder()
                .title("Spring Boot Jedis Example")
                .version("1.0.0")
                .build()
}
