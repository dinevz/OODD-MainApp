public FAQ(int id, String question, String answer) {
    this.id = id;
    this.question = question;
    this.answer = answer;
}

public int getId() { return id; }
public String getQuestion() { return question; }
public String getAnswer() { return answer; }
public void setQuestion(String question) { this.question = question; }
public void setAnswer(String answer) { this.answer = answer; }

@Override
public String toString() {
    return "FAQ{id=" + id + ", question='" + question + "', answer='" + answer + "'}";
}