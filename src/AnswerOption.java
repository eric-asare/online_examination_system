public class AnswerOption {
    private String studentID;
    private String status;

    public AnswerOption(String studentID, String status) {
        this.studentID = studentID;
        this.status = status;
    }

    public String getID() {
        return studentID;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("Student: %s, Status: %s", studentID, status);
    }
}