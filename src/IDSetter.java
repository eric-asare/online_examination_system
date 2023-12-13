/**
 * Class sets the IDs for all managers to synchronize
 */
public class IDSetter {
    private static IDSetter instance = null;
    private ExamManager exManager;
    private AnswerManager ansManager;
    private RegradeManager reManager;

    private IDSetter() {
        exManager = ExamManager.get();
        ansManager = AnswerManager.get();
        reManager = RegradeManager.get();
    }

    public static IDSetter get() {
        if (instance == null) {
            instance = new IDSetter();
        }
        return instance;
    }

    public void setExamID(int examID) {
        exManager.setID(examID);
        ansManager.setExamID(examID);
        reManager.setExamID(examID);
    }

    public void setStudentID(String studentID) {
        ansManager.setStudentID(studentID);
        reManager.setStudentID(studentID);
    }

    public void setRequestID(int requestID) {
        reManager.setRequestID(requestID);
    }
}