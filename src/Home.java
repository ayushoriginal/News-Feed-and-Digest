import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;


public class Home extends JFrame implements ActionListener{

	private JFrame frame;
	private String Email,Name;
	private String log_out="Log Out",my_account="My Account",this_week="This Week",prime_time="Prime Time",most_read="Most Read",top_news="Top News",world="World",asia="Asia",sports="Sports",Africa="Africa",technology="Technology",entertainment="Entertainment",Video="Video",money="Money",travel="Travel",Americas="Americas",science="Science",Football="Football";
	private String action;
	private Rss_feed rssFeed;
	private JButton btnLogout;
	public String getEmail()
	{
		return this.Email;
	}
	
	public String get_Name()
	{
		return this.Name;
	}
	
	public JFrame getJFrame()
	{
		return this.frame;
	}
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home("abhi@nandan.com");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		);
	}*/

	/**
	 * Create the application.
	 */
		
	//public Home(String email) {
	public Home(String email) {
		//String email ="fsfd";
		
		System.out.println("Start of Home");
		Email = email;
		SqlConnectivity hi = new SqlConnectivity();
		Name = hi.retunnNameByEmail(Email);		
		System.out.println("(HOME)Retrieved name = "+Name);
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
		panel_6.setBounds(1038, 5, 283, 101);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		btnLogout = new JButton("Log Out");	
		btnLogout.addActionListener(this);
		//btnLogout.setBackground(new Color(255, 255, 102));
		btnLogout.setFont(new Font("Calibri", Font.PLAIN, 17));
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogout.setBounds(114, 15, 157, 28);
		panel_6.add(btnLogout);
		
		JButton btnNewButton = new JButton("My Account");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(114, 54, 157, 28);
		panel_6.add(btnNewButton);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewsWorld = new JLabel("How u doin' :)");
		//lblNewsWorld.setForeground(new Color(0, 128, 128));
		lblNewsWorld.setFont(new Font("Satisfaction", Font.BOLD, 50));
		lblNewsWorld.setBounds(121, 11, 357, 89);
		panel.add(lblNewsWorld);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/Title.gif")));
		lblNewLabel_1.setBounds(10, 5, 101, 101);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Hi "+ Name + "  !!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(802, 5, 226, 41);
		panel.add(lblNewLabel);
		
		/*JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 223, 863, -77);
		frame.getContentPane().add(panel_4);*/
		
		JPanel panel_5 = new JPanel();
		//panel_5.setBackground(new Color(0, 0, 0));
		panel_5.setBounds(10, 133, 1331, 70);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnThisWeek = new JButton("This Week");
		btnThisWeek.addActionListener(this);
		//btnThisWeek.setForeground(new Color(250, 250, 210));
		btnThisWeek.setFont(new Font("Extreme", Font.BOLD, 20));
		//btnThisWeek.setBackground(new Color(0, 128, 128));
		panel_5.add(btnThisWeek);
		btnThisWeek.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton btnPrimeTime = new JButton("Prime Time");
		btnPrimeTime.addActionListener(this);
		panel_5.add(btnPrimeTime);
		//btnPrimeTime.setForeground(new Color(250, 250, 210));
		btnPrimeTime.setFont(new Font("Extreme", Font.BOLD, 20));
		//btnPrimeTime.setBackground(new Color(0, 128, 128));
		btnPrimeTime.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton btnMostRead = new JButton("Most Read");
		btnMostRead.addActionListener(this);
		//btnMostRead.setForeground(new Color(250, 250, 210));
		btnMostRead.setFont(new Font("Extreme", Font.BOLD, 20));
		//btnMostRead.setBackground(new Color(0, 128, 128));
		panel_5.add(btnMostRead);
		btnMostRead.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton btnTopNews = new JButton("Top News");
		btnTopNews.addActionListener(this);
		//btnTopNews.setForeground(new Color(250, 250, 210));
		btnTopNews.setFont(new Font("Extreme", Font.BOLD, 20));
		//btnTopNews.setBackground(new Color(0, 128, 128));
		panel_5.add(btnTopNews);
		btnTopNews.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		
		JPanel panel_1 = new JPanel();
		//panel_1.setBackground(new Color(255, 255, 102));
		panel_1.setBounds(10, 214, 1331, 208);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 6, 0, 0));
		
		JPanel panel_9 = new JPanel();
		//panel_9.setBackground(new Color(0, 0, 0));
		panel_9.setLayout(null);
		panel_1.add(panel_9);
		
		JButton btnWorld = new JButton("World");
		btnWorld.addActionListener(this);
		btnWorld.setForeground(Color.BLACK);
		btnWorld.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnWorld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnWorld.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnWorld.setBounds(32, 167, 156, 30);
		panel_9.add(btnWorld);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Home.class.getResource("/World.jpg")));
		label_2.setBounds(32, 0, 156, 156);
		panel_9.add(label_2);
		
		JPanel panel_10 = new JPanel();
		//panel_10.setBackground(new Color(0, 0, 0));
		panel_10.setLayout(null);
		panel_1.add(panel_10);
		
		JButton btnAsia = new JButton("Asia");
		btnAsia.addActionListener(this);
		btnAsia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAsia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAsia.setBounds(32, 167, 156, 30);
		panel_10.add(btnAsia);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Home.class.getResource("/Business.jpg")));
		label_3.setBounds(32, 0, 156, 156);
		panel_10.add(label_3);
		
		JPanel panel_11 = new JPanel();
		//panel_11.setBackground(new Color(0, 0, 0));
		panel_11.setLayout(null);
		panel_1.add(panel_11);
		
		JButton btnSports = new JButton("Sports");
		btnSports.addActionListener(this);
		btnSports.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSports.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSports.setBounds(32, 167, 156, 30);
		panel_11.add(btnSports);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Home.class.getResource("/Sports.jpg")));
		label_4.setBounds(32, 0, 156, 156);
		panel_11.add(label_4);
		
		JPanel panel_12 = new JPanel();
		//panel_12.setBackground(new Color(0, 0, 0));
		panel_12.setLayout(null);
		panel_1.add(panel_12);
		
		JButton btnScience = new JButton("Africa");
		btnScience.addActionListener(this);
		btnScience.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnScience.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnScience.setBounds(32, 167, 156, 30);
		panel_12.add(btnScience);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Home.class.getResource("/Africa.jpg")));
		label_5.setBounds(32, 0, 156, 156);
		panel_12.add(label_5);
		
		JPanel panel_13 = new JPanel();
		//panel_13.setBackground(new Color(0, 0, 0));
		panel_13.setLayout(null);
		panel_1.add(panel_13);
		
		JButton btnTechnology = new JButton("Technology");
		btnTechnology.addActionListener(this);
		btnTechnology.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTechnology.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTechnology.setBounds(32, 167, 156, 30);
		panel_13.add(btnTechnology);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Home.class.getResource("/Technology.jpg")));
		label_6.setBounds(32, 0, 156, 156);
		panel_13.add(label_6);
		
		JPanel panel_14 = new JPanel();
		//panel_14.setBackground(new Color(0, 0, 0));
		panel_14.setLayout(null);
		panel_1.add(panel_14);
		
		JButton btnEntertainment = new JButton("Entertainment");
		btnEntertainment.addActionListener(this);
		btnEntertainment.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnEntertainment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEntertainment.setBounds(32, 167, 156, 30);
		panel_14.add(btnEntertainment);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Home.class.getResource("/Entertainment.jpg")));
		label_7.setBounds(32, 0, 156, 156);
		panel_14.add(label_7);
		
		JPanel panel_3 = new JPanel();
		//panel_3.setBackground(new Color(0, 0, 0));
		panel_3.setBounds(10, 458, 1331, 208);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(0, 6, 0, 0));
		
		JPanel panel_15 = new JPanel();
		//panel_15.setBackground(new Color(0, 0, 0));
		panel_15.setLayout(null);
		panel_3.add(panel_15);
		
		JButton btnVideo = new JButton("Video");
		btnVideo.addActionListener(this);
		btnVideo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnVideo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVideo.setBounds(32, 167, 156, 30);
		panel_15.add(btnVideo);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Home.class.getResource("/Video.jpg")));
		label_8.setBounds(32, 0, 156, 156);
		panel_15.add(label_8);
		
		JPanel panel_16 = new JPanel();
		//panel_16.setBackground(new Color(0, 0, 0));
		panel_16.setLayout(null);
		panel_3.add(panel_16);
		
		JButton btnMoney = new JButton("Money");
		btnMoney.addActionListener(this);
		btnMoney.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMoney.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMoney.setBounds(32, 167, 156, 30);
		panel_16.add(btnMoney);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(Home.class.getResource("/Money.jpg")));
		label_9.setBounds(32, 0, 156, 156);
		panel_16.add(label_9);
		
		JPanel panel_17 = new JPanel();
		//panel_17.setBackground(new Color(0, 0, 0));
		panel_17.setLayout(null);
		panel_3.add(panel_17);
		
		JButton btnTravel = new JButton("Travel");
		btnTravel.addActionListener(this);
		btnTravel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTravel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTravel.setBounds(32, 167, 156, 30);
		panel_17.add(btnTravel);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Home.class.getResource("/Travel.jpg")));
		label_10.setBounds(32, 0, 156, 156);
		panel_17.add(label_10);
		
		JPanel panel_18 = new JPanel();
		//panel_18.setBackground(new Color(0, 0, 0));
		panel_18.setLayout(null);
		panel_3.add(panel_18);
		
		JButton btnAmericas = new JButton("Americas");
		btnAmericas.addActionListener(this);
		btnAmericas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAmericas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAmericas.setBounds(32, 167, 156, 30);
		panel_18.add(btnAmericas);
		System.out.println("(HOME)its me");
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(Home.class.getResource("/Americas.jpg")));
		label_11.setBounds(32, 0, 156, 156);
		panel_18.add(label_11);
		
		JPanel panel_19 = new JPanel();
		//panel_19.setBackground(new Color(0, 0, 0));
		panel_19.setLayout(null);
		panel_3.add(panel_19);
		
		JButton btnScience_1 = new JButton("Science");
		btnScience_1.addActionListener(this);
		btnScience_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnScience_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnScience_1.setBounds(32, 167, 156, 30);
		panel_19.add(btnScience_1);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(Home.class.getResource("/Science.jpg")));
		label_12.setBounds(32, 0, 156, 156);
		panel_19.add(label_12);
		
		JPanel panel_20 = new JPanel();
		//panel_20.setBackground(new Color(0, 0, 0));
		panel_20.setLayout(null);
		panel_3.add(panel_20);
		
		JButton btnFootball = new JButton("Football");
		btnFootball.addActionListener(this);
		btnFootball.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnFootball.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFootball.setBounds(32, 167, 156, 30);
		panel_20.add(btnFootball);
		
		JLabel label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(Home.class.getResource("/Football.jpg")));
		label_13.setBounds(32, 0, 156, 156);
		panel_20.add(label_13);
		
	}
	
	public Home(int a) {
		System.out.println("Start of Home constructor without args");
		
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e){
		try{
			System.out.println(e.getActionCommand());
			SqlConnectivity sql_object = new SqlConnectivity();
			action = e.getActionCommand();
		//	if ( log_out.compareTo(action) == 0)
			if ( e.getSource() == btnLogout)
			{
				System.out.println("e-mail = "+Email);
				System.out.println("123in log_out");
				login log = new login();
				log.getJFrame().setVisible(true);
				getJFrame().setVisible(false);
			}
			else if (my_account.compareTo(action) == 0)
			{
				System.out.println("in my_account");
				MyAccount log = new MyAccount(Email);
				log.getJFrame().setVisible(true);
				getJFrame().setVisible(false);				
			}
			else if (this_week.compareTo(action) == 0)
			{
				SqlConnectivity sql = new SqlConnectivity();
				String A = sql.Retrieve_link(this_week);
				rssFeed = new Rss_feed();
				rssFeed.readRss(this_week,A,Email);
				sql.HistorySave(Email, this_week);
				getJFrame().setVisible(false);
			}
			else if (prime_time.compareTo(action) == 0)
			{
				SqlConnectivity sql = new SqlConnectivity();
				String A = sql.Retrieve_link(prime_time);
				int i=0;
				rssFeed = new Rss_feed();
				rssFeed.readRss(prime_time,A,Email);
				sql.HistorySave(Email, prime_time);
				getJFrame().setVisible(false);
			}
			else if (most_read.compareTo(action) == 0)
			{
				SqlConnectivity sql = new SqlConnectivity();
				String A = sql.Retrieve_link(most_read);
				
				int i=0;
				rssFeed = new Rss_feed();
				rssFeed.readRss(most_read,A,Email);
				sql.HistorySave(Email, most_read);
				getJFrame().setVisible(false);
			}
			else if (top_news.compareTo(action) == 0)
			{
				SqlConnectivity sql = new SqlConnectivity();
				String A = sql.Retrieve_link(top_news);
				int i=0;
				rssFeed = new Rss_feed();
				rssFeed.readRss(top_news,A,Email);
				sql.HistorySave(Email, top_news);
				getJFrame().setVisible(false);
			}
			else if (world.compareTo(action) == 0)
			{
				SqlConnectivity sql = new SqlConnectivity();
				String A = sql.Retrieve_link(world);
				int i=0;
				rssFeed = new Rss_feed();
				rssFeed.readRss(world,A,Email);
				sql.HistorySave(Email, world);
				getJFrame().setVisible(false);
			}
			else if (asia.compareTo(action) == 0)
			{
				SqlConnectivity sql = new SqlConnectivity();
				String A = sql.Retrieve_link(asia);
				int i=0;
				rssFeed = new Rss_feed();
				rssFeed.readRss(asia,A,Email);
				sql.HistorySave(Email, asia);
				getJFrame().setVisible(false);
			}
			else if (sports.compareTo(action) == 0)
			{
				SqlConnectivity sql = new SqlConnectivity();
				String A = sql.Retrieve_link(sports);
				int i=0;
				rssFeed = new Rss_feed();
				rssFeed.readRss(sports,A,Email);
				sql.HistorySave(Email, sports);
				getJFrame().setVisible(false);
			}
			else if (Africa.compareTo(action) == 0)
			{
				SqlConnectivity sql = new SqlConnectivity();
				String A = sql.Retrieve_link(Africa);
				int i=0;
				rssFeed = new Rss_feed();
				rssFeed.readRss(Africa,A,Email);
				sql.HistorySave(Email, Africa);
				getJFrame().setVisible(false);
			}
			else if (technology.compareTo(action) == 0)
			{
				SqlConnectivity sql = new SqlConnectivity();
				String A = sql.Retrieve_link(technology);
				int i=0;
				rssFeed = new Rss_feed();
				rssFeed.readRss(technology,A,Email);
				sql.HistorySave(Email, technology);
				getJFrame().setVisible(false);
			}
			else if (entertainment.compareTo(action) == 0)
			{
				SqlConnectivity sql = new SqlConnectivity();
				String A = sql.Retrieve_link(entertainment);
				int i=0;
				rssFeed = new Rss_feed();
				rssFeed.readRss(entertainment,A,Email);
				sql.HistorySave(Email, entertainment);
				getJFrame().setVisible(false);
			}
			else if (Video.compareTo(action) == 0)
			{
				SqlConnectivity sql = new SqlConnectivity();
				String A = sql.Retrieve_link(Video);
				int i=0;
				rssFeed = new Rss_feed();
				rssFeed.readRss(Video,A,Email);
				sql.HistorySave(Email, Video);
				getJFrame().setVisible(false);
			}
			else if (money.compareTo(action) == 0)
			{
				SqlConnectivity sql = new SqlConnectivity();
				String A = sql.Retrieve_link(money);
				int i=0;
				rssFeed = new Rss_feed();
				rssFeed.readRss(money,A,Email);
				sql.HistorySave(Email, money);
				getJFrame().setVisible(false);
			}
			else if (travel.compareTo(action) == 0)
			{
				SqlConnectivity sql = new SqlConnectivity();
				String A = sql.Retrieve_link(travel);
				int i=0;
				rssFeed = new Rss_feed();
				rssFeed.readRss(travel,A,Email);
				sql.HistorySave(Email, travel);
				getJFrame().setVisible(false);
			}
			else if (Americas.compareTo(action) == 0)
			{
				SqlConnectivity sql = new SqlConnectivity();
				String A = sql.Retrieve_link(Americas);
				int i=0;
				rssFeed = new Rss_feed();
				rssFeed.readRss(Americas,A,Email);
				sql.HistorySave(Email, Americas);
				getJFrame().setVisible(false);
			}
			else if (science.compareTo(action) == 0)
			{
				SqlConnectivity sql = new SqlConnectivity();
				String A = sql.Retrieve_link(science);
				int i=0;
				rssFeed = new Rss_feed();
				rssFeed.readRss(science,A,Email);
				sql.HistorySave(Email, science);
				getJFrame().setVisible(false);
			}
			else if (Football.compareTo(action) == 0)
			{
				SqlConnectivity sql = new SqlConnectivity();
				String A = sql.Retrieve_link(Football);
				int i=0;
				rssFeed = new Rss_feed();
				rssFeed.readRss(Football,A,Email);
				sql.HistorySave(Email, Football);
				getJFrame().setVisible(false);
			}
		}
		catch(Exception ex){
			
		}
	}
}
