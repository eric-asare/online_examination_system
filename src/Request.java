public class Request {

    private String request_text;
    private String feedback;


    public Request(String request_text, String feedback){
        this.request_text = request_text.replaceAll("\t", "  ");
        this.feedback = feedback.replaceAll("\t", "  ");
    }

    public String getRequest() {
        return request_text;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback.replaceAll("\t", "  ");
    }

    public String toString() {
        return String.format("%s\t%s\t", request_text, feedback);
    }
}
