import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AnswerManager {
  
  private static AnswerManager instance;
  private int examID;
  private int studentID;
  
  private ArrayList<Answer> answers;
  private static ArrayList<String> students;

  private AnswerManager() {
    answers = new ArrayList<Answer>();
    //load students
  }

  public static AnswerManager get() {
    if (instance == null) {
      instance = new AnswerManager();
    }
    return instance;
  }

  public void setExamID(int examID) {
    this.examID = examID;
  }

  public void setStudentID(int studentID) {
    this.studentID = studentID;
  }

  public void save(String ans, int question_no) {
    Answer answer = new Answer(ans, -1, "");
    if (question_no > answers.size()) {
      answers.add(answer);
    }
    answers.set(question_no-1, answer);
  }

  public void grade(String feedback, int score, int question_no) {
    answers.get(question_no-1).setGrade(score);
    answers.get(question_no-1).setFeedback(feedback);
  }

  public void submit(String status) {
    try {
      String filepath = String.format("answers/answer_%d_%d.txt", examID, studentID);
      FileWriter wr = new FileWriter(filepath);
      wr.write(String.format("%s\t%s\t", studentID, status));
      for (Answer answer : answers) {
        wr.write(answer.toString());
      }
      wr.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String[] get_answers_display_info() {
    File dir = new File("answers");
    File[] files = dir.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
          return name.startsWith(String.format("answer_%d_", examID)) && name.endsWith(".txt");
      }
    });
    String [] results = new String[files.length];

    for (int i = 0; i < files.length; i++) {
      Scanner sc = null;
      try {
        sc = new Scanner(files[i]).useDelimiter("\t");
        int studentID = sc.nextInt();
        String status = sc.next();
        results[i] = String.format("%s\t%s", studentID, status);
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
    answers.clear();
    String filepath = String.format("answers/answer_%d_%d.txt", examID, studentID);
    Scanner sc = null;
    try {
      File answer_file = new File(filepath);
      sc = new Scanner(answer_file).useDelimiter("\t");
      sc.next();
      sc.next();
      while (sc.hasNext()) {
        String ans = sc.next();
        int score = sc.nextInt();
        String feedback = sc.next();
        answers.add(new Answer(ans, score, feedback));
      }
    } catch (IOException e) {

    } finally {
      if (sc != null) {
        sc.close();
      }
    }
  }

}