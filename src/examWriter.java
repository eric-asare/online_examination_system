import javax.swing.*;
import javax.swing.border.EmptyBorder;
// import jav

public class examWriter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JRadioButton rdbtnMCQ;
	private JRadioButton rdbtnText;
	private JButton btnNextQuestion;
	private JButton btnFinish;
	private ButtonGroup questionType;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	private JPanel contentPane;
	private JPanel selectionPanel;
	private JPanel TextPanel;
	private JPanel MCQPanel;
	private JPanel nextFinishPanel;

	private JLabel lblQuesNum;
	private JTextArea writeQuestion;
	private JLabel lblWeight;

	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private JSlider slider;
	private JLabel lblNumOfAns;

	private JTextArea txtrTypeAnswer ;
	

	public examWriter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 1000);
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

		questionType = new ButtonGroup();
		questionType.add(rdbtnMCQ);
		questionType.add(rdbtnText);

		// typeListener = new ActionListener
		
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
		
		textField = new JTextField();
		textField.setBounds(148, 141, 130, 26);
		selectionPanel.add(textField);
		textField.setColumns(10);
		
		MCQPanel = new JPanel();
		MCQPanel.setBounds(158, 305, 500, 139);
		contentPane.add(MCQPanel);
		MCQPanel.setLayout(null);
		
		rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setBounds(59, 33, 43, 23);
		MCQPanel.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("");
		rdbtnNewRadioButton_1.setBounds(59, 68, 43, 23);
		MCQPanel.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("");
		rdbtnNewRadioButton_2.setBounds(270, 33, 28, 23);
		MCQPanel.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton("");
		rdbtnNewRadioButton_3.setBounds(270, 68, 28, 23);
		MCQPanel.add(rdbtnNewRadioButton_3);
		
		slider = new JSlider();
		slider.setMinorTickSpacing(4);
		slider.setMajorTickSpacing(2);
		slider.setMaximum(4);
		slider.setMinimum(2);
		slider.setBounds(143, 6, 190, 29);
		MCQPanel.add(slider);
		
		textField_1 = new JTextField();
		textField_1.setBounds(87, 33, 130, 26);
		MCQPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(87, 65, 130, 26);
		MCQPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(310, 33, 130, 26);
		MCQPanel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(310, 65, 130, 26);
		MCQPanel.add(textField_4);
		textField_4.setColumns(10);
		
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


		// Hide All Panels Except contentPane
		MCQPanel.setVisible(false);
		TextPanel.setVisible(false);
		selectionPanel.setVisible(true);
		nextFinishPanel.setVisible(false);

	
	}
}
