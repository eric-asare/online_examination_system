import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represent the interface for Teacher to select where to write an exam,
 *  grade student papers or view regrade requests. 
 */
class TeacherGUI extends JFrame {
    private JButton writeExamsButton;
    private JButton gradePapersButton;
    private JButton viewRegradeRequestsButton;

    // Constructor
    TeacherGUI() {
        setTitle("Teacher GUI");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Set default close operation

        setLayout(null); // Setting layout to null

        int buttonWidth = 200;
        int buttonHeight = 50;

        writeExamsButton = new JButton("Write Exams");
        gradePapersButton = new JButton("Grade Papers");
        viewRegradeRequestsButton = new JButton("View Regrade Requests");

        writeExamsButton.setBounds((800 - buttonWidth) / 2, (800 - buttonHeight) / 2 - 50, buttonWidth, buttonHeight);
        gradePapersButton.setBounds((800 - buttonWidth) / 2, (800 - buttonHeight) / 2 + 20, buttonWidth, buttonHeight);
        viewRegradeRequestsButton.setBounds((800 - buttonWidth) / 2, (800 - buttonHeight) / 2 + 90, buttonWidth, buttonHeight);

        writeExamsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                WriteExamGUI examWriterFrame = new WriteExamGUI();
                examWriterFrame.setVisible(true);
                dispose();
            }
        });

        gradePapersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GraderSelectAnswerGUI frame = new GraderSelectAnswerGUI();
                frame.setVisible(true);
                dispose();
            }
        });

        viewRegradeRequestsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectRequestGUI frame = new SelectRequestGUI();
                frame.setVisible(true);
                dispose();
            }
        });

        add(writeExamsButton);
        add(gradePapersButton);
        add(viewRegradeRequestsButton);

        setLocationRelativeTo(null);
    }
}
