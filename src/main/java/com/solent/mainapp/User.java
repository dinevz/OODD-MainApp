package com.solent.mainapp;

// Author: [Group Member B Name]
// Task: Group Member B - User class for role differentiation
public class User {
    private Integer userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String role;

    public User(Integer userId, String userName, String userEmail, String userPassword, String role) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.role = role;
    }

    // Getters and Setters
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return "User{userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", role=" + role + '}';
    }
}
