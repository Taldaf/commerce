package org.taldaf.commerce.core.item.model

data class ItemPostDto(
    val name: String,
    val price: Double,
    val quantity: Int,
    val description: String,
    val sellerId: Long,
    )
