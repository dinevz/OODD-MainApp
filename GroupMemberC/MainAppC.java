public static void main(String[] args) {
    DataManagerC.initializeData();
    userList = DataManagerC.getUserList();
    appointmentList = DataManagerC.getAppointmentList();
    faqList = DataManagerC.getFaqList();

    System.out.println("Welcome to CampusAssist (Group Member C)");
    login();
    if (loggedInUser != null) {
        if (loggedInUser.getRole().equals("admin")) {
            adminMenu();
        } else {
            studentMenu();
        }
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

private static void studentMenu() {
    while (true) {
        System.out.println("\nStudent Menu (FAQs):");
        System.out.println("1. View FAQs");
        System.out.println("2. Exit");
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
            case 1 -> faqService.viewFAQs();
            case 2 -> {
                return;
            }
            default -> System.out.println("Invalid option!");
        }
    }
}

private static void adminMenu() {
    while (true) {
        System.out.println("\nAdmin Menu:");
        System.out.println("1. View FAQs");
        System.out.println("2. Manage FAQs");
        System.out.println("3. View Appointment Trends");
        System.out.println("4. View Feedback Analysis");
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
            case 1 -> faqService.viewFAQs();
            case 2 -> faqService.manageFAQs(faqList, scanner);
            case 3 -> analyticsService.showAppointmentTrends(appointmentList);
            case 4 -> analyticsService.showFeedbackAnalysis(appointmentList);
            case 5 -> {
                return;
            }
            default -> System.out.println("Invalid option!");
        }
    }
}