package org.taldaf.commerce.core.item.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.taldaf.commerce.core.common.exception.EntityNotFoundException
import org.taldaf.commerce.core.item.domain.Item
import org.taldaf.commerce.core.item.model.ItemDto
import org.taldaf.commerce.core.item.model.ItemPostDto
import org.taldaf.commerce.core.item.repository.ItemRepository
import org.taldaf.commerce.core.user.repository.UserRepository

@Service
class ItemCommandServiceImpl(
    private val itemRepository: ItemRepository,
    private val userRepository: UserRepository
) : ItemCommandService {

    @Transactional
    override fun decreaseStock(itemId: Long, quantity: Int) {
        val item = itemRepository.findByIdOrNull(itemId)
            ?: throw EntityNotFoundException("Item not found with id: $itemId")
        item.decreaseStock(quantity)
    }

    @Transactional
    override fun saveItem(itemPostDto: ItemPostDto): ItemDto {
        val user = userRepository.findByIdOrNull(itemPostDto.sellerId)
            ?: throw EntityNotFoundException("Seller not found with id: ${itemPostDto.sellerId}")

        return Item(
            name = itemPostDto.name,
            price = itemPostDto.price,
            quantity = itemPostDto.quantity,
            description = itemPostDto.description,
            seller = user,
        ).let { item ->
            itemRepository.save(item)
            ItemDto.fromEntity(item)
        }
    }
}