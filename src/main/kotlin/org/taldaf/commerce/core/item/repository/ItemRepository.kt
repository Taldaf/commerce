package org.taldaf.commerce.core.item.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.taldaf.commerce.core.item.domain.Item

interface ItemRepository: JpaRepository<Item, Long> {
    fun findByIdIn(ids: List<Long>): List<Item>
}