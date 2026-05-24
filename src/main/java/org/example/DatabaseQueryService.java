package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    private String readSqlFile(String filePath) {
        try {
            return String.join("\n", Files.readAllLines(Paths.get(filePath)));
        } catch (Exception e) {
            throw new RuntimeException("Failed to read SQL file: " + filePath, e);
        }
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        String sql = readSqlFile("sql/find_max_projects_client.sql");
        Connection conn = Database.getInstance().getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                result.add(new MaxProjectCountClient(
                        rs.getString("name"),
                        rs.getInt("project_count")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> result = new ArrayList<>();
        String sql = readSqlFile("sql/find_longest_project.sql");
        Connection conn = Database.getInstance().getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                result.add(new LongestProject(
                        rs.getInt("project_id"),
                        rs.getInt("month_count")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> result = new ArrayList<>();
        String sql = readSqlFile("sql/find_max_salary_worker.sql");
        Connection conn = Database.getInstance().getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                result.add(new MaxSalaryWorker(
                        rs.getString("name"),
                        rs.getInt("salary")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers() {
        List<YoungestEldestWorker> result = new ArrayList<>();
        String sql = readSqlFile("sql/find_youngest_eldest_workers.sql");
        Connection conn = Database.getInstance().getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                result.add(new YoungestEldestWorker(
                        rs.getString("type"),
                        rs.getString("name"),
                        rs.getDate("birthday").toLocalDate()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<ProjectPrice> printProjectPrices() {
        List<ProjectPrice> result = new ArrayList<>();
        String sql = readSqlFile("sql/print_project_prices.sql");
        Connection conn = Database.getInstance().getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                result.add(new ProjectPrice(
                        rs.getInt("project_id"),
                        rs.getInt("price")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
