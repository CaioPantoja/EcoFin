package br.com.fiap.model;

import java.util.ArrayList;

public abstract class FinancialEntity {
    private final String id;
    private final String userId;
    private final String name;

    public FinancialEntity(String id, String userId, String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
    }

    public String getId() { return id; }
    public String getUserId() { return userId; }
    public String getName() { return name; }

    public abstract void displayDetails();
}