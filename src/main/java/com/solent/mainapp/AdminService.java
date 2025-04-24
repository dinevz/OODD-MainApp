package com.solent.mainapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

// Author: Catalin
// Task: Group Member B - Admin functionalities
public class AdminService {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public void adminMenu(List<Appointment> appointments, Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. View All Appointments");
            System.out.println("2. Approve/Cancel Appointments");
            System.out.println("3. Edit Appointment Details");
            System.out.println("4. View Feedback");
            System.out.println("5. Manage FAQs");
            System.out.println("6. View Analytics");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        viewAllAppointments(appointments);
                        break;
                    case 2:
                        approveCancelAppointment(appointments, scanner);
                        break;
                    case 3:
                        editAppointment(appointments, scanner);
                        break;
                    case 4:
                        viewFeedback(appointments);
                        break;
                    case 5:
                        new FAQService().manageFAQs(DataManager.getFaqList(), scanner);
                        break;
                    case 6:
                        new AnalyticsService().showAnalytics(appointments);
                        break;
                    case 7:
                        System.out.println("Exiting Admin Menu...");
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

    private void viewAllAppointments(List<Appointment> appointments) {
        System.out.println("\nAll Appointments: ");
        if (appointments.isEmpty()) {
            System.out.println("No appointments available.");
        } else {
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }

    private void approveCancelAppointment(List<Appointment> appointments, Scanner scanner) {
        System.out.print("Enter Appointment ID to approve or cancel: ");
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
                System.out.println("Appointment found: " + appointment);
                System.out.println("1. Approve");
                System.out.println("2. Cancel");
                System.out.print("Select option: ");
                try {
                    int action = scanner.nextInt();
                    scanner.nextLine();
                    if (action == 1) {
                        appointment.setStatus("Approved");
                        System.out.println("Appointment approved.");
                    } else if (action == 2) {
                        appointment.setStatus("Canceled");
                        System.out.println("Appointment canceled.");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.nextLine();
                }
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    private void editAppointment(List<Appointment> appointments, Scanner scanner) {
        System.out.print("Enter Appointment ID to edit: ");
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
                System.out.println("Editing appointment: " + appointment);
                System.out.print("Enter new support type (Mental Health, Academic Support, Financial Aid): ");
                String newSupportType = scanner.nextLine();
                try {
                    new Appointment(0, 0, newSupportType, null, null, null); // Validate
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid support type!");
                    return;
                }

                System.out.print("Enter new date and time (YYYY-MM-DD HH:mm): ");
                String newDateTime = scanner.nextLine();
                LocalDateTime parsedDateTime;
                try {
                    parsedDateTime = LocalDateTime.parse(newDateTime, FORMATTER);
                } catch (Exception e) {
                    System.out.println("Invalid date format! Use YYYY-MM-DD HH:mm");
                    return;
                }

                appointment.setSupportType(newSupportType);
                appointment.setDateTime(parsedDateTime);
                System.out.println("Appointment updated successfully.");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    private void viewFeedback(List<Appointment> appointments) {
        System.out.println("\nFeedback Summary:");
        int totalFeedback = 0, positive = 0, negative = 0;
        double sum = 0;
        for (Appointment appointment : appointments) {
            if (appointment.getFeedback() != null) {
                totalFeedback++;
                sum += appointment.getFeedback();
                if (appointment.getFeedback() >= 4) positive++;
                else if (appointment.getFeedback() <= 2) negative++;
                System.out.println("ID: " + appointment.getId() + ", Feedback: " + appointment.getFeedback() +
                        ", Comments: " + (appointment.getComments() != null ? appointment.getComments() : "None"));
            }
        }
        if (totalFeedback > 0) {
            System.out.println("Average Feedback Score: " + String.format("%.2f", sum / totalFeedback));
            System.out.println("Positive Reviews (4-5): " + positive);
            System.out.println("Negative Reviews (1-2): " + negative);
        } else {
            System.out.println("No feedback available.");
        }
    }
}
