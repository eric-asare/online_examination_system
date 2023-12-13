import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

import javax.swing.*;
import java.awt.event.*;

import java.io.*;

/**
 * This class represent the interface for Student to take Exam
 */
public class TakeExamGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField weight;
	private JTextField ans_choice_1;
	private JTextField ans_choice_2;
	private JTextField ans_choice_3;
	private JTextField ans_choice_4;

	private JTextArea timerField;

	private JPanel contentPane;
	private JPanel questionPanel;
	private JPanel TextPanel;
	private JPanel MCQPanel;

	private JLabel lblQuesNum;
	private int question_no;
	private JTextArea question_box;
	private JLabel lblWeight;

	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private ButtonGroup choices;

	private JRadioButton[] ans_buttons;
	private JTextField[] ans_fields;

	private JTextArea txtrTypeAnswer;
	 
	private JButton btnNext;
	private JButton btnPrev;
	private	JButton btnFinish;


	private JPanel selectionPanel;
  	private JList<ExamOption> optionsList;

	private ExamManager exManager;
	private AnswerManager ansManager;

	private Timer timer;

	public TakeExamGUI() {
		setTitle("Take Exams");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);

		selectionPanel = new JPanel();
		selectionPanel.setLayout(new BorderLayout());
		setContentPane(selectionPanel);

		// Get All Exams Available 
		exManager = ExamManager.get();

		optionsList = new JList<ExamOption>(exManager.get_exams_display_info());
		optionsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Allow only single selection

		JScrollPane scrollPane = new JScrollPane(optionsList);

		JButton selectButton = new JButton("Select");
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentID = AnswerManager.get().getStudentID();
				int idx = optionsList.getSelectedValue().getID();
				int time = optionsList.getSelectedValue().getTime();
				File f = new File(String.format("answers/answer_%d_%s.txt", idx, studentID));
				if (f.exists()) {
					JOptionPane.showMessageDialog(null, "Already Took Exam");
				}
				else {
					takeExam(idx, studentID, time);
				}
			}
		});

		selectionPanel.add(scrollPane, BorderLayout.CENTER);
		selectionPanel.add(selectButton, BorderLayout.SOUTH);
	}

	private void takeExam(int examID, String studentID, int time) {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		questionPanel = new JPanel();
		questionPanel.setBounds(158, 78, 500, 203);
		contentPane.add(questionPanel);
		questionPanel.setLayout(null);
		
		
		question_no = 1;
		lblQuesNum = new JLabel("");
		lblQuesNum.setBounds(30, 10, 88, 16);
		questionPanel.add(lblQuesNum);
		
		question_box = new JTextArea();
		question_box.setBounds(93, 66, 297, 51);
		question_box.setEditable(false);
		questionPanel.add(question_box);
		
		lblWeight = new JLabel("weight: ");
		lblWeight.setBounds(93, 146, 61, 16);
		questionPanel.add(lblWeight);
		
		weight = new JTextField();
		weight.setBounds(148, 141, 130, 26);
		weight.setEditable(false);
		questionPanel.add(weight);
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

		choices = new ButtonGroup();
		choices.add(rdbtnNewRadioButton);
		choices.add(rdbtnNewRadioButton_1);
		choices.add(rdbtnNewRadioButton_2);
		choices.add(rdbtnNewRadioButton_3);

		// text fields
		ans_choice_1 = new JTextField();
		ans_choice_1.setBounds(87, 33, 130, 26);
		ans_choice_1.setEditable(false);
		MCQPanel.add(ans_choice_1);
		ans_choice_1.setColumns(10);
		
		ans_choice_2 = new JTextField();
		ans_choice_2.setBounds(87, 65, 130, 26);
		ans_choice_2.setEditable(false);
		MCQPanel.add(ans_choice_2);
		ans_choice_2.setColumns(10);
		
		ans_choice_3 = new JTextField();
		ans_choice_3.setBounds(310, 33, 130, 26);
		ans_choice_3.setEditable(false);
		MCQPanel.add(ans_choice_3);
		ans_choice_3.setColumns(10);
		
		ans_choice_4 = new JTextField();
		ans_choice_4.setBounds(310, 65, 130, 26);
		ans_choice_4.setEditable(false);
		MCQPanel.add(ans_choice_4);
		ans_choice_4.setColumns(10);

		ans_buttons = new JRadioButton[]{rdbtnNewRadioButton, rdbtnNewRadioButton_1, rdbtnNewRadioButton_2, rdbtnNewRadioButton_3};
		ans_fields = new JTextField[]{ans_choice_1, ans_choice_2, ans_choice_3, ans_choice_4};
		
		
		TextPanel = new JPanel();
		TextPanel.setBounds(158, 305, 500, 139);
		contentPane.add(TextPanel);
		TextPanel.setLayout(null);
		
		txtrTypeAnswer = new JTextArea();
		txtrTypeAnswer.setBounds(80, 18, 334, 55);
		txtrTypeAnswer.setText("type Answer ..");
		TextPanel.add(txtrTypeAnswer);
		
		btnNext = new JButton("next");
		btnNext.setBounds(225, 500, 117, 29);
		contentPane.add(btnNext);


		
		timerField = new JTextArea();
		timerField.setBounds(700, 60, 80, 25);
		timerField.setEditable(false);
		contentPane.add(timerField);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (question_no != exManager.getLength()) {
					save(question_no);
					loadQuestion(++question_no);
				}
			}
		});
		
		btnPrev = new JButton("prev");
		btnPrev.setBounds(98, 500, 117, 29);
		contentPane.add(btnPrev);

		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (question_no != 1) {
					save(question_no);
					loadQuestion(--question_no);
				}
			}
		});

		btnFinish = new JButton("Finish");
		btnFinish.setBounds(369, 500, 117, 29);
		contentPane.add(btnFinish);

		btnFinish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
			}
		});

		IDSetter.get().setExamID(examID);
		IDSetter.get().setStudentID(studentID);

		exManager.open_exam_file();

		ansManager = AnswerManager.get();

		loadQuestion(1);
		timer = new Timer(this);
		timer.setMinutes(time);
		timer.start();
	}

	public void finish() {
		save(question_no);
		ansManager.submit("Ungraded");
		JOptionPane.showMessageDialog(null, "Exam Finished");
		LoginGUI l = new LoginGUI();
		l.setVisible(true);
		dispose();
	}

	public void setTime(int seconds) {
		int min = seconds / 60;
		int sec = seconds % 60;
		timerField.setText(String.format("%d:%d", min, sec));
	}

	private void save(int question_no) {
		//save to AnswerManager
		String ans = "";
		int choice = -1;
		if(TextPanel.isVisible()) {
			ans = txtrTypeAnswer.getText();
		}
		else if (MCQPanel.isVisible()) {
			for (int i = 0; i < 4; i++) {
				if (ans_buttons[i].isSelected()) {
					ans = ans_fields[i].getText();
					choice = i;
				}
			}
		}
		ansManager.save(ans, question_no, choice);
	}

	private void loadQuestion(int question_no) {
		Question q = exManager.getQuestion(question_no);
		String[] answers = q.getChoices();
		if (answers == null) {
			//display text
			TextPanel.setVisible(true);
			MCQPanel.setVisible(false);
		}
		else {
			//display MCQ
			MCQPanel.setVisible(true);
			TextPanel.setVisible(false);
			for (int i = 0; i < 4; i++) {
				ans_buttons[i].setVisible(false);
				ans_fields[i].setVisible(false);
			}
			choices.clearSelection();
			choices = new ButtonGroup();
			for (int i = 0; i < answers.length; i++) {
				choices.add(ans_buttons[i]);
				ans_buttons[i].setVisible(true);
				ans_buttons[i].setSelected(false);
				ans_fields[i].setVisible(true);
				ans_fields[i].setText(answers[i]);
			}
			try {
				ans_buttons[ansManager.getAnswer(question_no).getAnsChoice()].setSelected(true);
			} catch (Exception e) {

			}
		}
		question_box.setText(q.getQuestion());
		weight.setText(Integer.toString(q.getWeight()));
		lblQuesNum.setText(String.format("Question %d", question_no));
	}

}
