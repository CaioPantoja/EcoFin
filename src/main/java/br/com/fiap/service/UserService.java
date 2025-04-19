package br.com.fiap.service;

import br.com.fiap.model.User;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    public static User createUser(Scanner scanner, ArrayList<User> users) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();

        String userId = "U" + (users.size() + 1);
        User newUser = new User(userId, name, email, password, phoneNumber, address);
        users.add(newUser);
        System.out.println("Registration successful! Your user ID is: " + userId);
        return newUser;
    }

    public static User loginUser(Scanner scanner, ArrayList<User> users) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome, " + user.getName() + ".");
                return user;
            }
        }
        System.out.println("Invalid email or password. Try again.");
        return null;
    }
}