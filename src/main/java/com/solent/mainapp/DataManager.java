package com.solent.mainapp;

import java.util.ArrayList;
import java.util.List;

// Author: [Group Name]
// Task: Group Integration - Centralized data management
public class DataManager {
    private static List<User> userList = new ArrayList<>();
    private static List<Appointment> appointmentList = new ArrayList<>();
    private static List<FAQ> faqList = new ArrayList<>();

    public static List<User> getUserList() { return userList; }
    public static List<Appointment> getAppointmentList() { return appointmentList; }
    public static List<FAQ> getFaqList() { return faqList; }

    // Initialize sample data
    public static void initializeData() {
        // Sample users
        userList.add(new User(1, "Chathurika", "chathu@example.com", "securePass123", "student"));
        userList.add(new User(2, "Anna", "anna@gmail.com", "Pass123", "admin"));

        // Sample appointments
        appointmentList.add(new Appointment(1, 1, "Mental Health", LocalDateTime.parse("2025-03-28T10:00"), null, null));
        appointmentList.add(new Appointment(2, 1, "Academic Support", LocalDateTime.parse("2025-03-29T14:00"), null, null));
        appointmentList.add(new Appointment(3, 1, "Financial Aid", LocalDateTime.parse("2025-03-30T09:00"), null, null));

        // Sample FAQs
        faqList.add(new FAQ(1, "What is mental health support?", "Mental health support includes counseling and therapy sessions."));
        faqList.add(new FAQ(2, "How do I apply for financial aid?", "Contact the financial aid office or book a session."));
    }
}
