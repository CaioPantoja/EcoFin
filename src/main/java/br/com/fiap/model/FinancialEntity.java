package br.com.fiap.model;

import java.util.ArrayList;

public abstract class FinancialEntity {
    private final int id;
    private final int userId;
    private final String name;

    public FinancialEntity(int id, int userId, String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public String getName() { return name; }

    public abstract void displayDetails();

    public void setId(int anInt) {
    }
}