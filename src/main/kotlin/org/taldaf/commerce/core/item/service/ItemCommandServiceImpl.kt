package org.taldaf.commerce.core.item.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.taldaf.commerce.core.item.repository.ItemRepository

@Service
class ItemCommandServiceImpl(
    private val itemRepository: ItemRepository
) : ItemCommandService {

    @Transactional
    override fun decreaseStock(itemId: Long, quantity: Int) {
        itemRepository.findById(itemId)
            .orElseThrow { RuntimeException("Item not found") }
            .decreaseStock(quantity)
    }
}