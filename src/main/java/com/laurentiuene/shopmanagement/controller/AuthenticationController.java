package com.laurentiuene.shopmanagement.controller;

import com.laurentiuene.shopmanagement.dto.jwt.JwtRequestDto;
import com.laurentiuene.shopmanagement.dto.jwt.JwtResponseDto;
import com.laurentiuene.shopmanagement.exception.CustomException;
import com.laurentiuene.shopmanagement.security.jwt.JwtTokenGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    @Value("${jwt.expiration.interval}")
    private Integer jwtExpirationInterval;

    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator jwtTokenGenerator;

    @PostMapping
    public JwtResponseDto createAuthenticationToken(@RequestBody JwtRequestDto jwtRequestDto) throws Exception {
        authenticate(jwtRequestDto.username(), jwtRequestDto.password());
        log.debug("Authentication created with username " + jwtRequestDto.username());

        final String jwt = jwtTokenGenerator.generateJwtToken(
            jwtRequestDto.username(), jwtExpirationInterval);
        return new JwtResponseDto(jwt);
    }

    private void authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new CustomException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new CustomException("INVALID_CREDENTIALS", e);
        }
    }

}
