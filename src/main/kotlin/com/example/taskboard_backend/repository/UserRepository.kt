package com.example.taskboard_backend.repository

import com.example.taskboard_backend.model.db.User
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.Optional

interface UserRepository: MongoRepository<User, String> {
    fun findByEmail(email: String): Optional<User>
}