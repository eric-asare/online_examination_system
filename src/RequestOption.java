/**
 * Class represents the identifying info for a request file for selection
 */
public class RequestOption {
    private String studentID;
    private int requestID;
    private String status;
    private RegradeManager reManager;

    public RequestOption(String studentID, int requestID, String status) {
        this.studentID = studentID;
        this.requestID = requestID;
        this.status = status;
        reManager = RegradeManager.get();
    }

    public String getStudentID() {
        return studentID;
    }

    public int getRequestID() {
        return requestID;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("Student: %s, Question Number: %d, Status: %s", studentID, reManager.getNum(requestID), status);
    }
}