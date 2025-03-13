package com.example.diary_app_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.diary_app_backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    //ユーザー名で検索（ログイン時に必要）
    Optional<User> findByUsername(String username);
}