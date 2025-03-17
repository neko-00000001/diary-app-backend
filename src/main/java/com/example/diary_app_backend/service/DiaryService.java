package com.example.diary_app_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.diary_app_backend.model.Diary;
import com.example.diary_app_backend.repository.DiaryRepository;

@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public DiaryService(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    // 日記を作成
    public Diary createDiary(Diary diary) {
        return diaryRepository.save(diary);
    }

    // すべての日記を取得
    public List<Diary> getAllDiaries() {
        return diaryRepository.findAll();
    }

    // IDから日記を取得
    public Optional<Diary> getDiaryById(Long id) {
        return diaryRepository.findById(id);
    }

    // 日記を更新
    public Optional<Diary> updateDiary(Long id, Diary newDiary) {
        return diaryRepository.findById(id).map(diary -> {
            diary.setTitle(newDiary.getTitle());
            diary.setContent(newDiary.getContent());
            return diaryRepository.save(diary);
        });
    }

    // 日記を削除
    public void deleteDiary(Long id) {
        diaryRepository.deleteById(id);
    }
}