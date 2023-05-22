package com.laurentiuene.shopmanagement.security;

import com.laurentiuene.shopmanagement.security.jwt.JwtClaimExtractor;
import java.util.Date;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public final class JwtValidator {

    private final JwtClaimExtractor jwtClaimExtractor;

    public JwtValidator(JwtClaimExtractor jwtClaimExtractor) {
        this.jwtClaimExtractor = jwtClaimExtractor;
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = jwtClaimExtractor.extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return jwtClaimExtractor.extractExpiration(token).before(new Date());
    }


}

