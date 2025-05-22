package br.com.fiap.service;

import br.com.fiap.dao.AccountDao;
import br.com.fiap.model.Account;

import java.util.List;

public class AccountService {

    private static final AccountDao accountDao = new AccountDao();

    public static Account createAccount(int userId, String name, String accountType, double balance) {
        Account newAccount = new Account(0, userId, name, balance, accountType, "USD");
        accountDao.save(newAccount);
        return newAccount;
    }

    public static String depositMoney(int userId, int accountId, double amount, String date) {
        Account account = accountDao.findByIdAndUserId(accountId, userId);
        if (account != null) {
            account.deposit(amount);
            accountDao.updateBalance(account);
            return TransactionService.deposit(account, amount, date);
        } else {
            return "Account not found or access denied.";
        }
    }

    public static String withdrawMoney(int userId, int accountId, double amount, String date) {
        Account account = accountDao.findByIdAndUserId(accountId, userId);
        if (account != null && account.getBalance() >= amount) {
            account.withdraw(amount);
            accountDao.updateBalance(account);
            return TransactionService.withdraw(account, amount, date);
        } else {
            return "Account not found, access denied, or insufficient balance.";
        }
    }

    public static List<Account> getAccountsByUserId(int userId) {
        return accountDao.findByUserId(userId);
    }
}
