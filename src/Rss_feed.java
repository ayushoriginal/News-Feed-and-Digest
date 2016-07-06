import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Rss_feed implements Collection{

	HashSet<String> hs_titles;
	HashSet<String> hs_links;
	HashSet<String> hs_desc;

	Rss_feed()	
	{
		hs_titles = new HashSet<String>();
		hs_links = new HashSet<String>();
		hs_desc = new HashSet<String>();
	}

	public void readRss(String field,String urlAddress,String Email){
		try{
			System.out.println("ayush1");
			URL rssURL = new URL(urlAddress);
			BufferedReader in = new BufferedReader(new InputStreamReader(rssURL.openStream()));
			String sourceCode = "";
			String line,temp1="-----\n",temp2="-----\n",temp3="-----\n";
			int title_count=0,link_count=0,desc_count=0;
			System.out.println("ayush2");
			SqlConnectivity sc = new SqlConnectivity();
			while((line=in.readLine())!= null) 
			{

				temp3="-----\n";
				if(line.contains("<title>")){
					System.out.println("ayush_title");
					title_count++;
					if(line.contains("<![CDATA[")){
						int pos1 = line.lastIndexOf("[");						
						int pos2 = line.indexOf("]");
						temp1=line.substring(pos1+1,pos2);
						temp1 = temp1.replace("&apos;","'");
					}
					else{
						int firstPos = line.indexOf("<title>");
						int lastPos = line.indexOf("</title>");
						temp1 = line.substring(firstPos,lastPos);
						temp1 = temp1.replace("<title>","");
						temp1 = temp1.replace("&apos;","'");
					}
					hs_titles.add(temp1);
					sourceCode += "-----------------------------------------------------------------------------------------------------------------------------------------------------\n";
					sourceCode += "Title : "+temp1+"\n";
					sourceCode += "-----------------------------------------------------------------------------------------------------------------------------------------------------\n";
					System.out.println("ayush_title");
				}
				else if(line.contains("<link>")){
					System.out.println("ayush_link");
					link_count++;
					if(line.contains("<![CDATA[")){
						int pos1=line.lastIndexOf("[");
						int pos2=line.indexOf("]");
						temp2=line.substring(pos1+1,pos2);
						temp2 = temp2.replace("&apos;","'");
					}
					else{
						int firstPos = line.indexOf("<link>");
						int lastPos = line.indexOf("</link>");
						temp2 = line.substring(firstPos,lastPos);
						temp2 = temp2.replace("<link>","");
						temp2 = temp2.replace("&apos;","'");
					}
					//						if (link_count > 2){
					hs_links.add(temp2);
					sourceCode += temp2+"\n\n";
					//					}
					System.out.println("ayush_link");
				}
				else if(line.contains("<description>")){
					System.out.println("ayush_desc");
					desc_count++;
					if(line.contains("<![CDATA[")){
						int pos1=line.lastIndexOf("[");
						int pos2=line.indexOf("]");
						temp3=line.substring(pos1+1,pos2);
						temp3 = temp3.replace("&apos;","'");
					}
					else{
						int firstPos = line.indexOf("<description>");
						int lastPos = line.indexOf("</description>");
						temp3 = line.substring(firstPos,lastPos);
						temp3 = temp3.replace("<description>","");
						temp3 = temp3.replace("&apos;","'");
						if(temp3.contains("&lt"))
							temp3="-----\n";
						if(temp3.isEmpty())
							temp3="-----\n";
					}
					//				if (desc_count > 1){
					hs_desc.add(temp3);
					sourceCode += temp3+"\n";
					sourceCode += "\n\n\n\n\n\n";
					//			}
					System.out.println("ayush_desc");
				}
				System.out.println("TITLE::"+temp1);
				System.out.println("Link::"+temp2);
				System.out.println("Desciption::"+temp3);
				sc.NewsSave(temp1, temp2, temp3);
				sc.ReceivesSave(temp1,Email);

			}
			
			in.close();
			//System.out.println("\n\n\n" + sourceCode);
			Rss_result window = new Rss_result(sourceCode,Email);
			window.getJFrame().setVisible(true);
		}
		catch(MalformedURLException ue){
			System.out.println("Mal formed url : " + ue);
		}
		catch(IOException ioe){
			System.out.println("Wrong : " + ioe);

		}
		catch(Exception m){
			System.out.println("ERROR : " + m);
		}
		finally
		{

		}
		//return sourceCode;

	}

	@Override
	public boolean add(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/*public static void main(String[] args)
	{
		Rss_feed obj = new Rss_feed();
		obj.readRss("World","http://rss.cnn.com/rss/edition_world.rss");
	}*/
}
