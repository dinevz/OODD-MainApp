public void adminMenu(User user, List<Appointment> appointments, Scanner scanner) {
    while (true) {
        System.out.println("\nAdmin Menu:");
        System.out.println("1. View All Appointments");
        System.out.println("2. Approve or Cancel Appointment");
        System.out.println("3. Reschedule Appointment");
        System.out.println("4. View Feedback");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.nextLine();
            continue;
        }

        switch (choice) {
            case 1 -> viewAllAppointments(appointments);
            case 2 -> approveCancelAppointment(appointments, scanner);
            case 3 -> rescheduleAppointment(appointments, scanner);
            case 4 -> viewFeedback(appointments);
            case 5 -> {
                return;
            }
            default -> System.out.println("Invalid option!");
        }
    }
}

private void viewAllAppointments(List<Appointment> appointments) {
    System.out.println("\nAll Appointments:");
    for (Appointment appointment : appointments) {
        System.out.println(appointment);
    }
}

private void approveCancelAppointment(List<Appointment> appointments, Scanner scanner) {
    System.out.print("Enter Appointment ID to approve/cancel: ");
    try {
        int appointmentId = scanner.nextInt();
        scanner.nextLine();
        for (Appointment appointment : appointments) {
            if (appointment.getId() == appointmentId) {
                System.out.println("Current status: " + appointment.getStatus());
                System.out.print("Enter new status (Approved/Canceled): ");
                String newStatus = scanner.nextLine();
                if (newStatus.equalsIgnoreCase("Approved") || newStatus.equalsIgnoreCase("Canceled")) {
                    appointment.setStatus(newStatus);
                    System.out.println("Appointment updated successfully.");
                } else {
                    System.out.println("Invalid status!");
                }
                return;
            }
        }
        System.out.println("Appointment not found.");
    } catch (Exception e) {
        System.out.println("Invalid input!");
        scanner.nextLine();
    }
}

private void rescheduleAppointment(List<Appointment> appointments, Scanner scanner) {
    System.out.print("Enter Appointment ID to reschedule: ");
    try {
        int appointmentId = scanner.nextInt();
        scanner.nextLine();
        for (Appointment appointment : appointments) {
            if (appointment.getId() == appointmentId) {
                System.out.println("Current date and time: " + appointment.getDateTime().format(FORMATTER));
                System.out.print("Enter new date and time (YYYY-MM-DD HH:mm): ");
                String newDateTime = scanner.nextLine();
                LocalDateTime parsedDateTime;
                try {
                    parsedDateTime = LocalDateTime.parse(newDateTime, FORMATTER);
                } catch (Exception e) {
                    System.out.println("Invalid date format! Use YYYY-MM-DD HH:mm");
                    return;
                }
                appointment.setDateTime(parsedDateTime);
                System.out.println("Appointment rescheduled successfully.");
                return;
            }
        }
        System.out.println("Appointment not found.");
    } catch (Exception e) {
        System.out.println("Invalid input!");
        scanner.nextLine();
    }
}

private void viewFeedback(List<Appointment> appointments) {
    System.out.println("\nFeedback for Appointments:");
    boolean hasFeedback = false;
    for (Appointment appointment : appointments) {
        if (appointment.getFeedback() != null) {
            System.out.println("Appointment ID: " + appointment.getId() + ", Feedback: " + appointment.getFeedback() +
                    ", Comments: " + (appointment.getComments() != null ? appointment.getComments() : "None"));
            hasFeedback = true;
        }
    }
    if (!hasFeedback) {
        System.out.println("No feedback available.");
    }
}