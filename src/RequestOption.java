public class RequestOption {
    private int requestID;
    private String status;
    private RegradeManager reManager;

    public RequestOption(int requestID, String status) {
        this.requestID = requestID;
        this.status = status;
        reManager = RegradeManager.get();
    }

    public int getID() {
        return requestID;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("Question Number: %d, Status: %s", reManager.getNum(requestID), status);
    }
}