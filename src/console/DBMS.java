package console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;


public class DBMS {

	public void insertdata(String name,int speed) throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/typing_records","root","root");
		Statement s = con.createStatement();
		String p = "insert into users(Username,Maxspeed) values(\"";
		s.executeUpdate(p+name+"\","+speed+");");	
		s.close();
	}
	public ArrayList<String> fetchdata() throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/typing_records","root","root");
		Statement s = con.createStatement();
		String p = "SELECT * from users;";
		ResultSet r = s.executeQuery(p);
		ArrayList<String> resultarr = new ArrayList<String>();
		while(r.next())
		{
			resultarr.add(r.getString("Username"));
			resultarr.add(r.getString("Maxspeed"));
		}
		return resultarr;
	}
	
	public void clearDuplicateEntries() throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/typing_records","root","root");
		Statement s = con.createStatement();
		String p = "SELECT Username,COUNT(Username) from users Group by Username having COUNT(Username)>1;";
		s.executeQuery(p);	
		System.out.println("done");
		String p1 = "DELETE e1 FROM users e1, users e2 WHERE e1.Username = e2.Username AND e1.id > e2.id;";
		s.executeUpdate(p1);	
		s.close();
		
	}
	
	DBMS() {
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
    }
	catch(Exception e)
	{
		System.out.println("exception = "+e.getMessage());
	}
	}
}
