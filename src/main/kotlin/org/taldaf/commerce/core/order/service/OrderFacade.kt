package org.taldaf.commerce.core.order.service

import org.taldaf.commerce.core.order.model.OrderRequestDto

interface OrderFacade {
    fun order(orderRequestDto: OrderRequestDto)
}