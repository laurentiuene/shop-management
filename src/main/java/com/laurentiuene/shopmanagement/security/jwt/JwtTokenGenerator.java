package com.laurentiuene.shopmanagement.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenGenerator {

    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.expiration.interval}")
    private Integer jwtExpirationInterval;

    public String generateJwtToken(String username, Authentication authentication) {
        if (username == null || "".equals(username)) {
            throw new IllegalArgumentException("Username must be provided");
        }
        String authorities = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(","));
        return createToken(authorities, username, jwtExpirationInterval);
    }

    private String createToken(String authorities, String username, int jwtExpirationIntervalSeconds) {
        var key = Keys.hmacShaKeyFor(this.jwtSecret.getBytes());
        Date issuedAt = new Date(System.currentTimeMillis());
        return Jwts.builder()
            .claim("roles",authorities)
            .setSubject(username)
            .setIssuedAt(issuedAt)
            .setExpiration(Date.from(issuedAt.toInstant().plusSeconds(jwtExpirationIntervalSeconds)))
            .signWith(key)
            .compact();
    }

}
