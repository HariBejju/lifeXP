package com.example.lifeXP.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lifeXP.model.User;
//<user,Long> means a repository is created for User entity and its primary key type is Long
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User>findByEmail(String email);
    Optional<User>findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String email);

} 