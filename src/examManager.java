import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class ExamManager {

    private static ExamManager instance = null;
    private int examID;
    private ArrayList<Question> questions;

    private ExamManager() {
        questions = new ArrayList<Question>();
        // Question q1 = new MCQuestion("Hello", new String[]{"a", "b"}, 0, 5);
        // Question q2 = new TextQuestion("Hello 2", "ans", 4);
        // questions.add(q1);
        // questions.add(q2);
    }

    public static ExamManager get() {
        if (instance == null) {
            instance = new ExamManager();
        }
        return instance;
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
            sc.nextLine();
            sc.nextLine();
            while (sc.hasNext()) {
                int type = sc.nextInt();
                sc.nextLine();
                if (type != 0) {
                    int weight = sc.nextInt();
                    sc.nextLine();
                    String question = sc.nextLine();
                    String answer = sc.nextLine();
                    Question q = new TextQuestion(question, answer, weight);
                    questions.add(q);
                }
                else {
                    int weight = sc.nextInt();
                    sc.nextLine();
                    String question = sc.nextLine();
                    int num_choices = sc.nextInt();
                    sc.nextLine();
                    String[] answers = new String[num_choices];
                    for (int i = 0; i < num_choices; i++) {
                        answers[i] = sc.nextLine();
                    }
                    int ans_choice = sc.nextInt();
                    sc.nextLine();
                    Question q = new MCQuestion(question, answers, ans_choice, weight);
                    questions.add(q);
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
          String filepath = String.format("exams/exam_%d.txt", examID);
          FileWriter wr = new FileWriter(filepath);
          wr.write(String.format("%s\t%s\t", name, teacher_name));
          for (Question question : questions) {
            wr.write(question.toString());
          }
          wr.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    
    public String[] get_exams_display_info() {
        File dir = new File("exams");
        File[] files = dir.listFiles(new FilenameFilter() {
          public boolean accept(File dir, String name) {
              return name.startsWith("exam_") && name.endsWith(".txt");
          }
        });
        String [] results = new String[files.length];
    
        for (int i = 0; i < files.length; i++) {
          Scanner sc = null;
          try {
            sc = new Scanner(files[i]).useDelimiter("\t");
            String exam_name = sc.nextLine();
            String teacher_name = sc.nextLine();
            results[i] = String.format("%s\t%s", exam_name, teacher_name);
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
}

