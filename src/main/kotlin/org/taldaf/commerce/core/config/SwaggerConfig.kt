package org.taldaf.commerce.core.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.servers.Server
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Value("\${springdoc.app-name:Commerce API}")
    private lateinit var appName: String

    @Value("\${springdoc.app-version:1.0.0}")
    private lateinit var appVersion: String

    @Value("\${springdoc.app-description:Commerce API Documentation}")
    private lateinit var appDescription: String

    @Bean
    fun openAPI(): OpenAPI {
        return OpenAPI()
            .info(apiInfo())
            .servers(listOf(
                Server().url("/").description("Taldaf Commerce Server")
            ))
    }

    private fun apiInfo(): Info {
        return Info()
            .title(appName)
            .version(appVersion)
            .description(appDescription)
            .contact(
                Contact()
                    .name("Taldaf Team")
            )
    }
}
