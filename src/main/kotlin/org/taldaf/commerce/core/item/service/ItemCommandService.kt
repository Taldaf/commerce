package org.taldaf.commerce.core.item.service

import org.taldaf.commerce.core.item.model.ItemDto
import org.taldaf.commerce.core.item.model.ItemPostDto

interface ItemCommandService {
    fun decreaseStock(itemId: Long, quantity: Int)
    fun saveItem(itemPostDto: ItemPostDto): ItemDto
}
