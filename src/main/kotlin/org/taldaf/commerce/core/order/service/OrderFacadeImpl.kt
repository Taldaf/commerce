package org.taldaf.commerce.core.order.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.taldaf.commerce.core.item.service.ItemCommandService
import org.taldaf.commerce.core.order.model.OrderRequestDto

@Service
class OrderFacadeImpl(
    private val orderCommandService: OrderCommandService,
    private val itemCommandService: ItemCommandService
) : OrderFacade {

    @Transactional
    override fun order(orderRequestDto: OrderRequestDto) {
        orderCommandService.order(
            orderRequestDto.itemIds.map { it.itemId },
            orderRequestDto.buyerId
        )

        orderRequestDto.itemIds.map {
            itemCommandService.decreaseStock(it.itemId, it.quantity)
        }
    }
}