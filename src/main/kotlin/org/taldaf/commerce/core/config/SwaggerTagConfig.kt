package org.taldaf.commerce.core.config

import io.swagger.v3.oas.models.tags.Tag
import org.springdoc.core.customizers.OpenApiCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerTagConfig {

    @Bean
    fun openApiTagCustomizer(): OpenApiCustomizer {
        return OpenApiCustomizer { openApi ->
            openApi.tags(getTags())
        }
    }

    private fun getTags(): List<Tag> {
        val tags = mutableListOf<Tag>()
        
        tags.add(
            Tag()
                .name("Item API")
                .description("상품 관련 API")
        )
        
        tags.add(
            Tag()
                .name("Order API")
                .description("주문 관련 API")
        )

        return tags
    }
}
