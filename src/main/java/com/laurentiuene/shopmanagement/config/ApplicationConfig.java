package com.laurentiuene.shopmanagement.config;

import com.laurentiuene.shopmanagement.model.Staff;
import com.laurentiuene.shopmanagement.repository.StaffRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final StaffRepository staffRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Staff staff = staffRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " was not found!"));
            return new User(staff.getUsername(), staff.getPassword(), List.of(new SimpleGrantedAuthority(staff.getRole().name())));
        };
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
