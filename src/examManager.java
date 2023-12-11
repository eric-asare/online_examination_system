import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class ExamManager {

  private static ExamManager instance = null;
  private int examID;
  private ArrayList<Question> questions;

  private ArrayList<String> exams;

  private ExamManager() {
    questions = new ArrayList<Question>();
    exams = new ArrayList<String>();
    Scanner sc = null;
    try {
      File f = new File("examdata.bin");
      sc = new Scanner(f).useDelimiter("\t");
      while (sc.hasNext()) {
        exams.add(sc.next());
      }
    } catch (IOException e) {

    } finally {
      if (sc != null) {
        sc.close();
      }
    }
  }

  public static ExamManager get() {
    if (instance == null) {
      instance = new ExamManager();
    }
    return instance;
  }

  public String getName(int examID) {
    return exams.get(examID);
  }

  public void setID(int examID) {
    this.examID = examID;
  }

  public void save(Question q) {
    questions.add(q);
    System.out.println(q.getQuestion());
    System.out.println(q.getAnswer());
  }

  public Question getQuestion(int question_no) {
    return questions.get(question_no-1);
  }

  public int getLength() {
    return questions.size();
  }

  public void open_exam_file() {
    questions.clear();
    String filepath = String.format("exams/exam_%d.txt", examID);
    Scanner sc = null;
    try {
      File exam = new File(filepath);
      sc = new Scanner(exam).useDelimiter("\t");
      System.out.println("Hello");
      sc.next();
      while (sc.hasNext()) {
        int type = sc.nextInt();
        if (type != 0) {
          int weight = sc.nextInt();
          String question = sc.next();
          String answer = sc.next();
          Question q = new TextQuestion(question, answer, weight);
          questions.add(q);
          System.out.println(q.toString());
        }
        else {
          int weight = sc.nextInt();
          String question = sc.next();
          int num_choices = sc.nextInt();
          String[] answers = new String[num_choices];
          for (int i = 0; i < num_choices; i++) {
            answers[i] = sc.next();
          }
          int ans_choice = sc.nextInt();
          Question q = new MCQuestion(question, answers, ans_choice, weight);
          questions.add(q);
          System.out.println(q.toString());
        }
      }
    } catch (IOException e) {

    } finally {
    if (sc != null) {
        sc.close();
    }
    }
  }

  public void submit(String name) {
    try {
      examID = exams.size();
      exams.add(name);
      String filepath = String.format("exams/exam_%d.txt", examID);
      FileWriter wr = new FileWriter(filepath);
      wr.write(String.format("%d\t", examID));
      for (Question question : questions) {
        wr.write(question.toString());
      }
      wr.close();

      wr = new FileWriter("examdata.bin", true);
      wr.write(String.format("%s\t", name));
      wr.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public int[] get_exams_display_info() {
    File dir = new File("exams");
    File[] files = dir.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
          return name.startsWith("exam_") && name.endsWith(".txt");
      }
    });
    
    int[] results = new int[files.length];

    for (int i = 0; i < files.length; i++) {
      Scanner sc = null;
      try {
        sc = new Scanner(files[i]).useDelimiter("\t");
        int exam = sc.nextInt();
        results[i] = exam;
      } catch (IOException e) {
        results[i] = -1;
      } finally {
        if (sc != null) {
          sc.close();
        }
      }
    }

    return results;
  }
}

