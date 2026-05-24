package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        try {
            Connection connection = Database.getInstance().getConnection();
            String sql = String.join("\n", Files.readAllLines(Paths.get("sql/init_db.sql")));
            try (Statement statement = connection.createStatement()) {
                statement.execute(sql);
                System.out.println("Database initialized successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}