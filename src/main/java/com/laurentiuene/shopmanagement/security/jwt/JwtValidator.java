package com.laurentiuene.shopmanagement.security.jwt;

import java.util.Date;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public final class JwtValidator {

    private final JwtClaimExtractor jwtClaimExtractor;

    public JwtValidator(JwtClaimExtractor jwtClaimExtractor) {
        this.jwtClaimExtractor = jwtClaimExtractor;
    }

    public boolean validateToken(String username, String token, UserDetails userDetails) {
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return jwtClaimExtractor.extractExpiration(token).before(new Date());
    }


}

