package com.solent.mainapp;

import java.util.Scanner;

// Group Integration: [Group Name]
// This class integrates contributions from Group Members A, B, and C.
// - Group Member A: StudentService (session requests, appointments, feedback, reminders)
// - Group Member B: AdminService (appointment management, feedback viewing, user roles)
// - Group Member C: FAQService and AnalyticsService (FAQs, analytics)
// Integration Challenges:
// 1. Data consistency: Multiple services accessed userList and appointmentList, causing potential conflicts.
//    Solution: Created DataManager to centralize data storage.
// 2. User-appointment linking: Original code lacked user-specific appointments.
//    Solution: Added userId to Appointment class.
// 3. Menu navigation: Ensured seamless transitions between student, admin, and FAQ menus.
public class MainApp {
    private static UserService userService = new UserService();
    private static StudentService studentService = new StudentService();
    private static AdminService adminService = new AdminService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DataManager.initializeData(); // Load sample data
        showUsers();
        loginUser();
    }

    private static void showUsers() {
        System.out.println("Pre-coded Users:");
        for (User user : DataManager.getUserList()) {
            System.out.println(user);
            userService.register(user);
        }
        System.out.println("\nSample appointments and FAQs loaded.");
    }

    private static void loginUser() {
        System.out.println("\nSign in: Login Users");
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User loggedInUser = userService.login(email, password);
        if (loggedInUser != null) {
            if (loggedInUser.getRole().equals("admin")) {
                adminService.adminMenu(DataManager.getAppointmentList(), scanner);
            } else {
                studentService.studentMenu(loggedInUser, DataManager.getAppointmentList(), scanner);
            }
        } else {
            System.out.println("Try again or register.");
            registerUser();
        }
    }

    private static void registerUser() {
        System.out.println("\nRegister a New User");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (student/admin): ");
        String role = scanner.nextLine();

        User newUser = new User(DataManager.getUserList().size() + 1, username, email, password, role);
        User registeredUser = userService.register(newUser);

        if (registeredUser != null) {
            DataManager.getUserList().add(registeredUser);
            System.out.println("Registration successful! Logging in...");
            loginUser();
        } else {
            System.out.println("Registration failed. Try again.");
        }
    }
}
