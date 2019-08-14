package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectivity 
{
	static Connection con=null;
	
	public static Connection getConnection() throws SQLException, InstantiationException, IllegalAccessException
	{
		try 
		{
	        Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineExamSystem", "root", "test");
			//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineExamSystem?useSSL=false","newuser","aditi0111");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeConnection() throws SQLException
	{
		try
		{
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}