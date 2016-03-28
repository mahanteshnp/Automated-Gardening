package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;





public class DataStore {
	
	
	static Connection con= null;


	
	 public static Connection createConnection(String URL, String Username , String Password)
	  {
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  
		  
		try {
			con = DriverManager.getConnection(  URL , Username ,Password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		   
		
		   
		
    return con;
	  }
	}

