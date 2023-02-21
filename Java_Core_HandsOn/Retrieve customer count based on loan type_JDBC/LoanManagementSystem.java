import java.util.*;
import java.io.*;
import java.sql.*;
public class LoanManagementSystem {

	public int  viewLoanCountBasedOnType (String loanType){
		int count=-1;
		
		// Fill your code here	
		
		Connection conn=null;
		try{
		    //1. connection
		    conn = DB.getConnection();
		
		    String sql = "select * from loan where loanType=?";
			
			PreparedStatement p = conn.prepareStatement(sql);
    		
    		p.setString(1,loanType);
    		
    		ResultSet rs = p.executeQuery();
    		
    		
    		
    		while(rs.next()){
    		    Loan tObj = new Loan(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getFloat(6));
    		    count +=1;
    		}
    		
			
    		rs.close();
    		p.close();
		}
		catch(Exception e){
		    e.printStackTrace();
		}
		
		return count;
	}
}