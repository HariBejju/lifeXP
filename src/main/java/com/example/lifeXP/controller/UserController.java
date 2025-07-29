package com.example.lifeXP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lifeXP.dto.LoginResponse;
import com.example.lifeXP.dto.SignupRequest;
import com.example.lifeXP.dto.LoginRequest;
import com.example.lifeXP.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String>signup(@RequestBody SignupRequest request){
        try{
            System.out.println("Inside Signup");
            userService.Signup(request);
            System.out.println("request Signup");
            return ResponseEntity.ok("Signup Successfull");
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse>login(@RequestBody LoginRequest request){
        LoginResponse response = userService.login(request);
        return ResponseEntity.ok(response);
    }
}

