import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class login extends JFrame implements ActionListener{

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnSignup,btnLogin;
	String email,pass;
	/**
	 * Create the application.
	 */
	public login() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.setSize(6000,5000);
		//frame.setBounds(100, 100, 688, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Connect To The World :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(38, 26, 3290, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(101, 288, 129, 31);
		frame.getContentPane().add(lblEmail);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(345, 290, 221, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(101, 347, 102, 21);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordField.setBounds(345, 344, 221, 28);
		frame.getContentPane().add(passwordField);
		/*textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setBounds(345, 344, 221, 28);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);*/
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogin.setBounds(101, 435, 129, 42);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblOr = new JLabel("or");
		lblOr.setBounds(709, 299, 46, 14);
		frame.getContentPane().add(lblOr);
		
		btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(this);
		btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSignup.setBounds(900, 309, 202, 42);
		frame.getContentPane().add(btnSignup);
		
		JLabel lblLoginInExisting = new JLabel("Login existing account");
		lblLoginInExisting.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoginInExisting.setBounds(101, 238, 210, 21);
		frame.getContentPane().add(lblLoginInExisting);
		
		JLabel lblCreateNewAccount = new JLabel("Create New Account :");
		lblCreateNewAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCreateNewAccount.setBounds(906, 234, 188, 28);
		frame.getContentPane().add(lblCreateNewAccount);
	}

	public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
		SqlConnectivity sql_object = new SqlConnectivity();
		//System.out.println("I am stud");
		email = textField.getText();
		char p[]= passwordField.getPassword();
		pass = new String (p);
		System.out.println(email);
		System.out.println(pass);
		
		String l = "Login";
		String action = e.getActionCommand();
		if (l.compareTo(action) != 0) {
			System.out.println("in signup");
			signup sign = new signup();
			getJFrame().setVisible(false);
			sign.getJFrame().setVisible(true);
			//window.getJFrame().setVisible(false);
		}
		else {
			boolean is_present = sql_object.checkLogin(email, pass);
			System.out.println(is_present);
			if (is_present) {
				Home home = new Home(email);
				home.getJFrame().setVisible(true);
				getJFrame().setVisible(false);
			}
			else {
				sql_object.emailOrPasswordWrong();
			}
		}
	}
	

	
	JFrame getJFrame()
	{
		return this.frame;
	}
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
}
