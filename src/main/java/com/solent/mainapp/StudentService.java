package com.solent.mainapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

// Author: [Group Member A Name]
// Task: Group Member A - Student functionalities
public class StudentService {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public void studentMenu(User loggedInUser, List<Appointment> appointments, Scanner scanner) {
        checkForUpcomingAppointments(loggedInUser, appointments); // Check reminders on login
        boolean running = true;
        while (running) {
            System.out.println("\nWelcome to CampusAssist, Student Menu:");
            System.out.println("1. View Upcoming Appointments");
            System.out.println("2. Request Support Session");
            System.out.println("3. Provide Feedback");
            System.out.println("4. View FAQs");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        viewAppointments(loggedInUser, appointments);
                        break;
                    case 2:
                        requestSupportSession(loggedInUser, appointments, scanner);
                        break;
                    case 3:
                        provideFeedback(appointments, scanner);
                        break;
                    case 4:
                        new FAQService().viewFAQs(DataManager.getFaqList());
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    private void viewAppointments(User loggedInUser, List<Appointment> appointments) {
        System.out.println("\nUpcoming Appointments for " + loggedInUser.getUserName() + ": ");
        boolean hasAppointments = false;
        for (Appointment appointment : appointments) {
            if (appointment.getUserId() == loggedInUser.getUserId() && appointment.getStatus().equals("Approved")) {
                System.out.println(appointment);
                hasAppointments = true;
            }
        }
        if (!hasAppointments) {
            System.out.println("No upcoming appointments.");
        }
    }

    private void requestSupportSession(User loggedInUser, List<Appointment> appointments, Scanner scanner) {
        System.out.println("\nRequest a Support Session:");
        System.out.print("Enter support type (Mental Health, Academic Support, Financial Aid): ");
        String supportType = scanner.nextLine();
        try {
            new Appointment(0, 0, supportType, null, null, null); // Validate support type
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid support type!");
            return;
        }

        System.out.print("Enter date and time (YYYY-MM-DD HH:mm): ");
        String dateTime = scanner.nextLine();
        LocalDateTime parsedDateTime;
        try {
            parsedDateTime = LocalDateTime.parse(dateTime, FORMATTER);
        } catch (Exception e) {
            System.out.println("Invalid date format! Use YYYY-MM-DD HH:mm");
            return;
        }

        Appointment appointment = new Appointment(appointments.size() + 1, loggedInUser.getUserId(), supportType, parsedDateTime, null, null);
        appointments.add(appointment);
        System.out.println("Support session requested successfully.");
    }

    private void provideFeedback(List<Appointment> appointments, Scanner scanner) {
        System.out.print("Enter appointment ID to provide feedback: ");
        int appointmentId;
        try {
            appointmentId = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid ID! Please enter a number.");
            scanner.nextLine();
            return;
        }

        for (Appointment appointment : appointments) {
            if (appointment.getId() == appointmentId) {
                System.out.print("Enter feedback (1-5 stars): ");
                int feedbackScore;
                try {
                    feedbackScore = scanner.nextInt();
                    scanner.nextLine();
                    appointment.setFeedback(feedbackScore);
                } catch (Exception e) {
                    System.out.println("Invalid feedback score! Must be a number between 1 and 5.");
                    scanner.nextLine();
                    return;
                }
                System.out.print("Enter optional comments: ");
                String comments = scanner.nextLine();
                appointment.setComments(comments);
                System.out.println("Thank you for your feedback!");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    private void checkForUpcomingAppointments(User loggedInUser, List<Appointment> appointments) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("\nReminder for Upcoming Appointments:");
        boolean hasReminders = false;
        for (Appointment appointment : appointments) {
            if (appointment.getUserId() == loggedInUser.getUserId() && appointment.getStatus().equals("Approved")) {
                Duration duration = Duration.between(now, appointment.getDateTime());
                if (duration.toHours() <= 48 && duration.toHours() >= 0) {
                    System.out.println("Reminder: Upcoming " + appointment.getSupportType() +
                            " on " + appointment.getDateTime().format(FORMATTER));
                    hasReminders = true;
                }
            }
        }
        if (!hasReminders) {
            System.out.println("No upcoming appointments within 48 hours.");
        }
    }
}
