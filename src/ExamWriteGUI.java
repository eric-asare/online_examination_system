// TODO : Check user input when Next Button is clicked
// TODO: when teacher clicks finish, let them type time and exam name

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;

public class ExamWriteGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JRadioButton rdbtnMCQ;
	private JRadioButton rdbtnText;
	private JButton btnNextQuestion;
	private JButton btnFinish;
	private ButtonGroup typeGroup;

	private ActionListener typeListener;

	private JTextField weight;
	private JTextField ans_choice_1;
	private JTextField ans_choice_2;
	private JTextField ans_choice_3;
	private JTextField ans_choice_4;

	private JPanel contentPane;
	private JPanel selectionPanel;
	private JPanel TextPanel;
	private JPanel MCQPanel;
	private JPanel nextFinishPanel;

	private JLabel lblQuesNum;
	private int question_no;
	private JTextArea writeQuestion;
	private JLabel lblWeight;

	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private ButtonGroup choices;

	private JRadioButton[] ans_buttons;
	private JTextField[] ans_fields;
	
	private JSlider slider;

	private JLabel lblNumOfAns;

	private JTextArea txtrTypeAnswer;

	private ExamManager exManager;
	

	public ExamWriteGUI() {
		setTitle("Write Exams");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		selectionPanel = new JPanel();
		selectionPanel.setBounds(158, 78, 500, 203);
		contentPane.add(selectionPanel);
		selectionPanel.setLayout(null);
		
		rdbtnMCQ = new JRadioButton("MCQ");
		rdbtnMCQ.setBounds(176, 6, 141, 23);
		selectionPanel.add(rdbtnMCQ);
		
		rdbtnText = new JRadioButton("Text");
		rdbtnText.setBounds(329, 6, 141, 23);
		selectionPanel.add(rdbtnText);

		typeGroup = new ButtonGroup();
		typeGroup.add(rdbtnMCQ);
		typeGroup.add(rdbtnText);

		typeListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TextPanel.setVisible(rdbtnText.isSelected());
				MCQPanel.setVisible(rdbtnMCQ.isSelected());
				nextFinishPanel.setVisible(true);

			}
		};



		rdbtnMCQ.addActionListener(typeListener);
		rdbtnText.addActionListener(typeListener);
		
		question_no = 1;
		lblQuesNum = new JLabel("Question 1");
		lblQuesNum.setBounds(30, 10, 88, 16);
		selectionPanel.add(lblQuesNum);
		
		writeQuestion = new JTextArea();
		writeQuestion.setText("type Question ..");
		writeQuestion.setBounds(93, 66, 297, 51);
		selectionPanel.add(writeQuestion);
		
		lblWeight = new JLabel("weight: ");
		lblWeight.setBounds(93, 146, 61, 16);
		selectionPanel.add(lblWeight);
		
		weight = new JTextField();
		weight.setBounds(148, 141, 130, 26);
		selectionPanel.add(weight);
		weight.setColumns(10);
		
		MCQPanel = new JPanel();
		MCQPanel.setBounds(158, 305, 500, 139);
		contentPane.add(MCQPanel);
		MCQPanel.setLayout(null);
		
		rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setBounds(59, 33, 20, 23);
		MCQPanel.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("");
		rdbtnNewRadioButton_1.setBounds(59, 68, 20, 23);
		MCQPanel.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("");
		rdbtnNewRadioButton_2.setBounds(280, 33, 20, 23);
		MCQPanel.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton("");
		rdbtnNewRadioButton_3.setBounds(280, 68, 20, 23);
		MCQPanel.add(rdbtnNewRadioButton_3);
		
		slider = new JSlider();
		slider.setMinorTickSpacing(4);
		slider.setMajorTickSpacing(2);
		slider.setMaximum(4);
		slider.setMinimum(2);
		slider.setBounds(143, 6, 190, 29);
		MCQPanel.add(slider);

		choices = new ButtonGroup();
		choices.add(rdbtnNewRadioButton);
		choices.add(rdbtnNewRadioButton_1);
		choices.add(rdbtnNewRadioButton_2);
		choices.add(rdbtnNewRadioButton_3);


		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int value = slider.getValue();
				for (int i = 0; i < 4; i++) {
					ans_buttons[i].setVisible(false);
					ans_fields[i].setVisible(false);
				}
				choices.clearSelection();
				choices = new ButtonGroup();
				for (int i = 0; i < value; i++) {
					choices.add(ans_buttons[i]);
					ans_buttons[i].setVisible(true);
					ans_fields[i].setVisible(true);
				}
			}
		});

		// text fields
		ans_choice_1 = new JTextField();
		ans_choice_1.setBounds(87, 33, 130, 26);
		MCQPanel.add(ans_choice_1);
		ans_choice_1.setColumns(10);
		
		ans_choice_2 = new JTextField();
		ans_choice_2.setBounds(87, 65, 130, 26);
		MCQPanel.add(ans_choice_2);
		ans_choice_2.setColumns(10);
		
		ans_choice_3 = new JTextField();
		ans_choice_3.setBounds(310, 33, 130, 26);
		MCQPanel.add(ans_choice_3);
		ans_choice_3.setColumns(10);
		
		ans_choice_4 = new JTextField();
		ans_choice_4.setBounds(310, 65, 130, 26);
		MCQPanel.add(ans_choice_4);
		ans_choice_4.setColumns(10);

		ans_buttons = new JRadioButton[]{rdbtnNewRadioButton, rdbtnNewRadioButton_1, rdbtnNewRadioButton_2, rdbtnNewRadioButton_3};
		ans_fields = new JTextField[]{ans_choice_1, ans_choice_2, ans_choice_3, ans_choice_4};
		
		lblNumOfAns = new JLabel("Number of Answers");
		lblNumOfAns.setBounds(6, 6, 136, 16);
		MCQPanel.add(lblNumOfAns);
		
		TextPanel = new JPanel();
		TextPanel.setBounds(158, 305, 500, 139);
		contentPane.add(TextPanel);
		TextPanel.setLayout(null);
		
		txtrTypeAnswer = new JTextArea();
		txtrTypeAnswer.setBounds(80, 18, 334, 55);
		txtrTypeAnswer.setText("type Answer ..");
		TextPanel.add(txtrTypeAnswer);
		
		nextFinishPanel = new JPanel();
		nextFinishPanel.setBounds(163, 489, 500, 91);
		contentPane.add(nextFinishPanel);
		
		btnNextQuestion = new JButton("Next Question");
		nextFinishPanel.add(btnNextQuestion);
		
		btnFinish = new JButton("Finish");
		nextFinishPanel.add(btnFinish);

		exManager = ExamManager.get();

		btnNextQuestion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					saveQuestion();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Weight must be a positive integer");
				}
			}
		});

		btnFinish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = JOptionPane.showInputDialog("Input Exam Name:");
					int time = Integer.parseInt(JOptionPane.showInputDialog("Input Exam Time (minutes):"));
					saveQuestion();
					exManager.submit(name, time);
					System.exit(0);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Weight and time must be a positive integer");
				}
			}
		});


		// Hide All Panels Except contentPane
		MCQPanel.setVisible(false);
		TextPanel.setVisible(false);
		selectionPanel.setVisible(true);
		nextFinishPanel.setVisible(false);

	
	}

	private void saveQuestion() throws NumberFormatException {
		//public MCQuestion(String question, String[] answers, int ans_choice, int weight)
		if (rdbtnMCQ.isSelected()) {
			String[] answers = new String[slider.getValue()];
			int ans_choice = -1;
			for (int i = 0; i < slider.getValue(); i++) {
				System.out.println(ans_fields[i]);
				answers[i] = ans_fields[i].getText().replace("\t", "  ");
				if (ans_buttons[i].isSelected()) {
					ans_choice = i;
				}
			}
			if (ans_choice == -1) {
				return;
			}
			int w = Integer.parseInt(weight.getText());
			if (w <= 0) {
				throw new NumberFormatException();
			}
			Question q = new MCQuestion(writeQuestion.getText(), answers, ans_choice, w);
			lblQuesNum.setText(String.format("Question %d", ++question_no));
			exManager.save(q);
		}
		//TextQuestion(String question, String answer, int weight)
		else if (rdbtnText.isSelected()) {
			int w = Integer.parseInt(weight.getText());
			if (w <= 0) {
				throw new NumberFormatException();
			}
			Question q = new TextQuestion(writeQuestion.getText(), txtrTypeAnswer.getText(), w);
			lblQuesNum.setText(String.format("Question %d", ++question_no));
			exManager.save(q);
		}

		writeQuestion.setText("");
		weight.setText("");
		txtrTypeAnswer.setText("");
		for (int i = 0; i < 4; i++) {
			ans_fields[i].setText("");
		}
		choices.clearSelection();
	}
}
