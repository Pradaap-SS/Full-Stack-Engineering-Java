package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {

	private static Connection con = null;
	private static Properties props = new Properties();
	

    
	public static Connection getConnection() {
		
		
	    try{
			// /com/cognizant/truYum/config.properties
	    	//props.load(ConnectionHandler.class.getResourceAsStream("config.properties")); 
	    	FileInputStream fis = new FileInputStream("connection.properties");
			props.load(fis);
			
			// load the Driver Class
			Class.forName(props.getProperty("DB_DRIVER_CLASS"));

			// create the connection 
            con = DriverManager.getConnection(props.getProperty("DB_URL"),props.getProperty("DB_USERNAME"),props.getProperty("DB_PASSWORD"));
	    }
	    catch(IOException e){
	        e.printStackTrace();
	    }
	    catch(ClassNotFoundException e){
	        e.printStackTrace();
	    }
	    catch(SQLException e){
	        e.printStackTrace();
	    }
	    
	    // return the connection
		return con;	
	}
}
