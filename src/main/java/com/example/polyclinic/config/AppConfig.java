package com.example.polyclinic.config;

import com.example.polyclinic.persist.db.postgres.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final PatientRepository patientRepository;

    @Bean
    UserDetailsService userDetailsService() {
        return username -> patientRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user"));
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider aP = new DaoAuthenticationProvider();
        aP.setUserDetailsService(userDetailsService());
        aP.setPasswordEncoder(passwordEncoder());
        return aP;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
