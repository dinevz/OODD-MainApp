package com.solent.mainapp;

public class Appointment {

    private int id;                 // Appointment ID
    private String supportType;     // Type of support (Mental Health, Academic Support, etc.)
    private String dateTime;        // Date and time of the appointment (in a string format)
    private Integer feedback;       // Feedback score (1-5)
    private String status;          // Status of the appointment (Approved, Canceled, Pending)

    // Constructor to initialize the appointment
    public Appointment(int id, String supportType, String dateTime, Integer feedback) {
        this.id = id;
        this.supportType = supportType;
        this.dateTime = dateTime;
        this.feedback = feedback;
        this.status = "Pending"; // Default status is "Pending"
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupportType() {
        return supportType;
    }

    public void setSupportType(String supportType) {
        this.supportType = supportType;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getFeedback() {
        return feedback;
    }

    public void setFeedback(Integer feedback) {
        this.feedback = feedback;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Override toString method to display the appointment details
    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", supportType='" + supportType + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", feedback=" + feedback +
                ", status='" + status + '\'' +
                '}';
    }
}
