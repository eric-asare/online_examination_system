import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                System.out.println("Hello, my name is Write Exams button");  
                ExamWriteGUI examWriterFrame = new ExamWriteGUI();
                examWriterFrame.setVisible(true);
                setVisible(false);
            }
        });

        gradePapersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello, my name is Grade Papers button");
                // Add your logic for Grade Papers button
            }
        });

        viewRegradeRequestsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello, my name is View Regrade Requests button");
                // Add your logic for View Regrade Requests button
            }
        });

        add(writeExamsButton);
        add(gradePapersButton);
        add(viewRegradeRequestsButton);

        setLocationRelativeTo(null);
    }
}
