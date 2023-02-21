import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHandler {
	
	//Write the required business logic as expected in the question description
	
	//business logic to establish connection
	public Connection establishConnection() throws ClassNotFoundException, SQLException {
		
		//fill the code
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
	    }
		return connection;	
	}
}
