package br.com.fiap.model;

public class Transaction {
    private final int transactionId;
    private final int accountId;
    private String accountName;
    private final String type;
    private final double amount;
    private final String date;

    public Transaction(int transactionId, int accountId, String accountName, String type, double amount, String date) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.accountName = accountName;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public Transaction(int transactionId, int accountId, String type, double amount, String date) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public int getTransactionId() { return transactionId; }
    public int getAccountId() { return accountId; }
    public String getAccountName() { return accountName; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
}
