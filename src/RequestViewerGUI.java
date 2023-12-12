import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class RequestViewerGUI extends JFrame {
    private JComboBox<String> examSelector;
    private JComboBox<String> studentSelector;
    private JButton selectExamBtn;
    private JButton selectStudentBtn;

    private Map<String, List<String>> examStudentsMap;

    public RequestViewerGUI() {
        setTitle("Request Viewer GUI");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        examStudentsMap = new HashMap<>();
        examStudentsMap.put("Exam 1", Arrays.asList("Student 1, Requested", "Student 2, Approved", "Student 3, Rejected"));
        examStudentsMap.put("Exam 2", Arrays.asList("Student 4, Rejected", "Student 5, Requested", "Student 6, Requested"));

        int componentWidth = 220;
        int componentHeight = 40;
        int verticalGap = 50;
        int panelVerticalOffset = 150;

        // Exam Selection Components
        JLabel examLabel = new JLabel("Select Exam:");
        examLabel.setBounds((getWidth() - componentWidth) / 2, panelVerticalOffset, componentWidth, componentHeight);
        add(examLabel);

        examSelector = new JComboBox<>();
        examSelector.addItem("Exam 1");
        examSelector.addItem("Exam 2");
        examSelector.setBounds((getWidth() - componentWidth) / 2, panelVerticalOffset + verticalGap, componentWidth, componentHeight);
        add(examSelector);

        selectExamBtn = new JButton("Select Exam");
        selectExamBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedExam = (String) examSelector.getSelectedItem();
                System.out.println("Selected Exam: " + selectedExam);

                List<String> students = examStudentsMap.get(selectedExam);
                if (students != null) {
                    studentSelector.removeAllItems();
                    for (String student : students) {
                        studentSelector.addItem(student);
                    }
                }

                examSelector.setEnabled(false);
                selectExamBtn.setEnabled(false);
                studentSelector.setEnabled(true);
                selectStudentBtn.setEnabled(true);
            }
        });
        selectExamBtn.setBounds((getWidth() - componentWidth) / 2, panelVerticalOffset + 2 * verticalGap, componentWidth, componentHeight);
        add(selectExamBtn);

        // Student Selection Components
        JLabel studentLabel = new JLabel("Select Student:");
        studentLabel.setBounds((getWidth() - componentWidth) / 2, panelVerticalOffset + 4 * verticalGap, componentWidth, componentHeight);
        add(studentLabel);

        studentSelector = new JComboBox<>();
        studentSelector.setEnabled(false);
        studentSelector.setBounds((getWidth() - componentWidth) / 2, panelVerticalOffset + 5 * verticalGap, componentWidth, componentHeight);
        add(studentSelector);

        selectStudentBtn = new JButton("Select Student");
        selectStudentBtn.setEnabled(false);
        selectStudentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedStudent = (String) studentSelector.getSelectedItem();
                System.out.println("Selected Student: " + selectedStudent);

                examSelector.setEnabled(true);
                selectExamBtn.setEnabled(true);
                studentSelector.setEnabled(false);
                selectStudentBtn.setEnabled(false);
                // how do I get the request ID => requestID
                RegradeViewer frame = new RegradeViewer(selectedStudent);
                frame.setVisible(true);
                setVisible(false);
            }
        });
        selectStudentBtn.setBounds((getWidth() - componentWidth) / 2, panelVerticalOffset + 6 * verticalGap, componentWidth, componentHeight);
        add(selectStudentBtn);

        setLocationRelativeTo(null);
    }
}
