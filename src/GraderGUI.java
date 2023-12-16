import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Class represents the starting interface where a Grader choose to grade papers or view regrade requests. 
 */
public class GraderGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton gradePapersBtn;
    private JButton viewRegradeRequestsBtn;

    public GraderGUI() {
        setTitle("Grader GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 800)); // Set preferred size
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        int buttonWidth = 200;
        int buttonHeight = 50;
        
        gradePapersBtn = new JButton("Grade Papers");
        gradePapersBtn.setBounds((800 - buttonWidth) / 2, (800 - buttonHeight) / 2 - 50, buttonWidth, buttonHeight);
        contentPane.add(gradePapersBtn);

        gradePapersBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GraderSelectAnswerGUI frame = new GraderSelectAnswerGUI();
                frame.setVisible(true);
                dispose();
            }
        });

        viewRegradeRequestsBtn = new JButton("View Regrade Requests");
        viewRegradeRequestsBtn.setBounds((800 - buttonWidth) / 2, (800 - buttonHeight) / 2 + 50, buttonWidth, buttonHeight);
        contentPane.add(viewRegradeRequestsBtn);

        viewRegradeRequestsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectRequestGUI frame = new SelectRequestGUI();
                frame.setVisible(true);
                dispose();
            }
        });

        pack(); // Adjusts the frame size to fit the preferred size
        setLocationRelativeTo(null); // Center the frame on the screen
    }
}
