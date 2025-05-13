public static List<User> getUserList() { return userList; }
public static List<Appointment> getAppointmentList() { return appointmentList; }
public static List<FAQ> getFaqList() { return faqList; }

public static void initializeData() {
    // Users: Students and admins for role-based FAQ access
    userList.add(new User(1, "Zhivko", "zhivko@example.com", "pass123", "student"));
    userList.add(new User(2, "Anna", "anna@example.com", "admin123", "admin"));

    // Appointments: Data for analytics
    appointmentList.add(new Appointment(1, 1, "Mental Health", LocalDateTime.parse("2025-03-28T10:00"), 4, "Helpful", "Approved"));
    appointmentList.add(new Appointment(2, 1, "Academic Support", LocalDateTime.parse("2025-03-29T14:00"), 3, "Good", "Approved"));

    // FAQs: Data for viewing and management
    faqList.add(new FAQ(1, "What is mental health support?", "Counseling and therapy sessions."));
    faqList.add(new FAQ(2, "How to apply for financial aid?", "Book a session or visit the office."));
}