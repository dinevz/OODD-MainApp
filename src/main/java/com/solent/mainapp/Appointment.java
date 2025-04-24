package com.solent.mainapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Author: Zhivko
// Task: Group Member A - Appointment class for session requests and feedback
public class Appointment {
    private int id;
    private int userId; // Links appointment to a user
    private String supportType;
    private LocalDateTime dateTime;
    private Integer feedback;
    private String comments; // For feedback comments
    private String status;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Appointment(int id, int userId, String supportType, LocalDateTime dateTime, Integer feedback, String comments) {
        this.id = id;
        this.userId = userId;
        this.supportType = validateSupportType(supportType);
        this.dateTime = dateTime;
        this.feedback = validateFeedback(feedback);
        this.comments = comments;
        this.status = "Pending";
    }

    // Validate support type
    private String validateSupportType(String supportType) {
        if (!supportType.equals("Mental Health") && !supportType.equals("Academic Support") && !supportType.equals("Financial Aid")) {
            throw new IllegalArgumentException("Invalid support type");
        }
        return supportType;
    }

    // Validate feedback score
    private Integer validateFeedback(Integer feedback) {
        if (feedback != null && (feedback < 1 || feedback > 5)) {
            throw new IllegalArgumentException("Feedback must be between 1 and 5");
        }
        return feedback;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getSupportType() { return supportType; }
    public void setSupportType(String supportType) { this.supportType = validateSupportType(supportType); }
    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
    public Integer getFeedback() { return feedback; }
    public void setFeedback(Integer feedback) { this.feedback = validateFeedback(feedback); }
    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", userId=" + userId +
                ", supportType='" + supportType + '\'' +
                ", dateTime=" + dateTime.format(FORMATTER) +
                ", feedback=" + feedback +
                ", comments='" + comments + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
