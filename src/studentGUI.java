import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class StudentGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public StudentGUI() {
		setTitle("Online Examination System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton takeExamBtn = new JButton("Take Exam");
		takeExamBtn.setBounds(157, 94, 117, 29);
		contentPane.add(takeExamBtn);
		
		takeExamBtn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	System.out.println("clicked");
		    	setVisible(false);
		        ExamsGUI frame = new ExamsGUI(0);
		        frame.setVisible(true);
		    }
		});
		
		JButton viewGradesBtn = new JButton("View Grades");
		viewGradesBtn.setBounds(157, 150, 117, 29);
		contentPane.add(viewGradesBtn);
	}
}
