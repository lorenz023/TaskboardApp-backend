package com.example.taskboard_backend.model.request

class CreateUserRequest (
    val name: String,
    val surname: String,
    val email: String,
    val password: String,
)