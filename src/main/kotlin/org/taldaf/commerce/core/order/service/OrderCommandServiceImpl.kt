package org.taldaf.commerce.core.order.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.taldaf.commerce.core.item.repository.ItemRepository
import org.taldaf.commerce.core.order.domain.Order
import org.taldaf.commerce.core.order.repository.OrderRepository
import org.taldaf.commerce.core.user.repository.UserRepository

@Service
class OrderCommandServiceImpl(
    private val orderRepository: OrderRepository,
    private val itemRepository: ItemRepository,
    private val userRepository: UserRepository
) : OrderCommandService {

    @Transactional
    override fun order(itemIds: List<Long>, buyerId: Long) {
        val user = userRepository.findById(buyerId)
            .orElseThrow { RuntimeException("User not found") }

        val items = itemRepository.findByIdIn(itemIds)
            .also { if (it.size != itemIds.size) throw RuntimeException("Item not found") };

        Order.createOrder(items, user)
            .also { orderRepository.save(it) }
    }
}