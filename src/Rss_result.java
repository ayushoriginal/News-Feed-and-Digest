import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

//import home.Home;

public class Rss_result extends JFrame implements ActionListener {

	private JFrame frame;
	private String Email,Name;
	private JButton btnNewButton,btnLogout,btnback;
	/**
	 * Launch the app	/**
	 * Create the application.
	 */
	JFrame getJFrame()
	{
		return this.frame;
	}
	
	
	public Rss_result(String s,String email) {
		
		Email = email;
		SqlConnectivity hi = new SqlConnectivity();
		Name = hi.retunnNameByEmail(email);	
		
		frame = new JFrame("Personalised News Feed and Digest");
		//frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setSize(new Dimension(1367, 740));
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		//panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(10, 11, 1331, 111);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		//panel_6.setBackground(new Color(204, 255, 102));
		panel_6.setBounds(1038, 0, 283, 450);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hi "+ Name);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(802, 5, 226, 41);
		panel.add(lblNewLabel);
		
		btnLogout = new JButton("Log Out");
		btnLogout.addActionListener(this);
		//btnLogout.setBackground(new Color(255, 255, 102));
		btnLogout.setFont(new Font("Calibri", Font.PLAIN, 17));
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogout.setBounds(114, 2, 157, 28);
		panel_6.add(btnLogout);
		
		btnback = new JButton("Home");
		btnback.addActionListener(this);
		/*btnback.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try{
					System.out.println(arg0.getActionCommand());
					SqlConnectivity sql_object = new SqlConnectivity();
					if ( arg0.getSource() == btnback)
					{
						System.out.println("(in RSS_result)Home/Back Button. Home object is about to be made");
						System.out.println("(in RSS_result)Email to be sent in Home  is ="+Email);
						Home hm = new Home(Email);
						
						System.out.println("(in RSS_result)Home object is made and e-mail is passed");
						hm.getJFrame().setVisible(true);
						System.out.println("(in RSS_result)Home is visible");
						getJFrame().setVisible(false);
						System.out.println("(in RSS_result)End of btnback if statement");
					}
				}
				catch(Exception e){}
				//You have clicked on Sign Up. What next?
			}
		});*/

			
		//btnback.setBackground(new Color(204, 255, 102));
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnback.setBounds(114, 82, 157, 28);
		panel_6.add(btnback);
		
		
		btnNewButton = new JButton("My Account");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(114, 42, 157, 28);
		panel_6.add(btnNewButton);
		
		JLabel lblNewsWorld = new JLabel("News :");
		lblNewsWorld.setForeground(new Color(0, 128, 128));
		lblNewsWorld.setFont(new Font("Satisfaction", Font.BOLD, 50));
		lblNewsWorld.setBounds(121, 11, 357, 89);
		panel.add(lblNewsWorld);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/Title.gif")));
		lblNewLabel_1.setBounds(10, 5, 101, 101);
		panel.add(lblNewLabel_1);
	
		TextArea textArea = new TextArea();
		textArea.setBounds(21, 139, 1320, 536);
		frame.getContentPane().add(textArea);
		textArea.setText(s);
		textArea.setEditable(false);
		textArea.setFont(new Font("Dialog", Font.BOLD, 17));
	}
	
	public void actionPerformed(ActionEvent e){
		try{
			if(e.getSource()==btnNewButton){
				System.out.println("in my_account");
				MyAccount log = new MyAccount(Email);
				log.getJFrame().setVisible(true);
				getJFrame().setVisible(false);	
			}
			else if(e.getSource()==btnLogout){
				System.out.println("e-mail = "+Email);
				System.out.println("123in log_out");
				login log = new login();
				log.getJFrame().setVisible(true);
				getJFrame().setVisible(false);
			}
			else if(e.getSource() == btnback){
				System.out.println("in my_account");
				Home log = new Home(Email);
				log.getJFrame().setVisible(true);
				getJFrame().setVisible(false);	
			}
			
			
			
		}
		catch(Exception ex){
			
		}
	}
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rss_result window = new Rss_result("abhi","abhinandan@gmail.com");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
}
