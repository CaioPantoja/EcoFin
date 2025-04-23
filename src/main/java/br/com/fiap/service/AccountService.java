package br.com.fiap.service;

import br.com.fiap.dao.AccountDao;
import br.com.fiap.model.Account;

import java.util.List;
import java.util.Scanner;

public class AccountService {

    private static final AccountDao accountDao = new AccountDao();

    public static Account createAccount(Scanner scanner, int userId) {
        System.out.print("Enter account name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account type (e.g., Savings, Checking): ");
        String accountType = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        Account newAccount = new Account(0, userId, name, balance, accountType, "USD");
        accountDao.save(newAccount);
        System.out.println("Account created successfully!");
        return newAccount;
    }

    public static void depositMoney(Scanner scanner, int userId) {
        System.out.print("Enter account ID: ");
        int accountId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter transaction date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        Account account = accountDao.findByIdAndUserId(accountId, userId);
        if (account != null) {
            account.deposit(amount);
            accountDao.updateBalance(account);
            TransactionService.deposit(account, amount, date);
        } else {
            System.out.println("Account not found or access denied.");
        }
    }

    public static void withdrawMoney(Scanner scanner, int userId) {
        System.out.print("Enter account ID: ");
        int accountId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter transaction date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        Account account = accountDao.findByIdAndUserId(accountId, userId);
        if (account != null && account.getBalance() >= amount) {
            account.withdraw(amount);
            accountDao.updateBalance(account);
            TransactionService.withdraw(account, amount, date);
        } else {
            System.out.println("Account not found, access denied, or insufficient balance.");
        }
    }

    public static void viewAccounts(int userId) {
        List<Account> userAccounts = accountDao.findByUserId(userId);
        if (userAccounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            System.out.println("\n=== Your Accounts ===");
            for (Account account : userAccounts) {
                account.displayDetails();
                System.out.println("-------------------");
            }
        }
    }
}