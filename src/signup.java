import java.sql.*;
import java.awt.event.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class signup extends JFrame implements ActionListener{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton ;
	private JRadioButton rdbtnMale,rdbtnFemale ;
	
	private String name,email,password,cpassword,sex,phone1,phone2;
	private Integer age_wrapper;
	private int age;
	private JLabel lblNewLabel_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	
	public signup() {
		frame = new JFrame("Personalized News Feed and Digest");
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.setSize(6000,5000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter your information :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(10, 11, 443, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(179, 130, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(406, 115, 226, 29);
		frame.getContentPane().add(textField);
		
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(179, 174, 60, 23);
		frame.getContentPane().add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setBounds(406, 165, 226, 29);
		frame.getContentPane().add(textField_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(179, 231, 99, 23);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordField.setBounds(406, 221, 226, 29);
		frame.getContentPane().add(passwordField);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblConfirmPassword.setBounds(179, 295, 164, 29);
		frame.getContentPane().add(lblConfirmPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordField_1.setBounds(406, 289, 226, 29);
		frame.getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Sex :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(179, 362, 84, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		rdbtnMale = new JRadioButton("male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnMale.setBounds(406, 360, 73, 23);
		frame.getContentPane().add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnFemale.setBounds(541, 360, 91, 23);
		frame.getContentPane().add(rdbtnFemale);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAge.setBounds(179, 424, 73, 23);
		frame.getContentPane().add(lblAge);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_2.setBounds(406, 421, 226, 29);
		frame.getContentPane().add(textField_2);
		
		JLabel lblPhoneNo = new JLabel("Phone No 1 :");
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPhoneNo.setBounds(179, 486, 118, 23);
		frame.getContentPane().add(lblPhoneNo);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_3.setBounds(406, 483, 226, 29);
		frame.getContentPane().add(textField_3);
		
		btnNewButton = new JButton("Continue ->");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(652, 648, 172, 35);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_3 = new JLabel("Phone No 2 :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(179, 547, 118, 29);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_4.setBounds(406, 547, 226, 29);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		lblNewLabel_4 = new JLabel("(Important Field)");
		lblNewLabel_4.setBounds(648, 115, 128, 29);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("(Important Field)");
		lblNewLabel_5.setBounds(650, 165, 110, 29);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("(Important Field)");
		lblNewLabel_6.setBounds(651, 221, 99, 29);
		frame.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("(Important Field)");
		lblNewLabel_7.setBounds(651, 290, 110, 23);
		frame.getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("(Important Field)");
		lblNewLabel_8.setBounds(649, 421, 110, 29);
		frame.getContentPane().add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("(Important Field)");
		lblNewLabel_9.setBounds(647, 481, 118, 29);
		frame.getContentPane().add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("(Optional)");
		lblNewLabel_10.setBounds(644, 545, 118, 29);
		frame.getContentPane().add(lblNewLabel_10);
	}
	
	public void actionPerformed(ActionEvent e){
		name = textField.getText();
		email = textField_1.getText();
		char p1[]= passwordField.getPassword();
		password = new String (p1);
		char p2[]= passwordField_1.getPassword();
		cpassword = new String (p2);
		if (rdbtnMale.isSelected()) 
			sex = rdbtnMale.getText();
		else
			sex = rdbtnFemale.getText();
		String for_age = textField_2.getText();
		age = Integer.parseInt(for_age);
		phone1 = textField_3.getText();
		phone2 = textField_4.getText();
		
		SqlConnectivity sql_object = new SqlConnectivity();
		int comp = password.compareTo(cpassword);
		if (comp == 0)
		{
			System.out.println(name);
			System.out.println(email);
			System.out.println(password);
			System.out.println(age);
			System.out.println(sex);
			System.out.println(phone1);
			System.out.println(phone2);
			
		
			
		/*	if (!email.contains(".com") || !email.contains("@"))
				sql_object.wrongEmail();*/

			if (email.contains(".com") && email.contains("@"))
			{
				sql_object.setSignup(name, email, cpassword, age, sex, phone1,phone2);
				Home home = new Home(email);
				home.getJFrame().setVisible(true);
				getJFrame().setVisible(false);
			}
			else
				sql_object.wrongEmail();
		}
		else
			sql_object.bothPasswordNotMatch();
		
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
					signup window = new signup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
}