package org.taldaf.commerce.core.item.model

import org.taldaf.commerce.core.item.domain.Item
import org.taldaf.commerce.core.user.model.UserDto

data class ItemDto(
    val name: String,
    val price: Double,
    val quantity: Int,
    val description: String,
    val seller: UserDto
) {
    companion object {
        fun fromEntity(item: Item): ItemDto {
            return ItemDto(
                name = item.name,
                price = item.price,
                quantity = item.quantity,
                description = item.description,
                seller = UserDto.fromEntity(item.seller)
            )
        }
    }
}
