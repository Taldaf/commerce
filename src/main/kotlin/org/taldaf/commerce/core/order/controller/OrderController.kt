package org.taldaf.commerce.core.order.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.taldaf.commerce.core.order.model.OrderRequestDto
import org.taldaf.commerce.core.order.service.OrderFacade

@RestController
class OrderController(
    private val orderFacade: OrderFacade
) {

    @PostMapping("/order")
    fun order(@RequestBody orderRequestDto: OrderRequestDto) {
        orderFacade.order(orderRequestDto)
    }
}