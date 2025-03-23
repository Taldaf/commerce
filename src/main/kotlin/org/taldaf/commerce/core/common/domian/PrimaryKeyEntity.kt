package org.taldaf.commerce.core.common.domian

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class PrimaryKeyEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long ?= null


) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as PrimaryKeyEntity

        // id가 null인 경우는 아직 영속화 전, 비동일 엔티티로 간주한다
        if (id == null || other.id == null) return false

        return id == other.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}