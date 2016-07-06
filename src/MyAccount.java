import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;

public class MyAccount extends JFrame implements ActionListener{

	private JFrame frame;
	private String log_out="Log Out",home="Home",change_pass="Change Password";
	
	private String Email,Name,Sex;
	int Age;
	private String[] Phone = new String[2];
	
	SqlConnectivity sql = new SqlConnectivity();
	
	JFrame getJFrame()
	{
		return this.frame;
	}
	/**
	 * Launch the application.
	 */
	/*spublic static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyAccount window = new MyAccount("abhi@nandan.com");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public MyAccount(String email) {
		Email = email;
		Name = sql.retunnNameByEmail(Email);
		Age = sql.retunnAgeByEmail(Email);
		Phone = sql.retunnPhoneByEmail(Email);
		Sex = sql.retunnSexByEmail(Email);
		Integer age_ = Age;
		String age_string = age_.toString();
				
		frame = new JFrame("My Profile");
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.setSize(6000,5000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogOut.setBounds(1115, 58, 183, 33);
		frame.getContentPane().add(btnLogOut);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(this);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHome.setBounds(1115, 113, 183, 31);
		frame.getContentPane().add(btnHome);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(this);
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnChangePassword.setBounds(1115, 172, 183, 33);
		frame.getContentPane().add(btnChangePassword);
		
		JLabel lblNewName = new JLabel(Name);
		lblNewName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewName.setBounds(406, 113, 189, 40);
		frame.getContentPane().add(lblNewName);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName.setBounds(179, 113, 164, 40);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(179, 174, 164, 33);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblNewEmail = new JLabel(Email);
		lblNewEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewEmail.setBounds(406, 174, 189, 31);
		frame.getContentPane().add(lblNewEmail);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAge.setBounds(179, 231, 164, 33);
		frame.getContentPane().add(lblAge);
		
		JLabel lblNewAge = new JLabel(age_string);
		lblNewAge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewAge.setBounds(406, 231, 175, 33);
		frame.getContentPane().add(lblNewAge);
		
		JLabel lblPhoneNo = new JLabel("Phone no.");
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPhoneNo.setBounds(179, 295, 164, 29);
		frame.getContentPane().add(lblPhoneNo);
		JLabel lblNewNo = new JLabel(Phone[0]);
		lblNewNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewNo.setBounds(406, 295, 164, 29);
		frame.getContentPane().add(lblNewNo);
		
		JLabel lblNewNo_1 = new JLabel(Phone[1]);
		lblNewNo_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewNo_1.setBounds(406, 335, 164, 29);
		frame.getContentPane().add(lblNewNo_1);
		
		JLabel lblEditYourAccount = new JLabel("My Profile");
		lblEditYourAccount.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblEditYourAccount.setBounds(138, 11, 443, 63);
		frame.getContentPane().add(lblEditYourAccount);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSex.setBounds(179, 414, 164, 30);
		frame.getContentPane().add(lblSex);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(179, 475, 164, 31);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblNewPassword = new JLabel("........");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewPassword.setBounds(406, 467, 175, 33);
		frame.getContentPane().add(lblNewPassword);
		
		JLabel lblNewSex = new JLabel(Sex);
		lblNewSex.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewSex.setBounds(406, 414, 175, 33);
		frame.getContentPane().add(lblNewSex);
	}
	
	public void actionPerformed(ActionEvent e){
		String action = e.getActionCommand();
		System.out.println(action+"\n");
		if ( log_out.compareTo(action) == 0)
		{
			System.out.println("in log_out");
			login log = new login();
			log.getJFrame().setVisible(true);
			getJFrame().setVisible(false);
		}
		else if (home.compareTo(action) == 0)
		{
			System.out.println("in My account");
			Home log = new Home(Email);
			log.getJFrame().setVisible(true);
			getJFrame().setVisible(false);
		}
		else if (change_pass.compareTo(action) == 0)
		{
			System.out.println("My account"+Email);
			System.out.println("in My account");
			ChangePassword log = new ChangePassword(Email);
			log.getJFrame().setVisible(true);
			getJFrame().setVisible(false);
		}
	}
}
