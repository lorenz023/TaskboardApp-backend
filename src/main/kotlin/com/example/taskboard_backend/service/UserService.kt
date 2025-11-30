package com.example.taskboard_backend.service

import com.example.taskboard_backend.model.exception.UserNotFoundException
import com.example.taskboard_backend.model.response.UserDetails
import com.example.taskboard_backend.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun getUserDetails(userId: String): UserDetails {
        val user = userRepository.findById(userId)
            .orElseThrow { UserNotFoundException() }

        return UserDetails(user)
    }

}