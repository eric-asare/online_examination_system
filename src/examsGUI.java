import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class examsGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public examsGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(68, 41, 306, 90);
		contentPane.add(textArea);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(56, 175, 141, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(56, 204, 141, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton radioButton = new JRadioButton("New radio button");
		radioButton.setBounds(209, 175, 67, 0);
		contentPane.add(radioButton);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2.setBounds(209, 175, 141, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_3.setBounds(209, 204, 141, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(68, 261, 306, 90);
		contentPane.add(textArea_1);
		
		JButton btnNext = new JButton("next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNext.setBounds(195, 426, 117, 29);
		contentPane.add(btnNext);
		
		JButton btnPrev = new JButton("prev");
		btnPrev.setBounds(68, 426, 117, 29);
		contentPane.add(btnPrev);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setBounds(339, 426, 117, 29);
		contentPane.add(btnFinish);
	}
}
