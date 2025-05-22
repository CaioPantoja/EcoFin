package br.com.fiap.service;

import br.com.fiap.dao.TransactionDao;
import br.com.fiap.model.Account;
import br.com.fiap.model.Transaction;

import java.util.List;

public class TransactionService {

    private static final TransactionDao transactionDao = new TransactionDao();

    public static String deposit(Account account, double amount, String date) {
        if (amount > 0) {
            Transaction depositTransaction = new Transaction(0, account.getId(), "Deposit", amount, date);
            transactionDao.save(depositTransaction);
            return "Deposit successful. New balance: " + account.getBalance();
        } else {
            return "Invalid amount.";
        }
    }

    public static String withdraw(Account account, double amount, String date) {
        if (amount > 0 && account.getBalance() >= amount) {
            Transaction withdrawalTransaction = new Transaction(0, account.getId(), "Withdrawal", amount, date);
            transactionDao.save(withdrawalTransaction);
            return "Withdrawal successful. New balance: " + account.getBalance();
        } else {
            return "Insufficient funds or invalid amount.";
        }
    }

    public static List<Transaction> getTransactionsByUserId(int userId) {
        return transactionDao.findByUserId(userId);
    }
}
