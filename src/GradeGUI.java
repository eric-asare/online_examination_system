import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeGUI extends JFrame {
    private JComboBox<ExamOption> examSelector;
    private JComboBox<AnswerOption> studentSelector;
    private JButton selectExamBtn;
    private JButton selectStudentBtn;
    private ExamManager exManager;
    private AnswerManager ansManager;

    public GradeGUI() {
        setTitle("Grade Papers GUI");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        
        ansManager = AnswerManager.get();

        int componentWidth = 220;
        int componentHeight = 40;
        int verticalGap = 50;
        int panelVerticalOffset = 150; // To create some space at the top

        // Exam Selection Components
        JLabel examLabel = new JLabel("Select Exam:");
        examLabel.setBounds((getWidth() - componentWidth) / 2, panelVerticalOffset, componentWidth, componentHeight);
        add(examLabel);

        exManager = ExamManager.get();

        examSelector = new JComboBox<ExamOption>(exManager.get_exams_display_info());

        examSelector.setBounds((getWidth() - componentWidth) / 2, panelVerticalOffset + verticalGap, componentWidth, componentHeight);
        add(examSelector);

        // Student Selection Components
        JLabel studentLabel = new JLabel("Select Student:");
        studentLabel.setBounds((getWidth() - componentWidth) / 2, panelVerticalOffset + 4 * verticalGap, componentWidth, componentHeight);
        add(studentLabel);

        studentSelector = new JComboBox<AnswerOption>();
        studentSelector.setBounds((getWidth() - componentWidth) / 2, panelVerticalOffset + 5 * verticalGap, componentWidth, componentHeight);
        add(studentSelector);

        selectStudentBtn = new JButton("Select Student");

        selectExamBtn = new JButton("Select Exam");
        selectExamBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                IDSetter.get().setExamID(examSelector.getItemAt(examSelector.getSelectedIndex()).getID());
                studentSelector.removeAllItems();
                for (AnswerOption a : ansManager.get_answers_display_info()) {
                    studentSelector.addItem(a);
                }
                studentSelector.setEnabled(true);
                selectStudentBtn.setEnabled(true);
            }
        });
        selectExamBtn.setBounds((getWidth() - componentWidth) / 2, panelVerticalOffset + 2 * verticalGap, componentWidth, componentHeight);
        add(selectExamBtn);

   
        selectStudentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentID = studentSelector.getItemAt(studentSelector.getSelectedIndex()).getID();
		        IDSetter.get().setStudentID(studentID);
                GradingGUI frame = new GradingGUI();
                frame.setVisible(true);
                dispose();


            }
        });
        selectStudentBtn.setBounds((getWidth() - componentWidth) / 2, panelVerticalOffset + 6 * verticalGap, componentWidth, componentHeight);
        add(selectStudentBtn);

        setLocationRelativeTo(null);
    }
}
