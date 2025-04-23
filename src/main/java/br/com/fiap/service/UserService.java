package br.com.fiap.service;

import br.com.fiap.dao.UserDao;
import br.com.fiap.model.User;
import java.util.Scanner;

public class UserService {

    private static final UserDao userDao = new UserDao();

    public static User createUser(Scanner scanner) {
        System.out.print("Enter your Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your Number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter your address: ");
        String address = scanner.nextLine();

        User user = new User(0, name, email, password, phone, address);
        userDao.save(user);
        return user;
    }

    public static User loginUser(Scanner scanner) {
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = userDao.findByEmailAndPassword(email, password);
        if (user != null) {
            System.out.println("Login successful, Welcome " + user.getName());
        } else {
            System.out.println("Email or password incorrect.");
        }

        return user;
    }
}