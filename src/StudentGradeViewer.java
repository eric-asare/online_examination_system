import javax.swing.*;
import java.awt.*;

public class StudentGradeViewer extends JFrame {

    private String[] studentExams = {"Exam 1", "Exam 2", "Exam 3"}; // Placeholder list of exams for a student
    String studentID;

    public StudentGradeViewer(String studentID) {
        this.studentID = studentID;
        setTitle("Student Grade Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        createExamList();
    }

    private void createExamList() {
        JList<String> examList = new JList<>(studentExams);
        examList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        examList.setLayoutOrientation(JList.VERTICAL);

        JScrollPane listScrollPane = new JScrollPane(examList);
        listScrollPane.setPreferredSize(new Dimension(250, 300));

        examList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedExam = examList.getSelectedValue();
                openStudentAnswersViewer(selectedExam);
            }
        });

        add(listScrollPane);
    }

    private void openStudentAnswersViewer(String selectedExam) {
        StudentAnswersViewer studentAnswersViewer = new StudentAnswersViewer(selectedExam);
        studentAnswersViewer.setVisible(true);
    }
}

