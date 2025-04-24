package com.solent.mainapp;

import java.util.ArrayList;
import java.util.List;

// Author: [Group Member B Name]
// Task: Group Member B - User authentication and registration
public class UserService implements IUser {
    private List<User> userList = new ArrayList<>();

    @Override
    public User login(String email, String password) {
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            System.out.println("Login failed: Email and password cannot be empty.");
            return null;
        }
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
    public User register(User user) {
        if (user == null || user.getUserEmail() == null || user.getUserName() == null) {
            System.out.println("Registration failed: Invalid user data.");
            return null;
        }
        user.setUserId(userList.size() + 1);
        userList.add(user);
        System.out.println("User registered successfully: " + user.getUserName());
        return user;
    }
}
