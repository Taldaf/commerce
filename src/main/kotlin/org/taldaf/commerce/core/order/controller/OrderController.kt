package org.taldaf.commerce.core.order.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.taldaf.commerce.core.order.model.OrderRequestDto
import org.taldaf.commerce.core.order.service.OrderFacade

@RestController
@Tag(name = "Order API", description = "주문 관련 API")
class OrderController(
    private val orderFacade: OrderFacade
) {

    @Operation(
        summary = "주문 생성",
        description = "새로운 주문을 생성합니다."
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "주문 생성 성공"),
            ApiResponse(responseCode = "400", description = "잘못된 요청"),
            ApiResponse(responseCode = "500", description = "서버 오류")
        ]
    )
    @PostMapping("/order")
    fun order(
        @Parameter(description = "주문 정보", required = true)
        @RequestBody orderRequestDto: OrderRequestDto
    ) {
        orderFacade.order(orderRequestDto)
    }
}