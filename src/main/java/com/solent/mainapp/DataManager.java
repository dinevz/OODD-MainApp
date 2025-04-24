package com.solent.mainapp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Author: Group work
// Task: Group Integration - Centralized data management with enhanced hardcoded data for testing
// Integration Note: This class provides diverse users, appointments, and FAQs to test all functionalities
// for Group Member A (student features), B (admin features), and C (FAQs, analytics).
public class DataManager {
    private static List<User> userList = new ArrayList<>();
    private static List<Appointment> appointmentList = new ArrayList<>();
    private static List<FAQ> faqList = new ArrayList<>();

    public static List<User> getUserList() { return userList; }
    public static List<Appointment> getAppointmentList() { return appointmentList; }
    public static List<FAQ> getFaqList() { return faqList; }

    // Initialize sample data for testing all functionalities
    public static void initializeData() {
        // Users: 4 students, 2 admins for login and role testing
        userList.add(new User(1, "Chathurika", "chathu@example.com", "securePass123", "student"));
        userList.add(new User(2, "Anna", "anna@example.com", "Pass123", "admin"));
        userList.add(new User(3, "Ben", "ben@example.com", "StudentPass456", "student"));
        userList.add(new User(4, "Clara", "clara@example.com", "AdminPass789", "admin"));
        userList.add(new User(5, "David", "david@example.com", "DavidPass101", "student"));
        userList.add(new User(6, "Emma", "emma@example.com", "EmmaPass202", "student"));

        // Appointments: Diverse data to test session requests, viewing, feedback, reminders, and admin management
        appointmentList.add(new Appointment(1, 1, "Mental Health", LocalDateTime.parse("2025-03-28T10:00"), 4, "Very helpful session", "Approved"));
        appointmentList.add(new Appointment(2, 1, "Academic Support", LocalDateTime.parse("2025-03-29T14:00"), null, null, "Pending"));
        appointmentList.add(new Appointment(3, 1, "Financial Aid", LocalDateTime.parse("2025-03-30T09:00"), 2, "Needed more details", "Approved"));
        appointmentList.add(new Appointment(4, 3, "Mental Health", LocalDateTime.parse("2025-04-01T11:00"), 5, "Excellent support", "Approved"));
        appointmentList.add(new Appointment(5, 3, "Academic Support", LocalDateTime.parse("2025-04-02T15:00"), null, null, "Canceled"));
        appointmentList.add(new Appointment(6, 5, "Financial Aid", LocalDateTime.parse("2025-03-27T16:00"), 3, "Average experience", "Approved"));
        appointmentList.add(new Appointment(7, 5, "Mental Health", LocalDateTime.parse("2025-03-28T12:00"), null, null, "Pending"));
        appointmentList.add(new Appointment(8, 6, "Academic Support", LocalDateTime.parse("2025-03-26T10:00"), 1, "Not enough time", "Approved"));
        appointmentList.add(new Appointment(9, 6, "Financial Aid", LocalDateTime.parse("2025-04-10T13:00"), null, null, "Approved"));
        appointmentList.add(new Appointment(10, 1, "Mental Health", LocalDateTime.parse("2025-03-27T09:00"), 4, "Great counselor", "Approved"));

        // FAQs: Comprehensive set for viewing and management testing
        faqList.add(new FAQ(1, "What is mental health support?", "Includes counseling, therapy, and stress management sessions."));
        faqList.add(new FAQ(2, "How do I apply for financial aid?", "Book a session with the financial aid office or visit their website."));
        faqList.add(new FAQ(3, "What is academic support?", "Tutoring, study skills workshops, and academic advising."));
        faqList.add(new FAQ(4, "Can I cancel a session?", "Yes, contact the support office or ask an admin to cancel your appointment."));
        faqList.add(new FAQ(5, "Who can access support services?", "All registered Solent University students."));
        faqList.add(new FAQ(6, "Are sessions confidential?", "Yes, all support sessions are private and confidential."));
    }
}
