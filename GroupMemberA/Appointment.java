public Appointment(int id, int userId, String supportType, LocalDateTime dateTime, Integer feedback, String comments) {
    this.id = id;
    this.userId = userId;
    this.supportType = validateSupportType(supportType);
    this.dateTime = dateTime;
    this.feedback = validateFeedback(feedback);
    this.comments = comments;
    this.status = "Pending";
}

private String validateSupportType(String supportType) {
    if (supportType == null || (!supportType.equals("Mental Health") && !supportType.equals("Academic Support") && !supportType.equals("Financial Aid"))) {
        throw new IllegalArgumentException("Invalid support type");
    }
    return supportType;
}

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
    return "Appointment{id=" + id + ", userId=" + userId + ", supportType='" + supportType + "', dateTime=" +
            (dateTime != null ? dateTime.format(FORMATTER) : "null") + ", feedback=" + feedback + ", comments='" +
            (comments != null ? comments : "null") + "', status='" + status + "'}";
}