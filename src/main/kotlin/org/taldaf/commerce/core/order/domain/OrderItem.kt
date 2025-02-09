package org.taldaf.commerce.core.order.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne
import org.taldaf.commerce.core.common.domian.PrimaryKeyEntity
import org.taldaf.commerce.core.item.domain.Item

@Entity
class OrderItem (
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val order: Order,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val item: Item,
): PrimaryKeyEntity()