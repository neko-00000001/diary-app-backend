package com.example.diary_app_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.diary_app_backend.model.Diary;
import com.example.diary_app_backend.service.DiaryService;

@RestController
@RequestMapping("/api/diaries")
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    // 日記を作成（POST /api/diaries）
    @PostMapping
    public ResponseEntity<Diary> createDiary(@RequestBody Diary diary) {
        return ResponseEntity.ok(diaryService.createDiary(diary));
    }

    // すべての日記を取得（GET /api/diaries）
    @GetMapping
    public ResponseEntity<List<Diary>> getAllDiaries() {
        return ResponseEntity.ok(diaryService.getAllDiaries());
    }

    // 特定の日記を取得（GET /api/diaries/{id}）
    @GetMapping("/{id}")
    public ResponseEntity<?> getDiaryById(@PathVariable Long id) {
        Optional<Diary> diary = diaryService.getDiaryById(id);
        return diary.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 日記を更新（PUT /api/diaries/{id}）
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDiary(@PathVariable Long id, @RequestBody Diary diary) {
        Optional<Diary> updatedDiary = diaryService.updateDiary(id, diary);
        return updatedDiary.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 日記を削除（DELETE /api/diaries/{id}）
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDiary(@PathVariable Long id) {
        diaryService.deleteDiary(id);
        return ResponseEntity.ok().body("日記を削除しました");
    }
}
