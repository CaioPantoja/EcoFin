package br.com.fiap.service;

import br.com.fiap.dao.GoalDao;
import br.com.fiap.model.Goal;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class GoalService {
    private static final GoalDao goalDao = new GoalDao();

    public static void setGoal(Scanner scanner, int userId) {
        try {
            System.out.print("Enter goal name: ");
            String name = scanner.nextLine();
            System.out.print("Enter account ID: ");
            int accountId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter target amount: ");
            double targetAmount = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter deadline (YYYY-MM-DD): ");
            String deadline = scanner.nextLine();

            Goal goal = new Goal(0, userId, name, accountId, targetAmount, deadline, "In Progress");
            goalDao.insert(goal);
            System.out.println("Goal set successfully!");
        } catch (SQLException e) {
            System.err.println("Error saving goal: " + e.getMessage());
        }
    }

    public static void viewGoals(int userId) {
        try {
            List<Goal> goals = goalDao.findByUserId(userId);
            System.out.println("\n=== Your Goals ===");
            for (Goal goal : goals) {
                goal.displayDetails();
                System.out.println("---------------------");
            }
        } catch (SQLException e) {
            System.err.println("Error fetching goals: " + e.getMessage());
        }
    }
}
