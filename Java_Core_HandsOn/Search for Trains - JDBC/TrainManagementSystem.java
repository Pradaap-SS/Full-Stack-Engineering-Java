
import java.util.ArrayList;
import java.sql.*;
import java.io.*;

public class TrainManagementSystem {
	
	public ArrayList <Train> viewTrain (String coachType, String source, String destination){
		
		// Fill your code here	
		
		ArrayList<Train> trainList=new ArrayList<Train>();
		Connection conn=null;
		
		try{
		    //1. connection
		    conn = DB.getConnection();

    		//2. sql query -> 
    		// select * from train
    		// where source=? and destination=? and coachType>0
    		
    		String sql = "";
    		if(coachType.equalsIgnoreCase("AC1")){
    		    sql = "select * from train where source=? and destination=? and ac1>0";
    		}
    		else if(coachType.equalsIgnoreCase("AC2")){
    		    sql = "select * from train where source=? and destination=? and ac2>0";
    		}
    		else if(coachType.equalsIgnoreCase("AC3")){
    		    sql = "select * from train where source=? and destination=? and ac3>0";
    		}
    		else if(coachType.equalsIgnoreCase("Sleeper")){
    		    sql = "select * from train where source=? and destination=? and sleeper>0";
    		}
    		else if(coachType.equalsIgnoreCase("Seater")){
    		    sql = "select * from train where source=? and destination=? and seater>0";
    		}
    		
    		//3. prepared statement
    		PreparedStatement p = conn.prepareStatement(sql);
    		
    		p.setString(1,source);
    		p.setString(2,destination);
    		
    		ResultSet rs = p.executeQuery();
    		while(rs.next()){
    		    Train tObj = new Train(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9));
    		    
    		    trainList.add(tObj);
    		}
    		
    		rs.close();
    		p.close();
		}
		catch(Exception e){
		    e.printStackTrace();
		}
		
		return trainList;
		
	}

}
