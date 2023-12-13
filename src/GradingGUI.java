import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradingGUI extends JFrame {
    private JLabel questionNumberLabel, questionTextLabel, answerLabel, studentAnswerLabel, scoreLabel, feedbackLabel, fullScoreLabel;
    private JTextArea answerTextArea, studentAnswerTextArea, scoreField, studentScoreField;
    private JTextArea questionTextArea, feedbackTextArea;
    private JButton prevButton, nextButton, submitButton;
    private ExamManager exManager;
    private AnswerManager ansManager;
    private int question_no;
 

    public GradingGUI() {
        setTitle("Grading GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Question Number Label and Value
        questionNumberLabel = new JLabel("Question Number:");
        questionNumberLabel.setBounds(50, 60, 120, 25);
        panel.add(questionNumberLabel);

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
        studentAnswerLabel = new JLabel("Student Answer:");
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
        scoreLabel = new JLabel("Student Score:");
        scoreLabel.setBounds(50, 500, 120, 25);
        panel.add(scoreLabel);

        studentScoreField = new JTextArea();
        studentScoreField.setBounds(50, 530, 100, 25);
        panel.add(studentScoreField);

        // Feedback Label and Text Area
        feedbackLabel = new JLabel("Feedback:");
        feedbackLabel.setBounds(50, 570, 80, 25);
        panel.add(feedbackLabel);

        feedbackTextArea = new JTextArea();
        JScrollPane feedbackScrollPane = new JScrollPane(feedbackTextArea);
        feedbackScrollPane.setBounds(50, 600, 500, 100);
        panel.add(feedbackScrollPane);

        // Buttons: Prev, Next, Submit
        prevButton = new JButton("Prev");
        prevButton.setBounds(50, 720, 80, 30);
        panel.add(prevButton);

        nextButton = new JButton("Next");
        nextButton.setBounds(150, 720, 80, 30);
        panel.add(nextButton);

        submitButton = new JButton("Submit All Grades");
        submitButton.setBounds(250, 720, 150, 30);
        panel.add(submitButton);

        add(panel);

        exManager = ExamManager.get();
        exManager.open_exam_file();
        ansManager = AnswerManager.get();
        ansManager.open_answers_file();
        question_no = 1;
        loadQuestion(question_no);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (question_no != exManager.getLength()) {
                        save();
                        loadQuestion(++question_no);
                    }
                } catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Grade must be a positive integer");
				}
            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (question_no != 1) {
                        save();
                        loadQuestion(--question_no);
                    }
                } catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Grade must be a positive integer");
				}
            }
        });

		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                try {
                    save();
                    ansManager.submit("Graded");
                    LoginGUI l = new LoginGUI();
                    l.setVisible(true);
                    dispose();
                } catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Grade must be a positive integer");
				}
		
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
        feedbackTextArea.setText(a.getFeedback());
        if (a.getGrade() != -1)
            studentScoreField.setText(Integer.toString(a.getGrade()));
        else
            studentScoreField.setText("Ungraded");

	}

    private void save() throws NumberFormatException {
        int g = Integer.parseInt(studentScoreField.getText());
        if (g<0 || g>exManager.getQuestion(question_no).getWeight())
            throw new NumberFormatException();
        ansManager.grade(feedbackTextArea.getText(), g, question_no); 
    }
}
