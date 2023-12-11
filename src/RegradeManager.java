import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class RegradeManager {
    private static RegradeManager instance = null;
    private int examID;
    private int studentID;
    private int requestID;
    
    private Request request;
    private static ArrayList<Integer> question_numbers;
  
    private RegradeManager() {
        question_numbers = new ArrayList<Integer>();
        Scanner sc = null;
        try {
            File f = new File("requestdata.bin");
            sc = new Scanner(f).useDelimiter("\t");
            while (sc.hasNext()) {
            question_numbers.add(sc.nextInt());
        }
        } catch (IOException e) {

        } finally {
            if (sc != null) {
                sc.close();
            }
        }
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

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }
  
    public void save(String request_text) {
        request = new Request(request_text, "");
    }
  
    public void regrade(String feedback) {
        request.setFeedback(feedback);
    }
  
    public void submit(int question_no, String status) {
        try {
            requestID = question_numbers.size();
            question_numbers.add(question_no);
            String filepath = String.format("answers/answer_%d_%d.txt", examID, studentID);
            FileWriter wr = new FileWriter(filepath);
            wr.write(String.format("%d\t%d\t%d\t%s\t", examID, studentID, requestID, status));
            wr.write(request.toString());
            wr.close();

            wr = new FileWriter("requestdata.bin", true);
            wr.write(String.format("%d\t", question_no));
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
            int exam = sc.nextInt();
            int student = sc.nextInt();
            int request = sc.nextInt();
            String status = sc.next();
            results[i] = String.format("%d\t%d\t%d\t%s", exam, student, request, status);
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
        String filepath = String.format("requests/request_%d_%d_%d.txt", examID, studentID, requestID);
        Scanner sc = null;
        try {
            File request_file = new File(filepath);
            sc = new Scanner(request_file).useDelimiter("\t");
            sc.next();
            sc.next();
            sc.next();
            sc.next();
            String request_text = sc.next();
            String feedback = sc.next();
            request = new Request(request_text, feedback);
        } catch (IOException e) {

        } finally {
            if (sc != null) {
            sc.close();
            }
        }
    }
}



