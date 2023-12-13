import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class RegradeManager {
    private static RegradeManager instance = null;
    private int examID;
    private String studentID;
    private int requestID;
    
    private String request;
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

    public int getNum(int requestID) {
        return question_numbers.get(requestID);
    }
  
    public void setExamID(int examID) {
        this.examID = examID;
    }
  
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public int getRequestID() {
        return requestID;
    }

    public String getRequest() {
        return request;
    }
  
    public void save(String request_text) {
        request = request_text;
    }

    public void submit(int question_no, String status) {
        try {
            if (status == "Unresolved") {
                requestID = question_numbers.size();
                question_numbers.add(question_no);
            }
            String filepath = String.format("requests/request_%d_%s_%d.txt", examID, studentID, requestID);
            FileWriter wr = new FileWriter(filepath);
            wr.write(String.format("%s\t%d\t%s\t", studentID, requestID, status));
            wr.write(request);
            wr.close();

            wr = new FileWriter("requestdata.bin", true);
            wr.write(String.format("%d\t", question_no));
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
    public RequestOption[] get_request_display_info() {
        File dir = new File("requests");
        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith(String.format("request_%d", examID)) && name.endsWith(".txt");
            }
        });
        RequestOption[] results = new RequestOption[files.length];
    
        for (int i = 0; i < files.length; i++) {
            Scanner sc = null;
            try {
                sc = new Scanner(files[i]).useDelimiter("\t");
                String student = sc.next();
                int request = sc.nextInt();
                String status = sc.next();
                results[i] = new RequestOption(student, request, status);
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
    
    public void open_request_file() {
        String filepath = String.format("requests/request_%d_%s_%d.txt", examID, studentID, requestID);
        Scanner sc = null;
        try {
            File request_file = new File(filepath);
            sc = new Scanner(request_file).useDelimiter("\t");
            sc.next();
            sc.next();
            sc.next();
            request = sc.next();
        } catch (IOException e) {

        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}



