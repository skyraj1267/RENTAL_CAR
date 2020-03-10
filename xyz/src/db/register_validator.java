package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class register_validator 
{	
	public static Connection getConnection() throws Exception{
	
		Connection con;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/rentalcar","root","root");
		return con;	
	}	
}