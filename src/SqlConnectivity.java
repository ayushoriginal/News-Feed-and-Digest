
import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

public class SqlConnectivity
{
	static String JDBC_DRIVER,DB_URL;
	String USER,PASS;
	Connection conn;
	Statement stmt;
	
	SqlConnectivity()
	{
		JDBC_DRIVER = "com.mysql.jdbc.Driver";
		DB_URL = "jdbc:mysql://localhost/PERSONALIZED";
		USER = "root";
		PASS = "abhi";
		conn = null;
		stmt = null;
	}

	public void password_changed()
	{
		JOptionPane.showMessageDialog(null,"Your password is updated");
	}
	
	public void Log_out()
	{
		login window = new login();
		window.getJFrame().setVisible(true);
	}
	
	public void setPassword(String email,String newpass,String key){

		if (key != "1234")
		{
			System.out.println("Not allowed to modify the password");
		}
		else
		{
			try{
				Class.forName(JDBC_DRIVER);
			     conn = DriverManager.getConnection(DB_URL, USER, PASS);
			      stmt = conn.createStatement();
			      //UPDATE Customers    SET ContactName='Alfred Schmidt', City='Hamburg' WHERE CustomerName='Alfreds Futterkiste';
				
			      String sql = "update login set password='"+newpass+"' where email='"+email+"';";
			      stmt.executeUpdate(sql);
			}
			catch(SQLException se)		//Handle errors for JDBC
			{
			      se.printStackTrace();		
			}
			catch(Exception e)		//Handle errors for Class.forName
			{
				e.printStackTrace();	  
			}
			finally			//finally block used to close resources
			{	
			      try
			      {
			         if(stmt!=null)
			        	 stmt.close();
			      }
			      catch(SQLException se)
			      {
			    	  se.printStackTrace();
			      }
			      try
			      {
			         if(conn!=null)
			            conn.close();
			      }
			      catch(SQLException se)
			      {
			    	  se.printStackTrace();
			      }//end finally try
			}	
		}
	}
	
