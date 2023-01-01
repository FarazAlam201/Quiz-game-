import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginPage{
	void showerror(){
		JFrame window =new JFrame();
		JLabel error=new JLabel();
		window.setSize(300, 100);
		window.add(error);
		window.setVisible(true);
		error.setText("You need to enter a username to play the quiz");
		error.setBounds(10, 40, 280, 20);
		error.setHorizontalAlignment(error.CENTER);
		window.setLocationRelativeTo(null);
	}
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Start Quiz");
	JButton scoreBoardButton = new JButton("Show Scoreboard");
	JTextField UserField = new JTextField();
	JLabel userIDLabel = new JLabel("User:");
	
	LoginPage(){
		
		userIDLabel.setBounds(60,75,75,25);
		
		UserField.setBounds(115,75,200,25);
		
		loginButton.setBounds(60,150,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(e ->{
			if(UserField.getText().isEmpty()){
				showerror();
			}
			else{
				String user = UserField.getText();
				Quiz quiz = new Quiz(user);
				frame.dispose();
			}
			
			
		});
		
		scoreBoardButton.setBounds(175,150,150,25);
		scoreBoardButton.setFocusable(false);
		scoreBoardButton.addActionListener(e -> {
			ScoreBoard scoreBoard = new ScoreBoard();
			frame.dispose();

		});
		
		frame.add(userIDLabel);
		frame.add(UserField);
		frame.add(loginButton);
		frame.add(scoreBoardButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,300);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setTitle("User Login");
		
	}
	public static void main(String[] args) {
		new LoginPage();
	}

}