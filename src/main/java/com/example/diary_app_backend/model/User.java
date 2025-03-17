package com.example.diary_app_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users") //Entityとテーブルをマッピング
@NoArgsConstructor // JPA用（必須）
@AllArgsConstructor // すべてのフィールドを初期化するコンストラクタ
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    String username;

    @Column(nullable = false)
    String password;

}
