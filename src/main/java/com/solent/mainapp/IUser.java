package com.solent.mainapp;

// Author: Catalin
// Task: Group Member B - Interface for user authentication
public interface IUser {
    /**
     * Logs in a user with the given email and password.
     * @param email User's email
     * @param password User's password
     * @return User object if login is successful, null otherwise
     */
    User login(String email, String password);

    /**
     * Registers a new user.
     * @param user User object to register
     * @return Registered User object
     */
    User register(User user);
}
