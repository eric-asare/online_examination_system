import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class examManager {

    private ArrayList<Question> questions;

    public examManager() {
      questions = new ArrayList<Question>();
    }

    public void save(Question q) {
      questions.add(q);
      System.out.println(q.getQuestion());
      System.out.println(q.getAnswer());
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
