import java.io.*;
import java.util.ArrayList;

public class RegradeManager {
  private static int requestcount;

  //String[] questions
  //String[] answers
  //String[] grades

  private static ArrayList<String> filepaths;

  public RegradeManager(){
  }

  public static void save(String requestText, int examID, int studentID, int question_no) {
    int requestid = request_count;
    request_count++;
    // String path =  source +studentId_examID_requestID
    // store question number + requestInfo in 
    //file write
  }

  public static void get_requests_display_info() {
    // parse the filepaths, return formated string array examid, studentid, question_no, status
    
  }
  // source+studentId_examID_question_no
  public static void open_request_file(int examID, int studentID, int request_id) {
    //return content of file - requestInfo
    // filepath = filepaths.get(examID, studentID, requestID);
    requestText = "info from file";
  }

}