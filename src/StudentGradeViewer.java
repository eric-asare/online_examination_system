import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeViewer extends JFrame {
    private JTextArea gradedAnswersTextArea;

    public StudentGradeViewer() {
        setTitle("Student Grade Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLayout(new BorderLayout());

        gradedAnswersTextArea = new JTextArea();
        gradedAnswersTextArea.setEditable(false);
        gradedAnswersTextArea.setLineWrap(true); // Enable line wrap for long text
        JScrollPane scrollPane = new JScrollPane(gradedAnswersTextArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton viewGradesButton = new JButton("View Grades");
        viewGradesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Replace this with code to open the student's graded answer file
                // For demonstration, let's assume the graded answers are loaded into a string
                String gradedAnswers = loadGradedAnswersFromFile(); // Replace this with actual file loading logic
                gradedAnswersTextArea.setText(gradedAnswers);
            }
        });
        add(viewGradesButton, BorderLayout.NORTH);

        JButton requestRegradeButton = new JButton("Request Regrade");
        requestRegradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected text range
                int start = gradedAnswersTextArea.getSelectionStart();
                int end = gradedAnswersTextArea.getSelectionEnd();

                if (start != -1 && end != -1) {
                    String selectedText = gradedAnswersTextArea.getText().substring(start, end);
                    if (!selectedText.isEmpty()) {
                        // Code to handle the regrade request for the selected question
                        requestRegrade(selectedText); // Replace this with your regrade logic
                        JOptionPane.showMessageDialog(StudentGradeViewer.this, "Regrade requested for the selected question.");
                    } else {
                        JOptionPane.showMessageDialog(StudentGradeViewer.this, "Please select a question to request a regrade.");
                    }
                } else {
                    JOptionPane.showMessageDialog(StudentGradeViewer.this, "Please select a question to request a regrade.");
                }
            }
        });
        add(requestRegradeButton, BorderLayout.SOUTH);
    }

    // Method to simulate loading graded answers from a file
    private String loadGradedAnswersFromFile() {
        // Replace this with actual file loading logic
        // For demonstration purposes, returning sample graded answers
        return "Question 1: Grade - A\nAnswer: ...\n\nQuestion 2: Grade - B\nAnswer: ...";
    }

    // Method to handle the regrade request for a specific question
    private void requestRegrade(String selectedQuestion) {
        // Replace this with your regrade logic for the selected question
        // For example, you might submit a regrade request to an instructor or system
        // Here, you could add code to handle the regrade request process
        System.out.println("Regrade requested for: " + selectedQuestion);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentGradeViewer gradeViewer = new StudentGradeViewer();
            gradeViewer.setVisible(true);
        });
    }
}
