package com.pm.loaplanner.config;

import com.pm.loaplanner.model.User;
import com.pm.loaplanner.repository.UserRepository;
import com.pm.loaplanner.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public  JwtAuthenticationFilter(JwtUtil jwtUtil, UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            // Collects all claims from the token
            try {
                Claims claims = Jwts.parser()
                        .verifyWith(jwtUtil.getSecretKey())
                        .build()
                        .parseSignedClaims(token)
                        .getPayload();

                String userId = claims.get("userId").toString();

                UUID userUUID = UUID.fromString(userId);
                User user = userRepository.findById(userUUID).orElse(null);

                // If user is found, checks if it has necessary authorities
                if (user != null) {
                    CustomUserDetails userDetails = new CustomUserDetails(user);
                    UsernamePasswordAuthenticationToken auth =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            } catch (JwtException e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }

        filterChain.doFilter(request,response);
    }
}
