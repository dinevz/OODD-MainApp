public User(int userId, String userName, String userEmail, String userPassword, String role) {
    this.userId = userId;
    this.userName = userName;
    this.userEmail = userEmail;
    this.userPassword = userPassword;
    this.role = role;
}

@Override
public boolean login(String email, String password) {
    return userEmail.equals(email) && userPassword.equals(password);
}

@Override
public void Register(IUser user) {
    // Simplified: No registration logic needed for C
}

public int getId() { return userId; }
public String getUserName() { return userName; }
public String getUserEmail() { return userEmail; }
public String getUserPassword() { return userPassword; }
public String getRole() { return role; }
public void setId(int userId) { this.userId = userId; }
public void setUserName(String userName) { this.userName = userName; }
public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
public void setUserPassword(String userPassword) { this.userPassword = userPassword; }
public void setRole(String role) { this.role = role; }

@Override
public String toString() {
    return "User{id=" + userId + ", userName='" + userName + "', role='" + role + "'}";
}