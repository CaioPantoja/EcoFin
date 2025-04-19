package br.com.fiap.service;

import br.com.fiap.model.Account;
import br.com.fiap.model.Transaction;
import java.util.ArrayList;

public class TransactionService {
    public static void deposit(Account account, double amount, String date, ArrayList<Transaction> transactions) {
        if (amount > 0) {
            account.deposit(amount);
            String transactionId = "T" + (transactions.size() + 1);
            Transaction depositTransaction = new Transaction(transactionId, account.getId(), "Deposit", amount, date);
            transactions.add(depositTransaction);
            System.out.println("Deposit successful! New balance: " + account.getBalance());
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public static void withdraw(Account account, double amount, String date, ArrayList<Transaction> transactions) {
        if (amount > 0 && account.getBalance() >= amount) {
            account.withdraw(amount);
            String transactionId = "T" + (transactions.size() + 1);
            Transaction withdrawalTransaction = new Transaction(transactionId, account.getId(), "Withdrawal", amount, date);
            transactions.add(withdrawalTransaction);
            System.out.println("Withdrawal successful! New balance: " + account.getBalance());
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public static void viewTransactions(String userId, ArrayList<Account> accounts, ArrayList<Transaction> transactions) {
        System.out.println("\n=== Your Transactions ===");
        for (Transaction transaction : transactions) {
            for (Account account : accounts) {
                if (account.getId().equals(transaction.getAccountId()) && account.getUserId().equals(userId)) {
                    System.out.println("Transaction ID: " + transaction.getTransactionId());
                    System.out.println("Type: " + transaction.getType());
                    System.out.println("Amount: " + transaction.getAmount());
                    System.out.println("Date: " + transaction.getDate());
                    System.out.println("Account ID: " + transaction.getAccountId());
                    System.out.println("-------------------");
                }
            }
        }
    }
}