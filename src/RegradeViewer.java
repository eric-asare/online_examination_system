import javax.swing.*;

public class RegradeViewer extends JFrame {
    private String requestID;
    private JLabel studentIDLabel, questionNumberLabel, questionTextLabel, answerLabel, studentAnswerLabel, scoreLabel, teacherFeedbackLabel, fullScoreLabel;
    private JTextArea answerTextArea, studentAnswerTextArea, scoreField, teacherFeedbackTextArea, studentRequestTextArea, studentScoreText;
    private JTextArea questionTextArea;
    private JButton prevButton, nextButton, submitRegradesButton;
    private JLabel studentIDValueLabel, questionNumberValueLabel;

    public RegradeViewer(String requestID) {
        this.requestID = requestID;

        setTitle("Regrade Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 900);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Student ID Label and Value
        studentIDLabel = new JLabel("Student ID:");
        studentIDLabel.setBounds(50, 20, 100, 25);
        panel.add(studentIDLabel);

        studentIDValueLabel = new JLabel("S1234567"); // Placeholder value
        studentIDValueLabel.setBounds(160, 20, 100, 25);
        panel.add(studentIDValueLabel);

        // Question Number Label and Value
        questionNumberLabel = new JLabel("Question Number:");
        questionNumberLabel.setBounds(400, 20, 120, 25);
        panel.add(questionNumberLabel);

        questionNumberValueLabel = new JLabel("1"); // Placeholder value
        questionNumberValueLabel.setBounds(600, 20, 50, 25);
        panel.add(questionNumberValueLabel);

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

        studentScoreText= new JTextArea();
        studentScoreText.setBounds(250, 430, 100, 25);
        panel.add(studentScoreText);

        
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
        teacherFeedbackLabel = new JLabel("Teacher Feedback:");
        teacherFeedbackLabel.setBounds(50, 650, 150, 25);
        panel.add(teacherFeedbackLabel);

        teacherFeedbackTextArea = new JTextArea();
        JScrollPane teacherFeedbackScrollPane = new JScrollPane(teacherFeedbackTextArea);
        teacherFeedbackScrollPane.setBounds(50, 680, 500, 100);
        panel.add(teacherFeedbackScrollPane);

        // Buttons: Prev, Next, Submit Regrades
        prevButton = new JButton("Prev");
        prevButton.setBounds(50, 800, 80, 30);
        panel.add(prevButton);

        nextButton = new JButton("Next");
        nextButton.setBounds(150, 800, 80, 30);
        panel.add(nextButton);

        submitRegradesButton = new JButton("Submit Regrades");
        submitRegradesButton.setBounds(250, 800, 150, 30);
        panel.add(submitRegradesButton);

        add(panel);
        setVisible(true);
    }
}
