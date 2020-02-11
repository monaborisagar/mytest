package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class utility {
	public static Connection getConnection(){ 
		Connection con=null;  
	 try{

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	//	System.out.println("database initalized");
		 con=DriverManager.getConnection( "jdbc:sqlserver://100.111.111.42:1433;databaseName=test;user=test;password=test"); 
		//System.out.println("database connected");
			
		
	}catch(Exception e)
	{System.out.print("fgfeb trhbtr");

}
	return con;

	}}
    
  