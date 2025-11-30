package com.example.taskboard_backend.service

import com.example.taskboard_backend.config.JWTConfig
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Service
import java.util.*

@Service
class JWTService(
    private val jwtConfig: JWTConfig
) {

    fun generateToken(id: String): String {
        val now = Date()
        val expiryDate = Date(now.time + jwtConfig.expirationMs)
        return Jwts.builder()
            .setSubject(id)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(SignatureAlgorithm.HS256, jwtConfig.secret)
            .compact()
    }

    fun extractUsername(token: String): String? {
        return try {
            Jwts.parser().setSigningKey(jwtConfig.secret).parseClaimsJws(token).body.subject
        } catch (e: Exception) {
            null
        }
    }

    fun isTokenValid(token: String): Boolean {
        return try {
            val claims: Claims = Jwts.parser().setSigningKey(jwtConfig.secret).parseClaimsJws(token).body
            !claims.expiration.before(Date())
        } catch (e: Exception) {
            false
        }
    }
}