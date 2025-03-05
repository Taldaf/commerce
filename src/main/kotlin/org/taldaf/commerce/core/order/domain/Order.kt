package org.taldaf.commerce.core.order.domain

import jakarta.persistence.*
import org.taldaf.commerce.core.common.domian.PrimaryKeyEntity
import org.taldaf.commerce.core.item.domain.Item
import org.taldaf.commerce.core.user.domian.User

@Entity(name = "orders")
class Order private constructor (

    @Enumerated(EnumType.STRING)
    var status: OrderStatus,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    val buyer: User,

    @OneToMany(mappedBy= "order", fetch = FetchType.LAZY, orphanRemoval = true)
    private val _orderItems: MutableList<OrderItem> = mutableListOf(),

    ) : PrimaryKeyEntity() {

    companion object {
        fun createOrder(items: List<Item>, buyer: User): Order {
            val order = Order(
                status = OrderStatus.PENDING,
                buyer = buyer
            )
            items.forEach { item ->
                order.addItem(item, 1)
            }
            return order
        }
    }

    fun addItem(item: Item, quantity: Int) {
        val orderItem = OrderItem(
            item = item,
            quantity = quantity
        )
        _orderItems.add(orderItem)
        orderItem.order(this)
    }


    enum class OrderStatus {
       // 주문 상태: PENDING(주문 대기), ACCEPTED(주문 승인), REJECTED(주문 거부), DELIVERED(배송 완료)
        PENDING, ACCEPTED, REJECTED, DELIVERED
    }
}