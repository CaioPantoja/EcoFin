package br.com.fiap.service;

import br.com.fiap.model.Account;
import br.com.fiap.model.Transaction;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountService {
    public static Account createAccount(Scanner scanner, String userId, ArrayList<Account> accounts) {
        System.out.print("Enter account name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account type (e.g., Savings, Checking): ");
        String accountType = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        String accountId = "A" + (accounts.size() + 1);
        Account newAccount = new Account(accountId, userId, name, balance, accountType, "USD");
        accounts.add(newAccount);
        System.out.println("Account created successfully! Your account ID is: " + accountId);
        return newAccount;
    }

    public static void depositMoney(Scanner scanner, String userId, ArrayList<Account> accounts, ArrayList<Transaction> transactions) {
        System.out.print("Enter account ID: ");
        String accountId = scanner.nextLine();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter transaction date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        for (Account account : accounts) {
            if (account.getId().equals(accountId) && account.getUserId().equals(userId)) {
                TransactionService.deposit(account, amount, date, transactions);
                return;
            }
        }
        System.out.println("Account not found or you do not have permission to access this account.");
    }

    public static void withdrawMoney(Scanner scanner, String userId, ArrayList<Account> accounts, ArrayList<Transaction> transactions) {
        System.out.print("Enter account ID: ");
        String accountId = scanner.nextLine();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter transaction date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        for (Account account : accounts) {
            if (account.getId().equals(accountId) && account.getUserId().equals(userId)) {
                TransactionService.withdraw(account, amount, date, transactions);
                return;
            }
        }
        System.out.println("Account not found or you do not have permission to access this account.");
    }

    public static void viewAccounts(String userId, ArrayList<Account> accounts) {
        System.out.println("\n=== Your Accounts ===");
        for (Account account : accounts) {
            if (account.getUserId().equals(userId)) {
                account.displayDetails();
                System.out.println("-------------------");
            }
        }
    }
}