import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AnswerManager {
  
  private static AnswerManager instance = null;
  private int examID;
  private String studentID;
  
  private ArrayList<Answer> answers;

  private AnswerManager() {
    answers = new ArrayList<Answer>();
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

  public void setStudentID(String studentID) {
    this.studentID = studentID;
  }

  public Answer getAnswer(int question_no) {
    return answers.get(question_no-1);
  }

  public void save(String ans, int question_no, int choice) {
    Answer answer = new Answer(ans, -1, "");
    answer.setChoice(choice);
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
      String filepath = String.format("answers/answer_%d_%s.txt", examID, studentID);
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

  public AnswerOption[] get_answers_display_info() {
    File dir = new File("answers");
    File[] files = dir.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
          return name.startsWith(String.format("answer_%d_", examID)) && name.endsWith(".txt");
      }
    });
    AnswerOption[] results = new AnswerOption[files.length];

    for (int i = 0; i < files.length; i++) {
      Scanner sc = null;
      try {
        sc = new Scanner(files[i]).useDelimiter("\t");
        String studentID = sc.next();
        String status = sc.next();
        results[i] = new AnswerOption(studentID, status);
      } catch (IOException e) {
        results[i] = null;
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
    String filepath = String.format("answers/answer_%d_%s.txt", examID, studentID);
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