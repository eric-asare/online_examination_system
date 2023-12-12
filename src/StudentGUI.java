import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder; // Import the EmptyBorder class

public class StudentGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public StudentGUI(String studentID) {
        setTitle("Student GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton takeExamBtn = new JButton("Take Exam");
        takeExamBtn.setBounds((getWidth() - 117) / 2, (getHeight() - 40) / 2 - 50, 117, 40);
        contentPane.add(takeExamBtn);

        takeExamBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");
                setVisible(false);
                // Assuming ExamsGUI is your frame for taking exams
                ExamsGUI frame = new ExamsGUI(studentID);
                frame.setVisible(true);
                setVisible(false);
            }
        });

        JButton viewGradesBtn = new JButton("View Grades");
        viewGradesBtn.setBounds((getWidth() - 117) / 2, (getHeight() - 40) / 2 + 50, 117, 40);
        contentPane.add(viewGradesBtn);


		viewGradesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");
                setVisible(false);
                StudentGradeViewer frame = new StudentGradeViewer(studentID);
                frame.setVisible(true);
                setVisible(false);
            }
        });
    }
}
