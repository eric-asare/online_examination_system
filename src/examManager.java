import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
// TODO : Make it a singleton
public class examManager {

    private ArrayList<Question> questions;

    public examManager() {
        questions = new ArrayList<Question>();
        Question q1 = new MCQuestion("Hello", new String[]{"a", "b"}, 0, 5);
        Question q2 = new TextQuestion("Hello 2", "ans", 4);
        questions.add(q1);
        questions.add(q2);
    }

    public void save(Question q) {
      questions.add(q);
      System.out.println(q.getQuestion());
      System.out.println(q.getAnswer());
    }

    public Question get(int question_no) {
        return questions.get(question_no-1);
    }

    public int getLength() {
        return questions.size();
    }

    public void open_exam_file(int examID) {
    questions.clear();
    String filepath = String.format("exams/exam_%d.txt", examID);
    Scanner sc = null;
    try {
        File exam = new File(filepath);
        sc = new Scanner(exam).useDelimiter("\t");
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

    /*
    private static void writeToFile(String filePath, String... content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

            // Writing content to the file
            for (String str : content) {
                writer.write(str);
            }

            // Closing the writer
            writer.close();

            System.out.println("Content has been written to the file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void get_requests_display_info() {
      if (filepaths == null || filepaths.isEmpty()) {
          System.out.println("No requests available.");
          return;
      }

      List<String> formattedInfoList = new ArrayList<>();
      for (String path : filepaths) {
          String[] parts = path.split(",");
          if (parts.length == 4) {
              int studentID = Integer.parseInt(parts[0].substring(parts[0].indexOf("/") + 1)); // Extracting student ID
              int examID = Integer.parseInt(parts[1]);
              int requestStudentID = Integer.parseInt(parts[2]);
              int requestID = Integer.parseInt(parts[3]);

              String formattedInfo = String.format("Exam ID: %d, Student ID: %d, Request ID: %d",
                      examID, studentID, requestStudentID, requestID);
              formattedInfoList.add(formattedInfo);
          }
      }

      if (!formattedInfoList.isEmpty()) {
          System.out.println("Requests Information:");
          for (String info : formattedInfoList) {
              System.out.println(info);
          }
      } else {
          System.out.println("No requests information available.");
      }
  }


  public static void open_request(){
    // use the scanner approach
     
  }




    public static void main(String[] args) {
        RegradeManager.save("Request text", 123, 456, 789);
        RegradeManager.save("Request text", 123, 456, 89);
        RegradeManager.get_requests_display_info();
    }
    */
}

