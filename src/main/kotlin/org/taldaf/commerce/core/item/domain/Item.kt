package org.taldaf.commerce.core.item.domain

import jakarta.persistence.*
import org.taldaf.commerce.core.common.domian.PrimaryKeyEntity
import org.taldaf.commerce.core.order.domain.OrderItem
import org.taldaf.commerce.core.user.domian.User

@Entity
class Item(
    var name: String,
    var price: Double,
    var quantity: Int,
    var description: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    val seller: User,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", orphanRemoval = true)
    private val _orderItem: MutableList<OrderItem> = mutableListOf(),
) : PrimaryKeyEntity()