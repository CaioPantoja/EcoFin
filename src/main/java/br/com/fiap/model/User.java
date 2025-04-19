package br.com.fiap.model;

public class User {
    private final String userId;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;

    public User(String userId, String name, String email, String password, String phoneNumber, String address) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
}