// sho 
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestViewerGUI extends JFrame {
    private JComboBox<ExamOption> examSelector;
    private JComboBox<RequestOption> requestSelector;
    private JButton selectExamBtn;
    private JButton requestSelectBtn;
    private ExamManager exManager;
    private AnswerManager ansManager;
    private RegradeManager reManager;

    public RequestViewerGUI() {
        setTitle("Requests Viewer GUI");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

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

        // Request Selection Components
        JLabel studentLabel = new JLabel("Select Request:");
        studentLabel.setBounds((getWidth() - componentWidth) / 2, panelVerticalOffset + 4 * verticalGap, componentWidth, componentHeight);
        add(studentLabel);

        requestSelector = new JComboBox<RequestOption>();
        requestSelector.setBounds((getWidth() - componentWidth) / 2, panelVerticalOffset + 5 * verticalGap, componentWidth, componentHeight);
        add(requestSelector);

        requestSelectBtn = new JButton("Select Request");

        selectExamBtn = new JButton("Select Exam");
        selectExamBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reManager = RegradeManager.get();
                reManager.setExamID(examSelector.getItemAt(examSelector.getSelectedIndex()).getID());
                requestSelector.removeAllItems();
                for (RequestOption a : reManager.get_request_display_info()) {
                    requestSelector.addItem(a);
                }
                requestSelector.setEnabled(true);
                requestSelectBtn.setEnabled(true);
            }
        });
        selectExamBtn.setBounds((getWidth() - componentWidth) / 2, panelVerticalOffset + 2 * verticalGap, componentWidth, componentHeight);
        add(selectExamBtn);

   
        requestSelectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentID = requestSelector.getItemAt(requestSelector.getSelectedIndex()).getStudentID();
                reManager.setRequestID(requestSelector.getItemAt(requestSelector.getSelectedIndex()).getRequestID());
                IDSetter.get().setStudentID(studentID);
                IDSetter.get().setExamID(examSelector.getItemAt(examSelector.getSelectedIndex()).getID());
                RegradeViewer frame = new RegradeViewer();
                frame.setVisible(true);
                dispose();
            }
        });
        requestSelectBtn.setBounds((getWidth() - componentWidth) / 2, panelVerticalOffset + 6 * verticalGap, componentWidth, componentHeight);
        add(requestSelectBtn);

        setLocationRelativeTo(null);
    }
}
