package com.lahiru.todoappbackend.repository;


import com.lahiru.todoappbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
    Boolean existsByEmail(String email);
    Optional<User> findByUserNameOrEmail(String username, String email);
}

