package org.taldaf.commerce.core.order.domain

import jakarta.persistence.*
import org.taldaf.commerce.core.common.domian.PrimaryKeyEntity
import org.taldaf.commerce.core.user.domian.User

@Entity(name = "orders")
class Order(

    @Enumerated(EnumType.STRING)
    var status: OrderStatus,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    val buyer: User,

    @OneToMany(mappedBy= "order", fetch = FetchType.LAZY, orphanRemoval = true)
    private val _orderItem: MutableList<OrderItem> = mutableListOf(),

    ) : PrimaryKeyEntity() {
    enum class OrderStatus {
        PENDING, ACCEPTED, REJECTED, DELIVERED
    }
}