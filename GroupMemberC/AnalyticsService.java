public void showFeedbackAnalysis(List<Appointment> appointments) {
    int totalFeedback = 0, count = 0;
    for (Appointment appointment : appointments) {
        if (appointment.getFeedback() != null) {
            totalFeedback += appointment.getFeedback();
            count++;
        }
    }
    System.out.println("\nFeedback Analysis:");
    System.out.println("Average Feedback Score: " + (count > 0 ? (double) totalFeedback / count : "No feedback"));
}