package com.solent.mainapp;

import java.util.List;
import java.util.Scanner;

// Author: George
// Task: Group Member C - FAQ management
public class FAQService {
    public void viewFAQs(List<FAQ> faqs) {
        System.out.println("\nStudent Welfare FAQs:");
        if (faqs.isEmpty()) {
            System.out.println("No FAQs available.");
        } else {
            for (FAQ faq : faqs) {
                System.out.println(faq);
            }
        }
    }

    public void manageFAQs(List<FAQ> faqs, Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\nFAQ Management Menu:");
            System.out.println("1. Add FAQ");
            System.out.println("2. Update FAQ");
            System.out.println("3. Remove FAQ");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        addFAQ(faqs, scanner);
                        break;
                    case 2:
                        updateFAQ(faqs, scanner);
                        break;
                    case 3:
                        removeFAQ(faqs, scanner);
                        break;
                    case 4:
                        System.out.println("Exiting FAQ Management...");
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

    private void addFAQ(List<FAQ> faqs, Scanner scanner) {
        System.out.print("Enter FAQ question: ");
        String question = scanner.nextLine();
        System.out.print("Enter FAQ answer: ");
        String answer = scanner.nextLine();
        FAQ faq = new FAQ(faqs.size() + 1, question, answer);
        faqs.add(faq);
        System.out.println("FAQ added successfully.");
    }

    private void updateFAQ(List<FAQ> faqs, Scanner scanner) {
        System.out.print("Enter FAQ ID to update: ");
        int faqId;
        try {
            faqId = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid ID! Please enter a number.");
            scanner.nextLine();
            return;
        }

        for (FAQ faq : faqs) {
            if (faq.getId() == faqId) {
                System.out.println("Updating FAQ: " + faq);
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
    }

    private void removeFAQ(List<FAQ> faqs, Scanner scanner) {
        System.out.print("Enter FAQ ID to remove: ");
        int faqId;
        try {
            faqId = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid ID! Please enter a number.");
            scanner.nextLine();
            return;
        }

        faqs.removeIf(faq -> faq.getId() == faqId);
        System.out.println("FAQ removed successfully.");
    }
}
