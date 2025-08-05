package com.example.lifeXP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import com.example.lifeXP.dto.ProgressResponseDTO;
import com.example.lifeXP.model.UserDimensionProgress;
import com.example.lifeXP.service.UserProgressService;

@RestController
@RequestMapping("/user")
public class UserProgressController {
    
    @Autowired
    
    private UserProgressService userProgressService;
    @GetMapping("/progress")
    public ResponseEntity<List<ProgressResponseDTO>>getUserProgress(Authentication authentication){
        String username = authentication.getName();
        List<ProgressResponseDTO> progressList = userProgressService.getProgress(username);
        return ResponseEntity.ok(progressList);
    }
    
}
