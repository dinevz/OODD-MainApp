public static void main(String[] args) {
    DataManagerA.initializeData();
    userList = DataManagerA.getUserList();
    appointmentList = DataManagerA.getAppointmentList();

    System.out.println("Welcome to CampusAssist (Group Member A)");
    login();
    if (loggedInUser != null) {
        studentService.studentMenu(loggedInUser, appointmentList, scanner);
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