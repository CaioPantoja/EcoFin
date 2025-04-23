package br.com.fiap;

import br.com.fiap.model.User;
import br.com.fiap.service.AccountService;
import br.com.fiap.service.GoalService;
import br.com.fiap.service.TransactionService;
import br.com.fiap.service.UserService;
import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
    private static User currentUser = null;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        boolean running = true;
        while (running) {
            System.out.println("\n=== EcoFin Menu ===");
            if (currentUser == null) {
                System.out.println("1. Register");
                System.out.println("2. Log in");
                System.out.println("3. Exit");
            } else {
                System.out.println("1. Create Account");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Set a Financial Goal");
                System.out.println("5. View Goals");
                System.out.println("6. View Transactions");
                System.out.println("7. View Accounts");
                System.out.println("8. Log out");
            }

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (currentUser == null) {
                switch (choice) {
                    case 1:
                        currentUser = UserService.createUser(scanner);
                        break;
                    case 2:
                        currentUser = UserService.loginUser(scanner);
                        break;
                    case 3:
                        running = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } else {
                switch (choice) {
                    case 1:
                        AccountService.createAccount(scanner, currentUser.getUserId());
                        break;
                    case 2:
                        AccountService.depositMoney(scanner, currentUser.getUserId());
                        break;
                    case 3:
                        AccountService.withdrawMoney(scanner, currentUser.getUserId());
                        break;
                    case 4:
                        GoalService.setGoal(scanner, currentUser.getUserId());
                        break;
                    case 5:
                        GoalService.viewGoals(currentUser.getUserId());
                        break;
                    case 6:
                        TransactionService.viewTransactions(currentUser.getUserId());
                        break;
                    case 7:
                        AccountService.viewAccounts(currentUser.getUserId());
                        break;
                    case 8:
                        currentUser = null;
                        System.out.println("Logged out successfully.");
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        }

        scanner.close();
    }
}
