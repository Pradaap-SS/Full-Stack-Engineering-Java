import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBHandler {
    
	public Connection establishConnection() 
	{
		Connection connection = null;
		Properties properties = new Properties();
		 try{
			
			FileInputStream fileInputStream = new FileInputStream("db.properties");
			properties.load(fileInputStream);
			Class.forName(properties.getProperty("db.classname"));
			String url = properties.getProperty("db.url");
			String username = properties.getProperty("db.username");
			String password = properties.getProperty("db.password");
			
			connection = DriverManager.getConnection(url, username, password);
			fileInputStream.close();
	    }
	    catch(IOException e){
	    	e.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;		
	}
}
