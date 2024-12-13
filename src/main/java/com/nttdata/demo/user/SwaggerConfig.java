package com.nttdata.demo.user;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
    OpenAPI CustomOpenAPI() {
        return new OpenAPI().info(new io.swagger.v3.oas.models.info.Info()
                .title("Servicio usuarios")
                .version("1.0.0")
                .description("Aplicacion para la gestion usuarios genericos")
                .termsOfService("")
        );
    }
}
