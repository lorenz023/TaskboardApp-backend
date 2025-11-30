package com.example.taskboard_backend.controller

import com.example.taskboard_backend.model.response.UserDetails
import com.example.taskboard_backend.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController()
class UserController(
    private val userService: UserService
) {

    @GetMapping("/user/details")
    fun getUserDetails(
        principal: Principal
    ): UserDetails {
        return userService.getUserDetails(principal.name)
    }
}