import javax.swing.*;
import java.awt.*;
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

        setLayout(new GridBagLayout());

        writeExamsButton = new JButton("Write Exams");
        gradePapersButton = new JButton("Grade Papers");
        viewRegradeRequestsButton = new JButton("View Regrade Requests");

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
            }
        });

        viewRegradeRequestsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello, my name is View Regrade Requests button");
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 5, 0); // Space between buttons
        gbc.anchor = GridBagConstraints.CENTER;

        add(writeExamsButton, gbc);

        gbc.gridy++;
        add(gradePapersButton, gbc);

        gbc.gridy++;
        add(viewRegradeRequestsButton, gbc);

        setLocationRelativeTo(null);
    }
}
