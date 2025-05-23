package br.com.fiap.dao;

import br.com.fiap.model.Goal;
import br.com.fiap.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoalDao {

    public void insert(Goal goal) throws SQLException {
        String sql = "INSERT INTO goals (goal_id, user_id, account_id, name, target_amount, deadline, status) " +
                "VALUES (SEQ_GOAL_ID.NEXTVAL, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, goal.getUserId());
            stmt.setInt(2, goal.getAccountId());
            stmt.setString(3, goal.getName());
            stmt.setDouble(4, goal.getTargetAmount());
            stmt.setString(5, goal.getDeadline());
            stmt.setString(6, goal.getStatus());

            stmt.executeUpdate();
        }
    }

    public List<Goal> findByUserId(int userId) throws SQLException {
        List<Goal> goals = new ArrayList<>();
        String sql = "SELECT * FROM goals WHERE user_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Goal goal = new Goal(
                        rs.getInt("goal_id"),
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getInt("account_id"),
                        rs.getDouble("target_amount"),
                        rs.getDate("deadline").toString(),
                        rs.getString("status")
                );
                goals.add(goal);
            }
        }
        return goals;
    }

    public double getTotalGoalsValueByUserId(int userId) {
        String sql = "SELECT SUM(target_amount) FROM goals WHERE user_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching total goal value: " + e.getMessage(), e);
        }
        return 0.0;
    }
}
