public static void main(String[] args) {
    DataManagerB.initializeData();
    userList = DataManagerB.getUserList();
    appointmentList = DataManagerB.getAppointmentList();
    for (User user : userList) {
        userService.Register(user);
    }

    System.out.println("Welcome to CampusAssist (Group Member B)");
    login();
    if (loggedInUser != null && loggedInUser.getRole().equals("admin")) {
        adminService.adminMenu(loggedInUser, appointmentList, scanner);
    } else {
        System.out.println("Access denied. Admins only.");
    }
    scanner.close();
}

private static void login() {
    System.out.print("Enter email: ");
    String email = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();
    for (User user : userList) {
        if (user.login(email, password)) {
            loggedInUser = user;
            System.out.println("Login successful! Welcome, " + user.getUserName());
            return;
        }
    }
    System.out.println("Login failed!");
}