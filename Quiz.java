import java.awt.event.*;
import javax.swing.*;

public class Quiz implements ActionListener{
	
	ReadFile readFile = new ReadFile();
	// readFile.read("questions.txt");
	String[] questions = readFile.getQuestions();
	String[][] options = readFile.getOptions();
	String[] answers = readFile.getAnswers();

	// char guess;
	char answer;
	int index;
	int points =0;
	int total_questions = questions.length;
	int result;
	int seconds=10;
	int correct_guess=0;

	String user;
	
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextField textarea = new JTextField();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JLabel time_label = new JLabel();
	JLabel seconds_left = new JLabel();
	JLabel guesses_label = new JLabel();
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
			}
		});
	
	public Quiz(String user) {

		this.user = user;

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,650);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);
		
		textfield.setBounds(0,0,650,50);
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		textarea.setBounds(0,50,650,50);
		textarea.setHorizontalAlignment(JTextField.CENTER);
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);

		guesses_label.setBounds(400, 150, 250, 50);
		guesses_label.setText("Correct Guesses : "+String.valueOf(correct_guess));
		guesses_label.setOpaque(true);
		guesses_label.setHorizontalAlignment(JTextField.CENTER);
		guesses_label.setBorder(BorderFactory.createBevelBorder(1));
		
		buttonA.setBounds(20,100,100,100);
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(20,200,100,100);
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(20,300,100,100);
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(20,400,100,100);
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		answer_labelA.setBounds(125,100,500,100);
		
		answer_labelB.setBounds(125,200,500,100);
		
		answer_labelC.setBounds(125,300,500,100);
		
		answer_labelD.setBounds(125,400,500,100);

		

		
		seconds_left.setBounds(535,510,100,100);
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
		time_label.setBounds(535,475,100,25);
		time_label.setHorizontalAlignment(JTextField.CENTER);

		
		frame.add(time_label);
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(textarea);
		frame.add(textfield);
		frame.add(guesses_label);
		frame.setVisible(true);
		
		nextQuestion();
	}
	public void nextQuestion() {
		
		if(index>=total_questions) {
			results();
		}
		else {
			textfield.setText("Question "+(index+1));
			textarea.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			timer.start();
			guesses_label.setText("Correct Guesses : "+String.valueOf(correct_guess));
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
			
			if(e.getSource()==buttonA) {
				answer= 'A';
				if(answer == answers[index].charAt(0)) {
					points+=10;
					correct_guess++;
				}
			}
			if(e.getSource()==buttonB){
				answer= 'B';
				if(answer == answers[index].charAt(0)) {
					points+=10;
					correct_guess++;
				}
			}
			if(e.getSource()==buttonC) {
				answer= 'C';
				if(answer == answers[index].charAt(0)) {
					points+=10;
					correct_guess++;
				}
			}
			if(e.getSource()==buttonD) {
				answer= 'D';
				if(answer == answers[index].charAt(0)) {
					points+=10;
					correct_guess++;
				}
			}
			displayAnswer();
	}
	public void displayAnswer() {
		
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer = ' ';
				seconds=10;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);	
				index++;
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}
	public void results(){
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		// result = (int)((points/(double)total_questions)*100);
		
		// textfield.setText("RESULTS!");
		// textarea.setText("");	
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
	
		Scores scoresObj = new Scores();
		String[] arr = { user, Integer.toString(points) };
		scoresObj.addScore(arr);
		
		frame.dispose();
		ScoreBoard scoreBoard = new ScoreBoard();
	}
	public static void main(String[] args) {
		Quiz quiz=new Quiz("Test");
	}
}
