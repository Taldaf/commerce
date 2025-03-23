package org.taldaf.commerce.core.user.domian

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany
import org.taldaf.commerce.core.common.domian.PrimaryKeyEntity
import org.taldaf.commerce.core.item.domain.Item
import org.taldaf.commerce.core.order.domain.Order

@Entity(name = "users")
class User(
    var name: String,
    var email: String,
    var password: String,

    var address: String,

    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY)
    val orders: MutableList<Order> = mutableListOf(),

    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
    val items: MutableList<Item> = mutableListOf()

) : PrimaryKeyEntity()