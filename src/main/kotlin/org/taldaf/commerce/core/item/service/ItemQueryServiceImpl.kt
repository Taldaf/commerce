package org.taldaf.commerce.core.item.service

import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.taldaf.commerce.core.item.domain.Item
import org.taldaf.commerce.core.item.model.ItemDto
import org.taldaf.commerce.core.item.repository.ItemRepository

@Service
@RequiredArgsConstructor
class ItemQueryServiceImpl(
    private val itemRepository: ItemRepository
) : ItemQueryService {

    @Transactional(readOnly = true)
    override fun getItem(itemId: Long): ItemDto {
        return itemRepository.findById(itemId)
            .map { item -> ItemDto.fromEntity(item) }
            .orElseThrow { RuntimeException("Item not found") }
    }
}
