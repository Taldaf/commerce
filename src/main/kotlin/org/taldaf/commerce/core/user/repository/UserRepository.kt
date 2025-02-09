package org.taldaf.commerce.core.user.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.taldaf.commerce.core.user.domian.User

interface UserRepository: JpaRepository<User, Long> {
}