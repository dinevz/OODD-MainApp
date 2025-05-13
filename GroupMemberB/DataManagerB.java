public static List<User> getUserList() { return userList; }
public static List<Appointment> getAppointmentList() { return appointmentList; }

public static void initializeData() {
    // Users: Students and admins for role-based login
    userList.add(new User(1, "Zhivko", "zhivko@example.com", "pass123", "student"));
    userList.add(new User(2, "Anna", "anna@example.com", "admin123", "admin"));

    // Appointments: Data for testing B’s tasks (view, approve, feedback)
    appointmentList.add(new Appointment(1, 1, "Mental Health", LocalDateTime.parse("2025-03-28T10:00"), 4, "Helpful", "Pending"));
    appointmentList.add(new Appointment(2, 1, "Academic Support", LocalDateTime.parse("2025-03-29T14:00"), null, null, "Pending"));
}