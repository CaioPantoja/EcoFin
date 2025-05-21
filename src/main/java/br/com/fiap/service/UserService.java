package br.com.fiap.service;

import br.com.fiap.dao.UserDao;
import br.com.fiap.model.User;
import java.util.Scanner;

public class UserService {

    private static final UserDao userDao = new UserDao();

    public User createUser(String name, String email, String password, String phone, String address) {
        User user = new User(0, name, email, password, phone, address);
        userDao.save(user);
        return user;
    }

    public User loginUser(String email, String password) {
        return userDao.findByEmailAndPassword(email, password);
    }
}