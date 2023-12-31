import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * The class represents the interface where students select the answered exam they have submitted in order to view their grades
 */
public class StudentSelectAnswerGUI extends JFrame {
    private String studentID;
    private JList<ExamOption> examList;
    private ExamManager exManager;

    public StudentSelectAnswerGUI() {
        setTitle("Student Select Answer GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        studentID = AnswerManager.get().getStudentID();

        exManager = ExamManager.get();
        examList = new JList<ExamOption>(exManager.get_exams_display_info());
        examList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        examList.setLayoutOrientation(JList.VERTICAL);

        JScrollPane listScrollPane = new JScrollPane(examList);
        listScrollPane.setPreferredSize(new Dimension(250, 300));

        examList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedExam = examList.getSelectedValue().getID();
		File f = new File(String.format("answers/answer_%d_%s.txt", selectedExam, studentID));
		if (f.exists()) {
			IDSetter.get().setExamID(selectedExam);
                    	StudentViewAnswerGUI studentAnswersViewer = new StudentViewAnswerGUI();
                    	studentAnswersViewer.setVisible(true);
                    	dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Haven't Taken Exam");
		}
            }
        });

        add(listScrollPane);
    }
}

