package com.solent.mainapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static UserService userService = new UserService();
    public static List<User> registerUserList = new ArrayList<>();
    public static List<Appointment> appointmentList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showUser();
        LoginUser(); // Task One: Login existing users
    }

    public static void showUser() {
        System.out.println("Task One: Pre-coded Users");
        User user1 = new User(1, "Chathurika", "chathu@example.com", "securePass123", "student");
        User user2 = new User(2, "Anna", "anna@gmail.com", "Pass123", "admin");

        System.out.println(user1);
        System.out.println(user2);
        
        userService.Register(user1);
        userService.Register(user2);

        // Hardcoded appointments for testing
        appointmentList.add(new Appointment(1, "Mental Health", "2025-03-28 10:00", null));
        appointmentList.add(new Appointment(2, "Academic Support", "2025-03-29 14:00", null));
        appointmentList.add(new Appointment(3, "Financial Aid", "2025-03-30 09:00", null));

        System.out.println("\nHardcoded appointments added.");
    }

    public static void RegisterUser() {
        System.out.println("\n\nTask Two: Register a New User");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter role (student/admin): ");
        String role = scanner.nextLine();

        User newUser = new User(registerUserList.size() + 1, username, email, password, role);
        User registeredUser = userService.Register(newUser);

        if (registeredUser != null) {
            registerUserList.add(registeredUser);
            System.out.println("Registration successful!\n");
            System.out.println("Logging in now...");
            LoginUser();
        } else {
            System.out.println("Registration failed. Please try again.");
        }
    }

    // Task Three - Login User
    public static void LoginUser() {
        System.out.println("\nSign in: Login Users");

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User loggedInUser = userService.Login(email, password);
        if (loggedInUser != null) {
            if (loggedInUser.getRole().equals("admin")) {
                adminMenu();
            } else {
                studentMenu(loggedInUser); // Pass the logged-in user to check reminders
            }
        }
    }

    // Task Four - Menu for Student
    public static void studentMenu(User loggedInUser) {
        boolean running = true;
        while (running) {
            System.out.println("\nWelcome to CampusAssist, Student Menu:");
            System.out.println("1. View Upcoming Appointments");
            System.out.println("2. Request Support Session");
            System.out.println("3. Provide Feedback");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    viewAppointments(loggedInUser);
                    break;
                case 2:
                    requestSupportSession();
                    break;
                case 3:
                    provideFeedback();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // View Upcoming Appointments (Student)
    public static void viewAppointments(User loggedInUser) {
        System.out.println("\nUpcoming Appointments for " + loggedInUser.getUserName() + ": ");
        for (Appointment appointment : appointmentList) {
            System.out.println(appointment);
        }
    }

    // Request a Support Session (Student)
    public static void requestSupportSession() {
        System.out.println("\nRequest a Support Session:");
        System.out.print("Enter the type of support (Mental Health, Academic Support, Financial Aid): ");
        String supportType = scanner.nextLine();

        System.out.print("Enter date and time (YYYY-MM-DD HH:mm): ");
        String dateTime = scanner.nextLine();

        Appointment appointment = new Appointment(appointmentList.size() + 1, supportType, dateTime, null);
        appointmentList.add(appointment);

        System.out.println("Support session requested successfully.");
    }

    // Provide Feedback on a Session (Student)
    public static void provideFeedback() {
        System.out.print("Enter appointment ID to provide feedback: ");
        int appointmentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Appointment appointment : appointmentList) {
            if (appointment.getId() == appointmentId) {
                System.out.print("Enter your feedback (1-5 stars): ");
                int feedbackScore = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                appointment.setFeedback(feedbackScore);
                System.out.println("Thank you for your feedback!");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    // Admin Menu to manage appointments and feedback
    public static void adminMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. View all appointments");
            System.out.println("2. Approve/Cancel appointments");
            System.out.println("3. Edit appointment details");
            System.out.println("4. View feedback");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    viewAllAppointments();
                    break;
                case 2:
                    approveCancelAppointment();
                    break;
                case 3:
                    editAppointment();
                    break;
                case 4:
                    viewFeedback();
                    break;
                case 5:
                    System.out.println("Exiting Admin Menu...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // View all appointments (Admin)
    public static void viewAllAppointments() {
        System.out.println("\nAll Appointments: ");
        for (Appointment appointment : appointmentList) {
            System.out.println(appointment);
        }
    }

    // Approve/Cancel appointments (Admin)
    public static void approveCancelAppointment() {
        System.out.print("Enter Appointment ID to approve or cancel: ");
        int appointmentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Appointment appointment : appointmentList) {
            if (appointment.getId() == appointmentId) {
                System.out.println("Appointment found: " + appointment);
                System.out.println("1. Approve");
                System.out.println("2. Cancel");
                System.out.print("Select option: ");
                int action = scanner.nextInt();
                if (action == 1) {
                    System.out.println("Appointment approved.");
                } else if (action == 2) {
                    appointmentList.remove(appointment);
                    System.out.println("Appointment canceled.");
                } else {
                    System.out.println("Invalid choice.");
                }
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    // Edit appointment details (Admin)
    public static void editAppointment() {
        System.out.print("Enter Appointment ID to edit: ");
        int appointmentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Appointment appointment : appointmentList) {
            if (appointment.getId() == appointmentId) {
                System.out.println("Editing appointment: " + appointment);
                System.out.print("Enter new type of support (Mental Health, Academic Support, Financial Aid): ");
                String newSupportType = scanner.nextLine();

                System.out.print("Enter new date and time (YYYY-MM-DD HH:mm): ");
                String newDateTime = scanner.nextLine();

                appointment.setSupportType(newSupportType);
                appointment.setDateTime(newDateTime);

                System.out.println("Appointment updated successfully.");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    // View Feedback (Admin)
    public static void viewFeedback() {
        System.out.println("\nFeedback for Completed Appointments:");
        for (Appointment appointment : appointmentList) {
            if (appointment.getFeedback() != null) {
                System.out.println(appointment.getId() + " - Feedback: " + appointment.getFeedback());
            }
        }
    }

    // Automated Reminders for Upcoming Appointments
    public static void checkForUpcomingAppointments(User loggedInUser) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now();

        System.out.println("\nReminder for Upcoming Appointments:");

        for (Appointment appointment : appointmentList) {
            // Parse the appointment date
            LocalDateTime appointmentDate = LocalDateTime.parse(appointment.getDateTime(), formatter);

            // Calculate the difference between the current time and the appointment time
            Duration duration = Duration.between(now, appointmentDate);

            // If the appointment is within the next 48 hours
            if (duration.toHours() <= 48 && duration.toHours() >= 0) {
                System.out.println("Reminder: You have an upcoming appointment: " + appointment.getSupportType()
                        + " on " + appointment.getDateTime());
            }
        }
    }
}
