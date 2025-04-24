/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solent.mainapp;

/**
 *
 * @author chathurikagoonawardane
 */



import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author chathurikagoonawardane
 */

//part 2
// we created IUser interface that only defines the method signature now we must create a class that implements the interface and provides the method logic 
public class UserServiceold implements IUser {

    // Sample data storage (simulating a database)
    // this is main registerduser list
    private List<User> userList = new ArrayList<>();

    // Implementing the Login method
    @Override
    public User Login(String email, String password) {
        // Simple logic to check user credentials
        for (User user : userList) {
            if (user.getUserEmail().equals(email) && user.getUserPassword().equals(password)) {
                System.out.println("Login successful for user: " + user.getUserName());
                return user;
            }
        }
        System.out.println("Login failed: Invalid email or password.");
        return null;
    }

    // Implementing the Register method
    @Override
    public User Register(User user) {
        user.setUserId(userList.size() + 1);// will create new ID every time new user registered

        userList.add(user);  // Add user to the list (simulated storage)
        System.out.println("User registered successfully: " + user.getUserName());//print confirmation 
        return user;// return the user 
    }
}
    
