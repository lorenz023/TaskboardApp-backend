package com.example.taskboard_backend.service

import com.example.taskboard_backend.model.db.User
import com.example.taskboard_backend.model.enum.UserStatus
import com.example.taskboard_backend.model.exception.EmailTakenException
import com.example.taskboard_backend.model.exception.InactiveUserException
import com.example.taskboard_backend.model.exception.IncorrectPasswordException
import com.example.taskboard_backend.model.exception.UserNotFoundException
import com.example.taskboard_backend.model.request.CreateUserRequest
import com.example.taskboard_backend.model.request.LoginRequest
import com.example.taskboard_backend.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jWTService: JWTService
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun register(createUserRequest: CreateUserRequest) {
        userRepository.findByEmail(createUserRequest.email).ifPresent {
            logger.info("User with email ${createUserRequest.email} already exists.")
            throw EmailTakenException()
        }

        val user = userRepository.save(
            User(
                id = null,
                name = createUserRequest.name,
                surname = createUserRequest.surname,
                email = createUserRequest.email,
                password = passwordEncoder.encode(createUserRequest.password)
            )
        )
        logger.info("User with email ${createUserRequest.email} created (userId: ${user.id}).")
    }

    fun login(loginRequest: LoginRequest): String {
        val user = userRepository.findByEmail(loginRequest.email).orElseThrow { UserNotFoundException() }

        if (user.status != UserStatus.ACTIVE) {
            throw InactiveUserException()
        }

        if (!passwordEncoder.matches(loginRequest.password, user.password)) {
            throw IncorrectPasswordException()
        }

        return jWTService.generateToken(user.id!!)
    }
}