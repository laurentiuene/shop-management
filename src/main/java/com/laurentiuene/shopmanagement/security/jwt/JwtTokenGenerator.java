package com.laurentiuene.shopmanagement.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenGenerator {

    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generateJwtToken(String username, int jwtExpirationIntervalSeconds) {
        if (username == null || "".equals(username)) {
            throw new IllegalArgumentException("Username must be provided");
        }
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username, jwtExpirationIntervalSeconds);
    }

    private String createToken(Map<String, Object> claims, String username, int jwtExpirationIntervalSeconds) {
        var key = Keys.hmacShaKeyFor(this.jwtSecret.getBytes());
        Date issuedAt = new Date(System.currentTimeMillis());
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(username)
            .setIssuedAt(issuedAt)
            .setExpiration(Date.from(issuedAt.toInstant().plusSeconds(jwtExpirationIntervalSeconds)))
            .signWith(key)
            .compact();
    }

}
