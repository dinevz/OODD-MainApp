public static List<User> getUserList() { return userList; }
public static List<Appointment> getAppointmentList() { return appointmentList; }

public static void initializeData() {
    // Users: Only students for A’s tasks
    userList.add(new User(1, "Zhivko", "zhivko@example.com", "pass123", "student"));
    userList.add(new User(2, "Ben", "ben@example.com", "pass456", "student"));

    // Appointments: Data for testing A’s tasks (request, view, feedback, reminders)
    appointmentList.add(new Appointment(1, 1, "Mental Health", LocalDateTime.parse("2025-03-28T10:00"), 4, "Helpful session"));
    appointmentList.add(new Appointment(2, 1, "Academic Support", LocalDateTime.parse("2025-03-29T14:00"), null, null));
    appointmentList.add(new Appointment(3, 2, "Financial Aid", LocalDateTime.parse("2025-03-30T09:00"), 3, "Good advice"));
}