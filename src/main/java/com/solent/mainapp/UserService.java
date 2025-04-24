package com.solent.mainapp;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUser {

    private List<User> userList = new ArrayList<>();

    @Override
    public User Login(String email, String password) {
        for (User user : userList) {
            if (user.getUserEmail().equals(email) && user.getUserPassword().equals(password)) {
                System.out.println("Login successful for user: " + user.getUserName());
                return user;
            }
        }
        System.out.println("Login failed: Invalid email or password.");
        return null;
    }

    @Override
    public User Register(User user) {
        user.setUserId(userList.size() + 1);
        userList.add(user);
        System.out.println("User registered successfully: " + user.getUserName());
        return user;
    }
}
