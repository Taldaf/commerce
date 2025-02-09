package org.taldaf.commerce.core.item.service

interface ItemCommandService {
    fun decreaseStock(itemId: Long, quantity: Int)
}
