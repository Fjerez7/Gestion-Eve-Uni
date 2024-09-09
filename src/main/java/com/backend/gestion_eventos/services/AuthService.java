package com.backend.gestion_eventos.services;


import com.backend.gestion_eventos.models.RoleName;
import com.backend.gestion_eventos.models.User;
import com.backend.gestion_eventos.repositories.UserRepository;
import com.backend.gestion_eventos.wire.user.AuthResponse;
import com.backend.gestion_eventos.wire.user.LoginRequest;
import com.backend.gestion_eventos.wire.user.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    // Method that handles login requests.
    public AuthResponse login(LoginRequest request) {
        // Authenticates the user's credentials using the AuthenticationManager
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()));
        // Looks up the user in the DB
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        // Generates a token for the user
        var token = jwtService.generateToken(user);
        var role = user.getRole();
        return AuthResponse.builder()
                .token(token)
                .role(role)
                .build();
    }

    // Method that handles registration requests.
    public AuthResponse register(RegisterRequest request) {
        // Creates a new User object with the details provided in the request, encrypts the password.
        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .lastName(request.getLastName())
                .creationDate(LocalDateTime.now())
                .role(RoleName.STUDENT)
                .build();
        // Saves the user to the database
        userRepository.save(user);
        // Generates a token for the user
        return AuthResponse.builder()
                .token(jwtService.generateToken(user))
                .role(user.getRole())
                .build();
    }
}
