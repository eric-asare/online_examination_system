import javax.swing.*;
import java.awt.event.*;

/**
 * This class represents the interface where a Grader views the student submitted request. 
 */
public class ViewRequestGUI extends JFrame {
    private JLabel questionNumberLabel, questionTextLabel, answerLabel, studentAnswerLabel, scoreLabel, teacherFeedbackLabel, fullScoreLabel;
    private JTextArea answerTextArea, studentAnswerTextArea, scoreField, teacherFeedbackTextArea, studentRequestTextArea, studentScoreField;
    private JTextArea questionTextArea;
    private JButton rejectRequest, submitButton;
    private ExamManager exManager;
    private AnswerManager ansManager;
    private RegradeManager reManager;
    private int question_no;


    public ViewRequestGUI() {
        setTitle("View Request GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 900);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Question Number Label and Value
        questionNumberLabel = new JLabel("Question Number:");
        questionNumberLabel.setBounds(400, 20, 120, 25);
        panel.add(questionNumberLabel);

        // Question Text Area (Non-Editable)
        questionTextLabel = new JLabel("Question Text:");
        questionTextLabel.setBounds(50, 50, 120, 25);
        panel.add(questionTextLabel);

        questionTextArea = new JTextArea();
        questionTextArea.setEditable(false);
        JScrollPane questionScrollPane = new JScrollPane(questionTextArea);
        questionScrollPane.setBounds(50, 100, 500, 100);
        panel.add(questionScrollPane);

        // Answer Label and Text Area
        answerLabel = new JLabel("Answer:");
        answerLabel.setBounds(50, 200, 80, 25);
        panel.add(answerLabel);

        answerTextArea = new JTextArea();
        answerTextArea.setEditable(false);
        JScrollPane answerScrollPane = new JScrollPane(answerTextArea);
        answerScrollPane.setBounds(50, 230, 500, 50);
        panel.add(answerScrollPane);

        // Student Answer Label and Text Area
        studentAnswerLabel = new JLabel("Student Answer:");
        studentAnswerLabel.setBounds(50, 290, 120, 25);
        panel.add(studentAnswerLabel);

        studentAnswerTextArea = new JTextArea();
        studentAnswerTextArea.setEditable(false);
        JScrollPane studentAnswerScrollPane = new JScrollPane(studentAnswerTextArea);
        studentAnswerScrollPane.setBounds(50, 315, 500, 50);
        panel.add(studentAnswerScrollPane);

        // Full Score Label and Text Area
        fullScoreLabel = new JLabel("Full Score:");
        fullScoreLabel.setBounds(50, 400, 80, 25);
        panel.add(fullScoreLabel);

        scoreField = new JTextArea();
        scoreField.setEditable(false);
        scoreField.setBounds(50, 430, 100, 25);
        panel.add(scoreField);


        // Full Score Label and Text Area
        scoreLabel = new JLabel("Student Score:");
        scoreLabel.setBounds(250, 400, 100, 25);
        panel.add(scoreLabel);

        studentScoreField= new JTextArea();
        studentScoreField.setBounds(250, 430, 100, 25);
        panel.add(studentScoreField);

        
        // Student Request Label and Text Area
        JLabel studentRequestLabel = new JLabel("Student Request:");
        studentRequestLabel.setBounds(50, 500, 120, 25);
        panel.add(studentRequestLabel);

        studentRequestTextArea = new JTextArea();
        studentRequestTextArea.setEditable(false);
        JScrollPane studentRequestScrollPane = new JScrollPane(studentRequestTextArea);
        studentRequestScrollPane.setBounds(50, 530, 500, 100);
        panel.add(studentRequestScrollPane);

        // Teacher Feedback Label and Text Area
        teacherFeedbackLabel = new JLabel("Grader Feedback:");
        teacherFeedbackLabel.setBounds(50, 650, 150, 25);
        panel.add(teacherFeedbackLabel);

        teacherFeedbackTextArea = new JTextArea();
        JScrollPane teacherFeedbackScrollPane = new JScrollPane(teacherFeedbackTextArea);
        teacherFeedbackScrollPane.setBounds(50, 680, 500, 100);
        panel.add(teacherFeedbackScrollPane);

        // Buttons: Submit Regrades

        rejectRequest = new JButton("Reject Request");
        rejectRequest.setBounds(150, 800, 150, 30);
        panel.add(rejectRequest);

        submitButton = new JButton("Submit Regrade");
        submitButton.setBounds(300, 800, 150, 30);
        panel.add(submitButton);

        add(panel);
        exManager = ExamManager.get();
        reManager = RegradeManager.get();
        exManager.open_exam_file();
        ansManager = AnswerManager.get();
        ansManager.open_answers_file();
        reManager.open_request_file();
      
        question_no = reManager.getNum(reManager.getRequestID());
        loadQuestion(question_no);



        submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                try {
                    save();
                    ansManager.submit("Graded");
                    reManager.submit(question_no, "Regraded");
                    LoginGUI l = new LoginGUI();
                    l.setVisible(true);
                    dispose();
                } catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Grade must be a positive integer");
				}
		
			}
		});

        rejectRequest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                reManager.submit(question_no, "Rejected");
                LoginGUI l = new LoginGUI();
                l.setVisible(true);
                dispose();
			}
		});
    }

    private void loadQuestion(int question_no) {
		Question q = exManager.getQuestion(question_no);
        Answer a = ansManager.getAnswer(question_no);

        questionNumberLabel.setText(String.format("Question %d", question_no));
		questionTextArea.setText(q.getQuestion());
        answerTextArea.setText(q.getAnswer());

        studentAnswerTextArea.setText(a.getAns());
		scoreField.setText(Integer.toString(q.getWeight()));
        teacherFeedbackTextArea.setText(a.getFeedback());
        studentRequestTextArea.setText(reManager.getRequest());
        if (a.getGrade() != -1)
            studentScoreField.setText(Integer.toString(a.getGrade()));
        else
            studentScoreField.setText("Ungraded");

	}


    private void save() throws NumberFormatException {
        int g = Integer.parseInt(studentScoreField.getText());
        if (g<0 || g>exManager.getQuestion(question_no).getWeight())
            throw new NumberFormatException();
        ansManager.grade(teacherFeedbackTextArea.getText(), g, question_no); 
    }

}
