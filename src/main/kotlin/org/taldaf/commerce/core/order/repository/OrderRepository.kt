package org.taldaf.commerce.core.order.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.taldaf.commerce.core.order.domain.Order

interface OrderRepository : JpaRepository<Order, Long> {
}