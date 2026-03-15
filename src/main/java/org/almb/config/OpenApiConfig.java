package org.almb.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Company Service",
                version = "1.0",
                description = "Reactive WebFlux Microservice"
        )
)
@Configuration
public class OpenApiConfig {
}
