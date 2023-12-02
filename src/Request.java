public class Request {
    private int studentID;
    private int examID;
    private int questionNum;
    private String requestText;


    Request(){

    }
    Request(int studentID, int examID, int questionNum, String requestText){
        this.studentID = studentID;
        this.examID = examID;
        this.questionNum = questionNum;
        this.requestText = requestText;
    }

    public int getStudentID(){
        return this.studentID;
    }

    public void setStudentID(int id){
        this.studentID = id;
        
    }

    public int getExamsID(){
        return this.examID;
    }
    
    public void setExamsID(int id){
        this.examID = id;
    }

    public int getQuestionNum(){
        return this.questionNum;
    }
        
    public void setQuestionNum(int num){
        this.questionNum = num;
    }
        
    public String getRequestText(){
        return this.requestText; 
    }
    
    public void setRequestText(String requestText) {
        this.requestText = requestText;
    }

}
