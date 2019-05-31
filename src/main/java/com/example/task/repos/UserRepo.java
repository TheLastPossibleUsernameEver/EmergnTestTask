package com.example.task.repos;

import com.example.task.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
//    User findByLogin(String login);
//    User findByEmail(String email);
}