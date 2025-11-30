package com.example.taskboard_backend.controller

import com.example.taskboard_backend.model.request.CreateUserRequest
import com.example.taskboard_backend.model.request.LoginRequest
import com.example.taskboard_backend.service.AuthService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
class AuthController(
    private val authService: AuthService,
) {

    @PostMapping("/register")
    fun register(
        @RequestBody createUserRequest: CreateUserRequest
    ) {
        authService.register(createUserRequest)
    }

    @PostMapping("/login")
    fun login(
        @RequestBody loginRequest: LoginRequest
    ): String {
        return authService.login(loginRequest)
    }

}