import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentAnswersViewer extends JFrame {
    private String selectedExam;
    private JLabel studentIDLabel, questionNumberLabel, questionTextLabel, answerLabel, studentAnswerLabel, scoreLabel,  requestRegradeLabel, fullScoreLabel, totalScoreLabel;
    private JTextArea answerTextArea, studentAnswerTextArea, scoreField, studentScoreField, totalScoreField;
    private JTextArea questionTextArea, requestRegradeTextArea;
    private JButton prevButton, nextButton, requestRegradeButton;
    private JLabel studentIDValueLabel, questionNumberValueLabel;

    public StudentAnswersViewer(String selectedExam) {
        this.selectedExam = selectedExam;

        setTitle("Student Answers Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
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
        questionNumberLabel.setBounds(50, 60, 120, 25);
        panel.add(questionNumberLabel);

        questionNumberValueLabel = new JLabel("1"); // Placeholder value
        questionNumberValueLabel.setBounds(180, 60, 50, 25);
        panel.add(questionNumberValueLabel);

        // Question Text Area (Non-Editable)
        questionTextLabel = new JLabel("Question Text:");
        questionTextLabel.setBounds(50, 100, 120, 25);
        panel.add(questionTextLabel);

        questionTextArea = new JTextArea();
        questionTextArea.setEditable(false);
        JScrollPane questionScrollPane = new JScrollPane(questionTextArea);
        questionScrollPane.setBounds(50, 130, 500, 100);
        panel.add(questionScrollPane);

        // Answer Label and Text Area
        answerLabel = new JLabel("Answer:");
        answerLabel.setBounds(50, 250, 80, 25);
        panel.add(answerLabel);

        answerTextArea = new JTextArea();
        answerTextArea.setEditable(false);
        JScrollPane answerScrollPane = new JScrollPane(answerTextArea);
        answerScrollPane.setBounds(50, 280, 500, 50);
        panel.add(answerScrollPane);

        // Student Answer Label and Text Area
        studentAnswerLabel = new JLabel("Your Answer:");
        studentAnswerLabel.setBounds(50, 340, 120, 25);
        panel.add(studentAnswerLabel);

        studentAnswerTextArea = new JTextArea();
        studentAnswerTextArea.setEditable(false);
        JScrollPane studentAnswerScrollPane = new JScrollPane(studentAnswerTextArea);
        studentAnswerScrollPane.setBounds(50, 370, 500, 50);
        panel.add(studentAnswerScrollPane);

        // Full Score Label and Text Area
        fullScoreLabel = new JLabel("Full Score:");
        fullScoreLabel.setBounds(50, 430, 80, 25);
        panel.add(fullScoreLabel);

        scoreField = new JTextArea();
        scoreField.setEditable(false);
        scoreField.setBounds(50, 460, 100, 25);
        panel.add(scoreField);

        // Student Score Label and Text Area
        scoreLabel = new JLabel("Your Score:");
        scoreLabel.setBounds(50, 500, 120, 25);
        panel.add(scoreLabel);

        studentScoreField = new JTextArea();
        studentScoreField.setBounds(50, 530, 100, 25);
        studentScoreField.setEditable(false);
        panel.add(studentScoreField);


        // Student Score Label and Text Area
        totalScoreLabel = new JLabel("Total Score:");
        totalScoreLabel.setBounds(600, 60, 120, 25);
        panel.add(totalScoreLabel);
    
        totalScoreField = new JTextArea();
        totalScoreField.setBounds(700, 60, 80, 25);
        totalScoreField.setEditable(false);
        panel.add(totalScoreField);

        // Buttons: Prev, Next, Request Regrade
        prevButton = new JButton("Prev");
        prevButton.setBounds(50, 720, 80, 30);
        panel.add(prevButton);

        nextButton = new JButton("Next");
        nextButton.setBounds(150, 720, 80, 30);
        panel.add(nextButton);


        requestRegradeLabel = new JLabel("Request Regrade:");
        requestRegradeLabel.setBounds(50, 570, 120, 25);
        panel.add(requestRegradeLabel);

        requestRegradeTextArea = new JTextArea();
        JScrollPane requestRegradeScrollPane = new JScrollPane(requestRegradeTextArea);
        requestRegradeScrollPane.setBounds(50, 600, 500, 100);
        panel.add(requestRegradeScrollPane);

        // Submit All Grades button changed to Request Regrade
        requestRegradeButton = new JButton("Request Regrade");
        requestRegradeButton.setBounds(250, 720, 150, 30);
        panel.add(requestRegradeButton);

        add(panel);


          // Action Listeners for Prev and Next buttons
        prevButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Implement logic for handling previous question
            System.out.println("Previous button clicked");
        }
         });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic for handling next question
                System.out.println("Next button clicked");
            }
        });

        // Action Listener for Request Regrade button
        requestRegradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic for handling request regrade
                System.out.println("Request Regrade button clicked");
            }
        });
    }

}