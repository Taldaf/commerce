package org.taldaf.commerce.core.order.service

interface OrderCommandService {
    fun order(itemIds: List<Long>, buyerId: Long)
}