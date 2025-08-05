package com.example.lifeXP.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lifeXP.dto.ProgressResponseDTO;
import com.example.lifeXP.model.User;
import com.example.lifeXP.model.UserDimensionProgress;
import com.example.lifeXP.repository.UserDimensionProgressRepository;
import com.example.lifeXP.repository.UserRepository;
@Service
public class UserProgressService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDimensionProgressRepository userDimensionProgressRepository;
    public List<ProgressResponseDTO> getProgress(String username){
        Optional<User>optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        List<ProgressResponseDTO>responseList = new ArrayList();
        User user = optionalUser.get();
        List<UserDimensionProgress>list = userDimensionProgressRepository.findByUser(user);
        for(UserDimensionProgress ls:list){
            ProgressResponseDTO dto = new ProgressResponseDTO();
            dto.setDimension(ls.getDimension().getName());
            dto.setCurrentLevel(ls.getCurrentLevel());
            dto.setCurrentXp(ls.getCurrentXp());
            responseList.add(dto);
        }
        return responseList;


    }
}
