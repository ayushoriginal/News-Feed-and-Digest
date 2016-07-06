import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class ChangePassword extends JFrame implements ActionListener{

	private JFrame frame;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private String action,Email,Name;
	private String log_out = "Log Out",my_account = "My Account",confirm = "Confirm";
	private String oldpass,newpass,conpass;
	SqlConnectivity sql_object = new SqlConnectivity();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword window = new ChangePassword("abhi@nandan.com");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	JFrame getJFrame()
	{
		return this.frame;
	}

	/**
	 * Create the application.
	 */
	public ChangePassword(String email) {
		Email = email;
		System.out.println("change password"+Email);
		Name = sql_object.retunnNameByEmail(Email);
		System.out.println("change password"+Name);
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.setSize(6000,5000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblChangePassword = new JLabel("Change Password :");
		lblChangePassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblChangePassword.setBounds(125, 11, 359, 64);
		frame.getContentPane().add(lblChangePassword);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(1099, 31, 232, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnMyAccount = new JButton("My Account");
		btnMyAccount.addActionListener(this);
		btnMyAccount.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMyAccount.setBounds(1099, 90, 232, 29);
		frame.getContentPane().add(btnMyAccount);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordField.setBounds(438, 217, 177, 29);
		frame.getContentPane().add(passwordField);
		
		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblOldPassword.setBounds(205, 217, 157, 29);
		frame.getContentPane().add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewPassword.setBounds(205, 301, 157, 29);
		frame.getContentPane().add(lblNewPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordField_1.setBounds(438, 301, 177, 29);
		frame.getContentPane().add(passwordField_1);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblConfirmPassword.setBounds(205, 384, 157, 29);
		frame.getContentPane().add(lblConfirmPassword);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordField_2.setBounds(438, 384, 177, 27);
		frame.getContentPane().add(passwordField_2);
		
		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(540, 484, 205, 38);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Hi " + Name);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(642, 31, 232, 55);
		frame.getContentPane().add(lblNewLabel);
	}
	
	public void actionPerformed(ActionEvent e){
		try{
			char p1[]= passwordField.getPassword();
			oldpass = new String (p1);
			char p2[]= passwordField_1.getPassword();
			newpass = new String (p2);
			char p3[]= passwordField_2.getPassword();
			conpass = new String (p3);
			System.out.println(e.getActionCommand());
			action = e.getActionCommand();
			if ( log_out.compareTo(action) == 0)
			{
				System.out.println("in log_out");
				login log = new login();
				log.getJFrame().setVisible(true);
				getJFrame().setVisible(false);
			}
			else if (my_account.compareTo(action) == 0)
			{
				System.out.println("in My account");
				MyAccount log = new MyAccount(Email);
				log.getJFrame().setVisible(true);
				getJFrame().setVisible(false);
			}
			else if (confirm.compareTo(action) == 0)
			{
				String truepass = sql_object.getPassword(Email,"1234");
				System.out.println(truepass+"\n"+oldpass+"\n"+newpass+"\n"+conpass);
				if (truepass.compareTo(oldpass) == 0)
				{
					if (newpass.compareTo(conpass) != 0)
					{
						sql_object.bothPasswordNotMatch();
					}
					else
					{
						sql_object.setPassword(Email,newpass,"1234");
						sql_object.password_changed();
						MyAccount log = new MyAccount(Email);
						log.getJFrame().setVisible(true);
						getJFrame().setVisible(false);
					}
				}
				else
				{
					sql_object.wrongPassword();
				}
			}
		}
		catch(Exception oe){
			
		}
	}
}