	public String getPassword(String email,String key){
		String Ab="";
		if (key == "1234")
		{
			try{
					System.out.println(Ab);
					Class.forName(JDBC_DRIVER);
				     conn = DriverManager.getConnection(DB_URL, USER, PASS);
				      stmt = conn.createStatement();
					String sql = "Select password from login where email='"+email+"';";
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()){
						Ab = rs.getString("password");
					}
				}
				catch(SQLException se)		//Handle errors for JDBC
				{
				      se.printStackTrace();		
				}
				catch(Exception e)		//Handle errors for Class.forName
				{
					e.printStackTrace();	  
				}
				finally			//finally block used to close resources
				{	
				      try
				      {
				         if(stmt!=null)
				        	 stmt.close();
				      }
				      catch(SQLException se)
				      {
				    	  se.printStackTrace();
				      }
				      try
				      {
				         if(conn!=null)
				            conn.close();
				      }
				      catch(SQLException se)
				      {
				    	  se.printStackTrace();
				      }//end finally try
				}	
				System.out.println(Ab);
				return Ab;
		}
		else
		{
			return "-1";
		}
	}
	
	public String Retrieve_link(String name)
	{
		String A="null";
		try{
			System.out.println(A);
			Class.forName(JDBC_DRIVER);
		     conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      stmt = conn.createStatement();
			String sql = "Select link from Topic where field_name='"+name+"';";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
					A = rs.getString("LINK");
			}
		}
		catch(SQLException se)		//Handle errors for JDBC
		{
		      se.printStackTrace();		
		}
		catch(Exception e)		//Handle errors for Class.forName
		{
			e.printStackTrace();	  
		}
		finally			//finally block used to close resources
		{	
		      try
		      {
		         if(stmt!=null)
		        	 stmt.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }
		      try
		      {
		         if(conn!=null)
		            conn.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }//end finally try
		}	
		System.out.println(A);
		return A;
	}
	
	public int retunnAgeByEmail(String Email)
	{
		int Age = -1;
		try
		{
		      Class.forName(JDBC_DRIVER);
		      //System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      //System.out.println("Connected database successfully...");
		      //System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql = "Select age from signup where email='"+Email+"';";
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      //boolean me = true;
		      while(rs.next())
		      {
		    	 Age = rs.getInt("age");
		      }
		      System.out.println( "I am = " + Age);
		      return Age;
		}
		catch(SQLException se)		//Handle errors for JDBC
		{
		      se.printStackTrace();		
		}
		catch(Exception e)		//Handle errors for Class.forName
		{
			e.printStackTrace();	  
		}
		finally			//finally block used to close resources
		{	
		      try
		      {
		         if(stmt!=null)
		        	 stmt.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }
		      try
		      {
		         if(conn!=null)
		            conn.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }//end finally try
		}			//end try
		return -1;
	}
	
	public String retunnNameByEmail(String Email)
	{
		String myname="";
		try
		{
		      Class.forName(JDBC_DRIVER);
		      //System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      //System.out.println("Connected database successfully...");
		      //System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql = "Select name from signup where email='"+Email+"';";
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      //boolean me = true;
		      while(rs.next())
		      {
		    	 myname = rs.getString("name");
		      }
		      System.out.println( "this is = "+myname);
		}
		catch(SQLException se)		//Handle errors for JDBC
		{
		      se.printStackTrace();		
		}
		catch(Exception e)		//Handle errors for Class.forName
		{
			e.printStackTrace();	  
		}
		finally			//finally block used to close resources
		{	
		      try
		      {
		         if(stmt!=null)
		        	 stmt.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }
		      try
		      {
		         if(conn!=null)
		            conn.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }//end finally try
		}			//end try
		return myname;
	}
	
	public String retunnSexByEmail(String Email)
	{
		String mysex="";
		try
		{
		      Class.forName(JDBC_DRIVER);
		      //System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      //System.out.println("Connected database successfully...");
		      //System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql = "Select sex from signup where email='"+Email+"';";
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      //boolean me = true;
		      while(rs.next())
		      {
		    	 mysex = rs.getString("sex");
		      }
		      System.out.println( "this is = "+mysex);
		}
		catch(SQLException se)		//Handle errors for JDBC
		{
		      se.printStackTrace();		
		}
		catch(Exception e)		//Handle errors for Class.forName
		{
			e.printStackTrace();	  
		}
		finally			//finally block used to close resources
		{	
		      try
		      {
		         if(stmt!=null)
		        	 stmt.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }
		      try
		      {
		         if(conn!=null)
		            conn.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }//end finally try
		}			//end try
		return mysex;
	}
	
	public String[] retunnPhoneByEmail(String Email)
	{
		String[] myphone= new String[2];
		myphone[0]="";
		myphone[1]="";
		try
		{
		      Class.forName(JDBC_DRIVER);
		      //System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      //System.out.println("Connected database successfully...");
		      //System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql = "Select phone from phone where email='"+Email+"';";
		      ResultSet rs = stmt.executeQuery(sql);
		      int i=0;
		      while(rs.next())
		      {
		    	  if (i==0){
		    		  myphone[0] = rs.getString("phone");
		    		  i++;
		    	  }
		    	  else{
		    		  myphone[1] = rs.getString("phone");
		    	  }
		      }
		      System.out.println( "this is = "+myphone[0]+" "+myphone[1]);
		      return myphone;
		}
		catch(SQLException se)		//Handle errors for JDBC
		{
		      se.printStackTrace();		
		}
		catch(Exception e)		//Handle errors for Class.forName
		{
			e.printStackTrace();	  
		}
		finally			//finally block used to close resources
		{	
		      try
		      {
		         if(stmt!=null)
		        	 stmt.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }
		      try
		      {
		         if(conn!=null)
		            conn.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }//end finally try
		}			//end try
		return myphone;
	}
	
	public void bothPasswordNotMatch()
	{
		JOptionPane.showMessageDialog(null,"Both the password do not match");
	}
	
	public void wrongEmail()
	{
		JOptionPane.showMessageDialog(null,"The email should be a valid one\nEg : something_here@example.com");
	}
	
	public void emailOrPasswordWrong()
	{
		JOptionPane.showMessageDialog(null,"Email or Password is wrong");
	}
	
	public void wrongPassword()
	{
		JOptionPane.showMessageDialog(null,"Password you entered in wrong");
	}
	
	public void setSignup(String name,String email,String password,int age,String sex,String phone1,String phone2)
	{
		try
		{
		      Class.forName(JDBC_DRIVER);
		      //System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      //System.out.println("Connected database successfully...");
		      //System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql = "INSERT INTO signup values("
		    		  		+"'"+name+"',"
		    		  		+"'"+email+"',"
		    		  		+age+","
		    		  		+"'"+sex+"');";
		      
//		    		  		+"'"+phone1+"');";
		      
		      String sql1 = "INSERT INTO login values("
		    		  		+"'"+email+"',"
		    		  		+"'"+password+"');";
		    		  		
		      String sql2 = "INSERT INTO phone values("
		    		  		+"'"+email+"',"
		    		  		+"'"+phone1+"');";
		      
		      String sql3 = "INSERT INTO phone values("
	    		  		+"'"+email+"',"
	    		  		+"'"+phone2+"');";
		      
		      System.out.println("statement signup = " + sql);
		      System.out.println("statement login = " + sql1);
		      System.out.println("statement phone1 = " + sql2);
		      System.out.println("statement phone2 = " + sql3);
		      stmt.executeUpdate(sql);
		      System.out.println("hi 1");
		      stmt.executeUpdate(sql1);
		      System.out.println("hi 2");
		      stmt.executeUpdate(sql2);
		      System.out.println("hi 3");
		      stmt.executeUpdate(sql3);
		      System.out.println("hi 4");
		}
		catch(SQLException se)		//Handle errors for JDBC
		{
		      se.printStackTrace();		
		}
		catch(Exception e)		//Handle errors for Class.forName
		{
			e.printStackTrace();	  
		}
		finally			//finally block used to close resources
		{	
		      try
		      {
		         if(stmt!=null)
		        	 stmt.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }
		      try
		      {
		         if(conn!=null)
		            conn.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }//end finally try
		}			//end try
	}
	
	public void NewsSave(String title,String link,String description)
	{
		try
		{
		      Class.forName(JDBC_DRIVER);
		      //System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      //System.out.println("Connected database successfully...");
		      //System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql = "INSERT INTO news values("
		    		  		+"'"+title+"',"
		    		  		+"'"+link+"',"
		    		  		+"'"+description+"') "
		    		  		+ "where not exists("
		    		  		+ title + ");";
		      
		      /*INSERT INTO table_listnames (name, address, tele)
SELECT * FROM (SELECT 'Rupert', 'Somewhere', '022') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM table_listnames WHERE name = 'Rupert'
) LIMIT 1;
*/
		      
		      System.out.println("statement news = " + sql);
		      stmt.executeUpdate(sql);
		      System.out.println("hi 1");
		      }
		catch(SQLException se)		//Handle errors for JDBC
		{
		      se.printStackTrace();		
		}
		catch(Exception e)		//Handle errors for Class.forName
		{
			e.printStackTrace();	  
		}
		finally			//finally block used to close resources
		{	
		      try
		      {
		         if(stmt!=null)
		        	 stmt.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }
		      try
		      {
		         if(conn!=null)
		            conn.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }//end finally try
		}			//end try
	}
	
	public void HistorySave(String email,String topic_name)
	{
		try
		{
		      Class.forName(JDBC_DRIVER);
		      //System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      //System.out.println("Connected database successfully...");
		      //System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql = "INSERT INTO history values("
		    		  		+"'"+email+"',"
		    		  		+"'"+topic_name+"');";
		      
		      System.out.println("statement history = " + sql);
		      stmt.executeUpdate(sql);
		      System.out.println("hi 1");
		      }
		catch(SQLException se)		//Handle errors for JDBC
		{
		      se.printStackTrace();		
		}
		catch(Exception e)		//Handle errors for Class.forName
		{
			e.printStackTrace();	  
		}
		finally			//finally block used to close resources
		{	
		      try
		      {
		         if(stmt!=null)
		        	 stmt.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }
		      try
		      {
		         if(conn!=null)
		            conn.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }//end finally try
		}			//end try
	}
	
	
	public void ReceivesSave(String title,String email)
	{
		try
		{
			
			System.out.println("inside receivesSave --> TITLE:: "+title+" EMAIL :: "+email);
		      Class.forName(JDBC_DRIVER);
		      //System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      //System.out.println("Connected database successfully...");
		      //System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql = "INSERT INTO receives values("
		    		  		+"'"+title+"',"
		    		  		+"'"+email+"');";
		      
		      System.out.println("statement receives = " + sql);
		      stmt.executeUpdate(sql);
		      System.out.println("hi 1");
		      }
		catch(SQLException se)		//Handle errors for JDBC
		{
		      se.printStackTrace();		
		}
		catch(Exception e)		//Handle errors for Class.forName
		{
			e.printStackTrace();	  
		}
		finally			//finally block used to close resources
		{	
		      try
		      {
		         if(stmt!=null)
		        	 stmt.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }
		      try
		      {
		         if(conn!=null)
		            conn.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }//end finally try
		}			//end try
	}
	
	
	public boolean checkLogin(String email,String pass)
	{
		try
		{
		      Class.forName(JDBC_DRIVER);
		      //System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      //System.out.println("Connected database successfully...");
		      //System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      
		      String sql = "SELECT * FROM login";
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while(rs.next())
		      {
		    	  String myemail = rs.getString("email");
		          String mypassword = rs.getString("password");
					int mail = email.compareTo(myemail);
					int word = pass.compareTo(mypassword);
		          if (mail==0 && word==0)
		          {
		        	  System.out.println(true);
		        	  return true;
		          }
		      }
		      System.out.println(false);
		      return false;
		}
		catch(SQLException se)		//Handle errors for JDBC
		{
		      se.printStackTrace();		
		}
		catch(Exception e)		//Handle errors for Class.forName
		{
			e.printStackTrace();	  
		}
		finally			//finally block used to close resources
		{	
		      try
		      {
		         if(stmt!=null)
		        	 stmt.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }
		      try
		      {
		         if(conn!=null)
		            conn.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }//end finally try
		 }//end try
		return false;
	}
	
	public void setFollow(ArrayList<String> follow_topic,String main_email)
	{
		try
		{
		      Class.forName(JDBC_DRIVER);
		      //System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      //System.out.println("Connected database successfully...");
		      //System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      
		      String sql = "insert into follow(email) values('"+main_email+"');";
		      System.out.println("commands = " + sql);
		      stmt.executeUpdate(sql);
		      Iterator<String> folow_iterator = follow_topic.iterator();
		      while (folow_iterator.hasNext()) 
		      {
		    	  String topics = folow_iterator.next();
		    	  //System.out.println(folow_iterator.next());
		    	  sql = "update follow "
		    	  + "SET "+topics+"=1 where email='"+main_email+"';"; 
		    	  System.out.println("commands = " + sql);
		    	  stmt.executeUpdate(sql);
		      }
		}
		catch(SQLException se)		//Handle errors for JDBC
		{
		      se.printStackTrace();		
		}
		catch(Exception e)		//Handle errors for Class.forName
		{
			e.printStackTrace();	  
		}
		finally			//finally block used to close resources
		{	
		      try
		      {
		         if(stmt!=null)
		        	 stmt.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }
		      try
		      {
		         if(conn!=null)
		            conn.close();
		      }
		      catch(SQLException se)
		      {
		    	  se.printStackTrace();
		      }//end finally try
		 }//end try
	}
	
	public void setHome()
	{
		
	}
	
	/*public static void main(String args[])
	{
		SqlConnectivity p = new SqlConnectivity();
		p.setSignup("abhinandan mittal","abhinandan@gmail.com","vertical1",21,"m","8875012802","46532412");
		boolean x = p.checkLogin("abhinandan.mittal@gmail.com","vertical1");
		p.setSignup("abhinandan mittal","abhinandan.mittal@gmail.com","vertical1",21,"m","45678912351","46532412");
		x = p.checkLogin("abhinandan.mittal@gmail.com","vertical1");
		x = p.checkLogin("anmol@gmail.com","verti1");
		p.setSignup("anmol mittal","anmol@gmail.com","verti1",17,"m","451232548412","65413521");
		x = p.checkLogin("anmol@gmail.com","verti1");
		p.Retrieve_link("Business");
		
	}*/
}