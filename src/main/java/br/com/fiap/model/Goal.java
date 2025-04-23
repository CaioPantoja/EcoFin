package br.com.fiap.model;

import java.util.ArrayList;

public class Goal extends FinancialEntity {
    private final int accountId;
    private final double targetAmount;
    private final String deadline;
    private String status;

    public Goal(int goalId, int userId, String name, int accountId, double targetAmount, String deadline, String status) {
        super(goalId, userId, name);
        this.accountId = accountId;
        this.targetAmount = targetAmount;
        this.deadline = deadline;
        this.status = status;
    }

    public int getAccountId() { return accountId; }
    public double getTargetAmount() { return targetAmount; }
    public String getDeadline() { return deadline; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public void displayDetails() {
        System.out.println("Goal ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Target Amount: " + targetAmount);
        System.out.println("Deadline: " + deadline);
        System.out.println("Status: " + status);
    }
}