package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.util.PropertiesUtil;

public class ConnectionHandler {

	private static Connection con = null;
	private static Properties props = new Properties();
	

    
	public static Connection getConnection() {
		
		
	    try{
	    	String basePath = PropertiesUtil.class.getResource("/").getPath();
	    	InputStream in = new FileInputStream(basePath + "connection.properties");
	    	props.load(in);
	    	
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
