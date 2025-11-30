package com.example.taskboard_backend.model.db

import com.example.taskboard_backend.model.enum.UserStatus
import com.example.taskboard_backend.model.request.CreateUserRequest
import org.springframework.data.annotation.Id

data class User (
    @Id val id: String? = null,
    var name: String,
    var surname: String,
    var email: String,
    var password: String,
    var status: UserStatus = UserStatus.ACTIVE,
)