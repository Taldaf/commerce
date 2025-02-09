package org.taldaf.commerce.core.order.model

data class OrderRequestDto(
    val buyerId: Long,
    val itemIds: List<OrderItemDto>,
) {
    data class OrderItemDto(
        val itemId: Long,
        val quantity: Int,
    )
}
