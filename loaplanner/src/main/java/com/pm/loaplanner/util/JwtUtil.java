package com.pm.loaplanner.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Getter
@Component
public class JwtUtil {
    private final SecretKey secretKey;

    public JwtUtil(@Value("${jwt.secret}") String secret) {
        if (secret == null || secret.isBlank()) {
            throw new IllegalArgumentException("JWT secret is missing");
        }
        byte[] keyBytes = Base64.getDecoder().decode(secret);
        this.secretKey = Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String id, String email, String role, String username) {
        return Jwts.builder()
            .subject(email)
            .claim("userId", id)
            .claim("role", role)
            .claim("username", username)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
            .signWith(secretKey)
            .compact();
    }
}
