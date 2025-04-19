package br.com.fiap.model;

public class Transaction {
    private final String transactionId;
    private final String accountId;
    private final String type;
    private final double amount;
    private final String date;

    public Transaction(String transactionId, String accountId, String type, double amount, String date) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public String getTransactionId() { return transactionId; }
    public String getAccountId() { return accountId; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
}