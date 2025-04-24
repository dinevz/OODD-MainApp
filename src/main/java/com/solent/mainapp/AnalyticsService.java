package com.solent.mainapp;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Author: George
// Task: Group Member C - Appointment and feedback analytics
public class AnalyticsService {
    public void showAnalytics(List<Appointment> appointments) {
        System.out.println("\nAnalytics Dashboard:");
        showAppointmentTrends(appointments);
        showFeedbackAnalysis(appointments);
    }

    private void showAppointmentTrends(List<Appointment> appointments) {
        System.out.println("\nAppointment Trends:");
        Map<String, Integer> typeCounts = new HashMap<>();
        Map<String, Integer> timeSlots = new HashMap<>();
        int totalAppointments = appointments.size();

        for (Appointment a : appointments) {
            // Support type counts
            typeCounts.put(a.getSupportType(), typeCounts.getOrDefault(a.getSupportType(), 0) + 1);

            // Peak time slots (hourly)
            String hour = a.getDateTime().getHour() + ":00";
            timeSlots.put(hour, timeSlots.getOrDefault(hour, 0) + 1);
        }

        System.out.println("Total Appointments: " + totalAppointments);
        System.out.println("Support Type Distribution: " + typeCounts);
        System.out.println("Peak Time Slots: " + timeSlots);
    }

    private void showFeedbackAnalysis(List<Appointment> appointments) {
        System.out.println("\nFeedback Analysis:");
        int totalFeedback = 0, positive = 0, negative = 0;
        double sum = 0;
        Map<String, Integer> commonConcerns = new HashMap<>();

        for (Appointment a : appointments) {
            if (a.getFeedback() != null) {
                totalFeedback++;
                sum += a.getFeedback();
                if (a.getFeedback() >= 4) positive++;
                else if (a.getFeedback() <= 2) negative++;

                // Analyze comments (basic keyword counting)
                if (a.getComments() != null) {
                    String[] words = a.getComments().toLowerCase().split("\\s+");
                    for (String word : words) {
                        if (word.contains("concern") || word.contains("issue")) {
                            commonConcerns.put(word, commonConcerns.getOrDefault(word, 0) + 1);
                        }
                    }
                }
            }
        }

        if (totalFeedback > 0) {
            System.out.println("Average Feedback Score: " + String.format("%.2f", sum / totalFeedback));
            System.out.println("Positive Reviews (4-5): " + positive);
            System.out.println("Negative Reviews (1-2): " + negative);
            System.out.println("Common Concerns in Comments: " + commonConcerns);
        } else {
            System.out.println("No feedback available.");
        }
    }
}
