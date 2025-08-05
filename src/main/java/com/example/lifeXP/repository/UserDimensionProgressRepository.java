package com.example.lifeXP.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lifeXP.model.User;
import com.example.lifeXP.model.UserDimensionProgress;

public interface UserDimensionProgressRepository extends JpaRepository<UserDimensionProgress,Long> {
    List<UserDimensionProgress>findByUser(User user);
}
