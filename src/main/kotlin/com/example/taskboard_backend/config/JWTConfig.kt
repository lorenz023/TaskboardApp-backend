package com.example.taskboard_backend.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "jwt")
class JWTConfig {
    lateinit var secret: String
    var expirationMs: Long = 0
}