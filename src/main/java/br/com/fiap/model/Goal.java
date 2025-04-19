package br.com.fiap.model;

import java.util.ArrayList;

public class Goal extends FinancialEntity {
    private final String accountId;
    private final double targetAmount;
    private final String deadline;
    private String status;

    public Goal(String goalId, String userId, String name, String accountId, double targetAmount, String deadline, String status) {
        super(goalId, userId, name);
        this.accountId = accountId;
        this.targetAmount = targetAmount;
        this.deadline = deadline;
        this.status = status;
    }

    public String getAccountId() { return accountId; }
    public double getTargetAmount() { return targetAmount; }
    public String getDeadline() { return deadline; }
    public String getStatus() { return status; }

    private void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void displayDetails() {
        System.out.println("Goal Name: " + getName());
        System.out.println("Target Amount: " + this.targetAmount);
        System.out.println("Deadline: " + this.deadline);
        System.out.println("Status: " + this.status);
    }

    public void displayDetailsWithAccount(ArrayList<Account> accounts) {
        Account account = Account.findAccountById(this.accountId, getUserId(), accounts);
        if (account == null) {
            System.out.println("Account not found for this goal.");
            return;
        }

        double currentAmount = account.getBalance();
        double progress = (currentAmount / this.targetAmount) * 100;
        setStatus((currentAmount >= this.targetAmount) ? "Completed" : "In Progress");

        System.out.println("Goal Name: " + getName());
        System.out.println("Target Amount: " + this.targetAmount);
        System.out.println("Current Amount: " + currentAmount);
        System.out.println("Progress: " + progress + "%");
        System.out.println("Deadline: " + this.deadline);
        System.out.println("Status: " + this.status);
    }
}