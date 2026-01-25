package com.pm.loaplanner.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {
    private final Key secretKey;

    public JwtUtil(@Value("${jwt.secret}") String secret) {
        if (secret == null || secret.isBlank()) {
            throw new IllegalArgumentException("JWT secret is missing");
        }
        byte[] keyBytes = Base64.getDecoder().decode(secret.getBytes(StandardCharsets.UTF_8));
        this.secretKey = Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String email, String role, String username) {
        return Jwts.builder()
            .subject(email)
            .claim("role", role)
            .claim("username", username)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
            .signWith(secretKey)
            .compact();
    }
}
