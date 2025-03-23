package org.taldaf.commerce.core.order.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne
import org.taldaf.commerce.core.common.domian.PrimaryKeyEntity
import org.taldaf.commerce.core.item.domain.Item

@Entity
class OrderItem (
    val quantity: Int,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val item: Item,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    private var order: Order? = null,
): PrimaryKeyEntity() {
    internal fun order(order: Order) {
        this.order = order
    }
}