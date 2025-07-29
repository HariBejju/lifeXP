package com.example.lifeXP.service;

import com.example.lifeXP.model.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.lifeXP.dto.LoginRequest;
import com.example.lifeXP.dto.LoginResponse;
import com.example.lifeXP.dto.SignupRequest;
import com.example.lifeXP.repository.UserRepository;
import com.example.lifeXP.util.JwtUtil;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;
    
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void Signup(SignupRequest request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already in use");
        }
        if(userRepository.existsByUsername(request.getUsername())){
            throw new RuntimeException("Username already exists brother");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode((request.getPassword())));
        user.setTasksCompleted(0);
        user.setXp(0);
        userRepository.save(user);
    }
    public LoginResponse login(LoginRequest request){
        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = optionalUser.get();
        System.out.println(user.getUsername());
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return new LoginResponse(token);
    }
    
}
