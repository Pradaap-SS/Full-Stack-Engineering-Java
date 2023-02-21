
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrainManagementSystem {
	
	public ArrayList <Train> viewTrain (String coachType, String source, String destination){
		
		// Fill your code here	
		 ArrayList <Train> trains = new  ArrayList <Train>();
		 try{
		     Connection conn = DB.getConnection();
		     PreparedStatement stmt = conn.prepareStatement("Select * from train where source = ?, destination = ? and ?>0");
		     stmt.setString(1,source);
		     stmt.setString(2,destination);
		     stmt.setString(3,coachType);
		     ResultSet rs = stmt.executeQuery();
		     while(rs.next()) {
		    	 trains.add(new Train(rs.getInt("train_number"),rs.getString("train_name"),rs.getString("source"),rs.getString("destination"),rs.getInt("ac1"),rs.getInt("ac2"),rs.getInt("ac3"),rs.getInt("sleeper"),rs.getInt("seater")));
		     }
		 }
		 catch(ClassNotFoundException| SQLException se){
		     se.printStackTrace();
		 }
		return trains;
		
	}

}
