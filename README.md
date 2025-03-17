# **日記アプリ バックエンド**

## **概要**
このプロジェクトは、日記アプリのバックエンドAPIです。Spring Boot と PostgreSQL を使用して、日記のCRUD操作を提供します。

## **技術スタック**
- **バックエンド:** Spring Boot 3.x (Java)
- **データベース:** PostgreSQL
- **セキュリティ:** Spring Security（JWT認証 - 後で実装予定）
- **ORM:** Spring Data JPA
- **API:** RESTful API

## **セットアップ**
### **必要な環境**
- JDK 17以上
- PostgreSQL のインストールおよび起動
- Maven のインストール

### **リポジトリのクローン**
```sh
git clone <repository_url>
cd diary-app-backend
```

### **データベースの設定**
`src/main/resources/application.properties` を開き、以下のようにPostgreSQLの設定を行ってください。
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/diary_app
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### **アプリケーションの起動**
```sh
mvn spring-boot:run
```

## **API エンドポイント**
### **ユーザー関連**
- **POST /api/users/register** → 新規ユーザー登録
- **POST /api/users/login** → （予定）ユーザー認証＆JWT発行

### **日記関連**
- **GET /api/diaries** → すべての日記を取得
- **GET /api/diaries/{id}** → 指定したIDの日記を取得
- **POST /api/diaries** → 新しい日記を作成
- **PUT /api/diaries/{id}** → 既存の日記を更新
- **DELETE /api/diaries/{id}** → 日記を削除

## **今後の改善予定**
- **JWTによる認証機能の実装**
- **単体テスト・統合テストの追加**
- **Docker対応**

## **ライセンス**
MIT License

