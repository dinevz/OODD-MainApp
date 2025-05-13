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
public void setId(int id) { this.id = id; }
public int getUserId() { return userId; }
public void setUserId(int userId) { this.userId = userId; }
public String getSupportType() { return supportType; }
public void setSupportType(String supportType) { this.supportType = supportType; }
public LocalDateTime getDateTime() { return dateTime; }
public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
public Integer getFeedback() { return feedback; }
public void setFeedback(Integer feedback) { this.feedback = feedback; }
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