package com.example.diary_app_backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.diary_app_backend.model.User;
import com.example.diary_app_backend.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String username, String password) {
        // ユーザー名の重複チェック(Optionalの中身を確認)
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("このユーザー名は既に使用されています");
        }

        // パスワードをハッシュ化
        String encodedPassword = passwordEncoder.encode(password);

        // 新しいユーザーを作成して保存
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(encodedPassword);

        return userRepository.save(newUser);
    }
}
