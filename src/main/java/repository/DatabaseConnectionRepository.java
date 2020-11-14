package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionRepository {

	//this method user for connect to the mysql databse...
	
	public static Connection getConnection()
	{
		Connection con=null;
	
		String url="jdbc:mysql://localhost:3306/world";
    	String username="root";
    	String password="Mauli@1997";
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
    	} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	 
    	 
		return con;
	}
}
