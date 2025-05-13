public void manageFAQs(List<FAQ> faqs, Scanner scanner) {
    while (true) {
        System.out.println("\nManage FAQs:");
        System.out.println("1. Add FAQ");
        System.out.println("2. Update FAQ");
        System.out.println("3. Remove FAQ");
        System.out.println("4. Exit");
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
            case 1 -> addFAQ(faqs, scanner);
            case 2 -> updateFAQ(faqs, scanner);
            case 3 -> removeFAQ(faqs, scanner);
            case 4 -> {
                return;
            }
            default -> System.out.println("Invalid option!");
        }
    }
}

private void addFAQ(List<FAQ> faqs, Scanner scanner) {
    System.out.print("Enter question: ");
    String question = scanner.nextLine();
    System.out.print("Enter answer: ");
    String answer = scanner.nextLine();
    FAQ faq = new FAQ(faqs.size() + 1, question, answer);
    faqs.add(faq);
    System.out.println("FAQ added successfully.");
}

private void updateFAQ(List<FAQ> faqs, Scanner scanner) {
    System.out.print("Enter FAQ ID to update: ");
    try {
        int faqId = scanner.nextInt();
        scanner.nextLine();
        for (FAQ faq : faqs) {
            if (faq.getId() == faqId) {
                System.out.print("Enter new question: ");
                String question = scanner.nextLine();
                System.out.print("Enter new answer: ");
                String answer = scanner.nextLine();
                faq.setQuestion(question);
                faq.setAnswer(answer);
                System.out.println("FAQ updated successfully.");
                return;
            }
        }
        System.out.println("FAQ not found.");
    } catch (Exception e) {
        System.out.println("Invalid input!");
        scanner.nextLine();
    }
}

private void removeFAQ(List<FAQ> faqs, Scanner scanner) {
    System.out.print("Enter FAQ ID to remove: ");
    try {
        int faqId = scanner.nextInt();
        scanner.nextLine();
        faqs.removeIf(faq -> faq.getId() == faqId);
        System.out.println("FAQ removed successfully.");
    } catch (Exception e) {
        System.out.println("Invalid input!");
        scanner.nextLine();
    }
}