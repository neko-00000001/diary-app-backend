package com.example.diary_app_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.diary_app_backend.model.Diary;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    //ユーザーの日記を取得
    List<Diary> findByUserId(Long userId);
}