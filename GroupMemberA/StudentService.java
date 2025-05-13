public void studentMenu(User user, List<Appointment> appointments, Scanner scanner) {
    while (true) {
        System.out.println("\nStudent Menu:");
        System.out.println("1. Request Support Session");
        System.out.println("2. View Appointments");
        System.out.println("3. Provide Feedback");
        System.out.println("4. Check for Upcoming Appointments");
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
            case 1 -> requestSupportSession(user, appointments, scanner);
            case 2 -> viewAppointments(user, appointments);
            case 3 -> provideFeedback(appointments, scanner);
            case 4 -> checkForUpcomingAppointments(user, appointments);
            case 5 -> {
                return;
            }
            default -> System.out.println("Invalid option!");
        }
    }
}

public void requestSupportSession(User user, List<Appointment> appointments, Scanner scanner) {
    System.out.println("\nRequest a Support Session:");
    System.out.print("Enter the type of support (Mental Health, Academic Support, Financial Aid): ");
    String supportType = scanner.nextLine();
    try {
        new Appointment(0, 0, supportType, null, null, null);
    } catch (IllegalArgumentException e) {
        System.out.println("Invalid support type!");
        return;
    }
    System.out.print("Enter date and time (YYYY-MM-DD HH:mm): ");
    String dateTime = scanner.nextLine();
    LocalDateTime parsedDateTime;
    try {
        parsedDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    } catch (Exception e) {
        System.out.println("Invalid date format! Use YYYY-MM-DD HH:mm");
        return;
    }
    Appointment appointment = new Appointment(appointments.size() + 1, user.getId(), supportType, parsedDateTime, null, null);
    appointments.add(appointment);
    System.out.println("Support session requested successfully.");
}

public void viewAppointments(User user, List<Appointment> appointments) {
    System.out.println("\nAppointments for " + user.getUserName() + ":");
    boolean hasAppointments = false;
    for (Appointment appointment : appointments) {
        if (appointment.getUserId() == user.getId()) {
            System.out.println(appointment);
            hasAppointments = true;
        }
    }
    if (!hasAppointments) {
        System.out.println("No appointments found.");
    }
}

public void provideFeedback(List<Appointment> appointments, Scanner scanner) {
    System.out.print("Enter appointment ID to provide feedback: ");
    try {
        int appointmentId = scanner.nextInt();
        scanner.nextLine();
        for (Appointment appointment : appointments) {
            if (appointment.getId() == appointmentId) {
                System.out.print("Enter feedback (1-5 stars): ");
                int feedbackScore = scanner.nextInt();
                scanner.nextLine();
                appointment.setFeedback(feedbackScore);
                System.out.print("Enter optional comments: ");
                String comments = scanner.nextLine();
                appointment.setComments(comments);
                System.out.println("Thank you for your feedback!");
                return;
            }
        }
        System.out.println("Appointment not found.");
    } catch (Exception e) {
        System.out.println("Invalid input!");
        scanner.nextLine();
    }
}

public void checkForUpcomingAppointments(User user, List<Appointment> appointments) {
    LocalDateTime now = LocalDateTime.now();
    System.out.println("\nReminder for Upcoming Appointments:");
    boolean hasReminders = false;
    for (Appointment appointment : appointments) {
        if (appointment.getUserId() == user.getId() && appointment.getStatus().equals("Pending")) {
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