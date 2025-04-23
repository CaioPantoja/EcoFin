package br.com.fiap.model;

public class Account extends FinancialEntity {
    private double balance;
    private String accountType;
    private String currency;

    public Account(int accountId, int userId, String name, double balance, String accountType, String currency) {
        super(accountId, userId, name);
        this.balance = balance;
        this.accountType = accountType;
        this.currency = currency;
    }

    public double getBalance() { return balance; }
    public String getAccountType() { return accountType; }
    public String getCurrency() { return currency; }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Account ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Type: " + this.accountType);
        System.out.println("Balance: " + this.balance);
        System.out.println("Currency: " + this.currency);
    }
}