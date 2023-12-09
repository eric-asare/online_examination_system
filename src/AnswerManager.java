import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AnswerManager {
  private int examID;
  private int studentID;
  
  private ArrayList<String> student_answers;
  private ArrayList<String> grade_feedback;
  private ArrayList<Integer> grade_scores;

  public AnswerManager(int examID, int studentID) {
    this.examID = examID;
    this.studentID = studentID;
  }

  public void save(String ans, int question_no) {
    if (question_no > student_answers.size()) {
      student_answers.ensureCapacity(question_no);
    }
    student_answers.set(question_no-1, ans);
  }

  public void grade(String feedback, int score, int question_no) {
    if (question_no > grade_feedback.size()) {
      grade_scores.ensureCapacity(question_no);
      grade_feedback.ensureCapacity(question_no);
    }
    grade_feedback.set(question_no-1, feedback);
    grade_scores.set(question_no-1, score);
  }

  public void submit_answers() {
    //write to file
  }

  public void submit_grades() {

  }

  public static String[] get_answers_display_info() {
    File dir = new File("answers");
    File[] files = dir.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
          return name.startsWith("answer") && name.endsWith(".txt");
      }
    });
    String [] results = new String[files.length];

    for (int i = 0; i < files.length; i++) {
      Scanner sc = null;
      try {
        sc = new Scanner(files[i]).useDelimiter("\t");
        int exam = sc.nextInt();
        sc.nextLine();
        int student = sc.nextInt();
        sc.nextLine();
        String grade = sc.nextLine();
        results[i] = String.format("%d\t%d\t%s", exam, student, grade);
      } catch (IOException e) {
        results[i] = "";
      } finally {
        if (sc != null) {
          sc.close();
        }
      }
    }

    return results;

  }

  public void open_answers_file() {
    student_answers.clear();
    grade_feedback.clear();
    grade_scores.clear();
    String filepath = String.format("answers/answer_%d_%d.txt", examID, studentID);
    Scanner sc = null;
    try {
      File answers = new File(filepath);
      sc = new Scanner(answers).useDelimiter("\t");
      sc.nextLine();
      sc.nextLine();
      sc.nextLine();
      while (sc.hasNext()) {
        student_answers.add(sc.nextLine());
        grade_feedback.add(sc.nextLine());
        grade_scores.add(sc.nextInt());
        sc.nextLine();
      }
    } catch (IOException e) {

    } finally {
      if (sc != null) {
        sc.close();
      }
    }
  }

}