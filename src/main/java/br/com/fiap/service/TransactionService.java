package br.com.fiap.service;

import br.com.fiap.dao.TransactionDao;
import br.com.fiap.model.Account;
import br.com.fiap.model.Transaction;

import java.util.List;

public class TransactionService {

    private static final TransactionDao transactionDao = new TransactionDao();

    public static void deposit(Account account, double amount, String date) {
        if (amount > 0) {
            Transaction depositTransaction = new Transaction(0, account.getId(),"Deposit", amount, date);
            transactionDao.save(depositTransaction);
            System.out.println("Deposit successful! New balance: " + account.getBalance());
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public static void withdraw(Account account, double amount, String date) {
        if (amount > 0 && account.getBalance() >= amount) {
            Transaction withdrawalTransaction = new Transaction(0,account.getId(), "Withdrawal", amount, date);
            transactionDao.save(withdrawalTransaction);
            System.out.println("Withdrawal successful! New balance: " + account.getBalance());
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public static void viewTransactions(int userId) {
        System.out.println("\n=== Your Transactions ===");
        List<Transaction> transactions = transactionDao.findByUserId(userId);
        for (Transaction transaction : transactions) {
            System.out.println("Transaction ID: " + transaction.getTransactionId());
            System.out.println("Type: " + transaction.getType());
            System.out.println("Amount: " + transaction.getAmount());
            System.out.println("Date: " + transaction.getDate());
            System.out.println("Account ID: " + transaction.getAccountId());
            System.out.println("-------------------");
        }
    }
}