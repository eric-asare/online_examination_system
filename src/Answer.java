/**
 * Class represents a single answer to a question, storing the student's answer and the grader's grade
 */

public class Answer {
  private String ans;
  private int grade;
  private String feedback;
  private int ans_choice;

  public Answer() {
    ans = "";
    grade = -1;
    feedback = "";
    ans_choice = -1;
  }

  public Answer(String ans, int grade, String feedback) {
    this.ans = ans.replaceAll("\t", "  ");
    this.grade = grade;
    this.feedback = feedback.replaceAll("\t", "  ");
  }

  public String getAns() {
    return ans;
  }

  public int getGrade() {
    return grade;
  }

  public String getFeedback() {
    return feedback;
  }

  public int getAnsChoice() {
    return ans_choice;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  public void setFeedback(String feedback) {
    this.feedback = feedback.replaceAll("\t", "  ");
  }

  public void setChoice(int ans_choice) {
    this.ans_choice = ans_choice;
  }

  public String toString() {
    return String.format("%s\t%d\t%s\t", ans, grade, feedback);
  }
}
