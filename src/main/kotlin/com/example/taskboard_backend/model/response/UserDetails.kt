package com.example.taskboard_backend.model.response

import com.example.taskboard_backend.model.db.User

data class UserDetails(
    val id: String,
    val name: String,
    val surname: String,
    val email: String
) {
    constructor(user: User) : this(
        id = user.id!!,
        name = user.name,
        surname = user.surname,
        email = user.email
    )
}