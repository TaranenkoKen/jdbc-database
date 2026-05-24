# JDBC + H2 Database Project

Навчальний Java-проєкт для роботи з базою даних через JDBC.

## Опис

- З'єднання з H2 через JDBC на основі **Singleton**-класу `Database`.
- Ініціалізація схеми з файлу `sql/init_db.sql`.
- Наповнення таблиць з файлу `sql/populate_db.sql`.
- П'ять типових SELECT-запитів, кожен — у власному `.sql`-файлі.
- Усі запити виконуються через `PreparedStatement` (безпечно щодо SQL-ін'єкцій).

## Технології

- Java
- Gradle
- JDBC
- H2 Database

## Структура проєкту

```
jdbc-database-service/
├── build.gradle                 
├── settings.gradle
├── README.md
├── .gitignore
│
├── sql/                         ← усі SQL-запити як окремі файли
│   ├── init_db.sql               
│   ├── populate_db.sql            
│   ├── find_max_projects_client.sql
│   ├── find_longest_project.sql
│   ├── find_max_salary_worker.sql
│   ├── find_youngest_eldest_workers.sql
│   └── print_project_prices.sql
│
└── src/main/java/org.example/
    ├── Database.java                  — Singleton, тримає Connection
    ├── DatabaseInitService.java       — main(): виконує init_db.sql
    ├── DatabasePopulateService.java   — main(): виконує populate_db.sql
    ├── DatabaseQueryService.java      — по одному Java-методу на кожний SELECT
    ├── Main.java                      — демо: друкує результати всіх запитів
    │
    ├── MaxProjectCountClient.java     ─┐
    ├── LongestProject.java             │  POJO-моделі,
    ├── MaxSalaryWorker.java            │  у які мапляться рядки з БД
    ├── YoungestEldestWorkers.java      │
    └── ProjectPrices.java             ─┘
```

---

## Швидкий старт

### 1. Клонувати репозиторій

```bash
git clone https://github.com/1neyzer1/jdbc-database-service.git
cd jdbc-database-service
```

### 2. Запустити клас Main

**З IntelliJ IDEA / іншого IDE:** відкрий проєкт, почекай, поки Gradle
підтягне H2, запусти метод `main()` у:

 `org.example.Main` 


> Якщо хочеш «почати з чистого аркуша» — видали файл `test.mv.db` у корені проєкту.
