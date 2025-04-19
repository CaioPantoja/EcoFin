package br.com.fiap.service;

import br.com.fiap.model.Goal;
import br.com.fiap.model.Account;
import java.util.ArrayList;
import java.util.Scanner;

public class GoalService {
    public static void setGoal(Scanner scanner, String userId, ArrayList<Account> accounts, ArrayList<Goal> goals) {
        System.out.print("Enter goal name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account ID for the goal: ");
        String accountId = scanner.nextLine();
        System.out.print("Enter target amount: ");
        double targetAmount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter deadline (YYYY-MM-DD): ");
        String deadline = scanner.nextLine();

        String goalId = "G" + (goals.size() + 1);
        Goal newGoal = new Goal(goalId, userId, name, accountId, targetAmount, deadline, "In Progress");
        goals.add(newGoal);
        System.out.println("Goal set successfully! Your goal ID is: " + goalId);
    }

    public static void viewGoals(String userId, ArrayList<Goal> goals, ArrayList<Account> accounts) {
        System.out.println("\n=== Your Goals ===");
        for (Goal goal : goals) {
            if (goal.getUserId().equals(userId)) {
                goal.displayDetailsWithAccount(accounts); // Use the new method
                System.out.println("-------------------");
            }
        }
    }
}