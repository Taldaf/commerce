package org.taldaf.commerce.core.item.service

import org.springframework.data.domain.Pageable
import org.taldaf.commerce.core.item.model.ItemDto

interface ItemQueryService {
    fun getItem(itemId: Long): ItemDto
    fun getItemList(pageable: Pageable): List<ItemDto>
}
