import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class RegradeManager {
    private static RegradeManager instance;
    private int examID;
    private int studentID;
    private int regradeID;
    
    private Request request;
  
    private RegradeManager() {
        
    }
  
    public static RegradeManager get() {
        if (instance == null) {
            instance = new RegradeManager();
        }
        return instance;
    }
  
    public void setExamID(int examID) {
        this.examID = examID;
    }
  
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setRegradeID(int regradeID) {
        this.regradeID = regradeID;
    }
  
    public void save(String request_text) {
        request = new Request(request_text, "");
    }
  
    public void regrade(String feedback) {
        request.setFeedback(feedback);
    }
  
    public void submit(String status) {
        try {
            String filepath = String.format("answers/answer_%d_%d.txt", examID, studentID);
            FileWriter wr = new FileWriter(filepath);
            wr.write(String.format("%s\t%s\t%d\t%s\t", exam_name, student, question_no, status));
            wr.write(request.toString());
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
    public String[] get_request_display_info() {
        File dir = new File("requests");
        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith("request_") && name.endsWith(".txt");
            }
        });
        String [] results = new String[files.length];
    
        for (int i = 0; i < files.length; i++) {
            Scanner sc = null;
            try {
            sc = new Scanner(files[i]).useDelimiter("\t");
            String exam_name = sc.nextLine();
            String student = sc.nextLine();
            int question_no = sc.nextInt();
            sc.nextLine();
            String status = sc.nextLine();
            results[i] = String.format("%s\t%s\t%d\t%s", exam_name, student, question_no, status);
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
    
    public void open_request_file() {
        String filepath = String.format("requests/request_%d_%d_%d.txt", examID, studentID, regradeID);
        Scanner sc = null;
        try {
            File request_file = new File(filepath);
            sc = new Scanner(request_file).useDelimiter("\t");
            sc.nextLine();
            sc.nextLine();
            sc.nextLine();
            sc.nextLine();
            String request_text = sc.nextLine();
            String feedback = sc.nextLine();
            request = new Request(request_text, feedback);
        } catch (IOException e) {

        } finally {
            if (sc != null) {
            sc.close();
            }
        }
    }
}



