/**
 * Class represents the identifying info for an exam file for selection
 */
public class ExamOption {
    private int examID;
    private int time;
    private ExamManager exManager;

    public ExamOption(int examID, int time) {
        this.examID = examID;
        this.time = time;
        exManager = ExamManager.get();
    }

    public int getID() {
        return examID;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.format("Exam: %s, Time: %d", exManager.getName(examID), time);
    }
}