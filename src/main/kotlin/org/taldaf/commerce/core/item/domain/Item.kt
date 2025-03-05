package org.taldaf.commerce.core.item.domain

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.taldaf.commerce.core.common.domian.PrimaryKeyEntity
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
) : PrimaryKeyEntity() {
    fun decreaseStock(quantity: Int) {
        if (this.quantity < quantity) {
            throw IllegalArgumentException("재고가 부족합니다.")
        }
        this.quantity -= quantity
    }
}