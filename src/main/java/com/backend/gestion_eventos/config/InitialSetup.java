package com.backend.gestion_eventos.config;


import com.backend.gestion_eventos.models.RoleName;
import com.backend.gestion_eventos.models.User;
import com.backend.gestion_eventos.repositories.UserRepository;
import com.backend.gestion_eventos.services.JwtService;
import com.backend.gestion_eventos.wire.user.AuthResponse;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class InitialSetup {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    // Method that creates an administrator user and then saves that user in the DB.
    @PostConstruct
    public AuthResponse init(){
        if (userRepository.findByEmail("admin@gmail.com").isEmpty()){
            var userAdmin = User.builder()
                    .email("admin@gmail.com")
                    .password(passwordEncoder.encode("admin123"))
                    .name("admin")
                    .lastName("AD")
                    .role(RoleName.ADMIN)
                    .creationDate(LocalDateTime.now())
                    .build();
            userRepository.save(userAdmin);
            return AuthResponse.builder()
                    .token(jwtService.generateToken(userAdmin))
                    .build();
        }else {
            return null;
        }
    }
}