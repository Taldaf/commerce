package org.taldaf.commerce.core.item.service

import org.taldaf.commerce.core.item.model.ItemDto

interface ItemQueryService {
    fun getItem(itemId: Long): ItemDto
}
