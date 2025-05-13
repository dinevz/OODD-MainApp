public Appointment(int id, int userId, String supportType, LocalDateTime dateTime, Integer feedback, String comments, String status) {
    this.id = id;
    this.userId = userId;
    this.supportType = supportType;
    this.dateTime = dateTime;
    this.feedback = feedback;
    this.comments = comments;
    this.status = status;
}

public int getId() { return id; }
public int getUserId() { return userId; }
public String getSupportType() { return supportType; }
public LocalDateTime getDateTime() { return dateTime; }
public Integer getFeedback() { return feedback; }
public String getComments() { return comments; }
public String getStatus() { return status; }