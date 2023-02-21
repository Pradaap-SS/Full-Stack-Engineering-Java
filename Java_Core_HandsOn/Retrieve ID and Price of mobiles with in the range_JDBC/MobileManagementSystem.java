
import java.util.Map;
import java.util.*;
import java.io.*;
import java.sql.*;
public class MobileManagementSystem {
	
    public Map<Integer, Integer> viewMobileWithInTheRange(int minRange,int maxRange){
		
		Map<Integer, Integer>  mobileMap = new LinkedHashMap<Integer, Integer>();
		
		// Fill your code here
		Connection conn=null;
		try{
		    
		    conn = DB.getConnection();
		    
		    String sql = "select * from mobile where price between ? and ?";
		    
		    PreparedStatement p = conn.prepareStatement(sql);
    		
    		p.setInt(1,minRange);
    		p.setInt(2,maxRange);
    		
    		ResultSet rs = p.executeQuery();
    		while(rs.next()){
    		    Mobile mObj = new Mobile(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(3));
    		    mobileMap.put(mObj.getProductId(),mObj.getPrice());
    		}
    		
    		rs.close();
    		p.close();
		}
		catch(Exception e){
		    e.printStackTrace();
		}
		
		
		
		
		return mobileMap;
		
	}

}
