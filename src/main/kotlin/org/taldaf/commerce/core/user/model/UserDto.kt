package org.taldaf.commerce.core.user.model

import org.taldaf.commerce.core.user.domian.User

data class UserDto (
    val name: String,
    val email: String,
    val address: String,
) {
    companion object {
        fun fromEntity(user: User): UserDto {
            return UserDto(
                name = user.name,
                email = user.email,
                address = user.address,
            )
        }
    }
}