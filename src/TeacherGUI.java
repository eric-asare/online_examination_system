import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represent the interface for Teacher to select where to write an exam,
 *  grade student papers or view regrade requests. 
 */
class TeacherGUI extends JFrame {
    private JButton writeExamsBtn;
    private JButton gradePapersBtn;
    private JButton viewRegradeRequestsBtn;

    // Constructor
    TeacherGUI() {
        setTitle("Teacher GUI");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Set default close operation

        setLayout(null); // Setting layout to null

        int buttonWidth = 200;
        int buttonHeight = 50;

        writeExamsBtn = new JButton("Write Exams");
        gradePapersBtn = new JButton("Grade Papers");
        viewRegradeRequestsBtn = new JButton("View Regrade Requests");

        writeExamsBtn.setBounds((800 - buttonWidth) / 2, (800 - buttonHeight) / 2 - 50, buttonWidth, buttonHeight);
        gradePapersBtn.setBounds((800 - buttonWidth) / 2, (800 - buttonHeight) / 2 + 20, buttonWidth, buttonHeight);
        viewRegradeRequestsBtn.setBounds((800 - buttonWidth) / 2, (800 - buttonHeight) / 2 + 90, buttonWidth, buttonHeight);

        writeExamsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                WriteExamGUI examWriterFrame = new WriteExamGUI();
                examWriterFrame.setVisible(true);
                dispose();
            }
        });

        gradePapersBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GraderSelectAnswerGUI frame = new GraderSelectAnswerGUI();
                frame.setVisible(true);
                dispose();
            }
        });

        viewRegradeRequestsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectRequestGUI frame = new SelectRequestGUI();
                frame.setVisible(true);
                dispose();
            }
        });

        add(writeExamsBtn);
        add(gradePapersBtn);
        add(viewRegradeRequestsBtn);

        setLocationRelativeTo(null);
    }
}
