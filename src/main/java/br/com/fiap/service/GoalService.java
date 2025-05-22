package br.com.fiap.service;

import br.com.fiap.dao.GoalDao;
import br.com.fiap.model.Goal;

import java.sql.SQLException;
import java.util.List;

public class GoalService {

    private static final GoalDao goalDao = new GoalDao();

    public static String setGoal(int userId, String name, int accountId, double targetAmount, String deadline) {
        try {
            Goal goal = new Goal(0, userId, name, accountId, targetAmount, deadline, "In Progress");
            goalDao.insert(goal);
            return "Goal set successfully!";
        } catch (SQLException e) {
            return "Error saving goal: " + e.getMessage();
        }
    }

    public static List<Goal> getGoalsByUserId(int userId) {
        try {
            return goalDao.findByUserId(userId);
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching goals: " + e.getMessage(), e);
        }
    }
}
