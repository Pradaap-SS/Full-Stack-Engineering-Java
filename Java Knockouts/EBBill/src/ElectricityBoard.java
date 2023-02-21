import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
public class ElectricityBoard
{
  
    
    //write the required business logic methods as expected in the question description
    
    public void addBill(List<ElectricityBill> billList)
    {
        //fill your code here
    	
		try {
			DBHandler dbHandler = new DBHandler();
	    	Connection connection = dbHandler.establishConnection();
	    	String query = "insert into ElectricityBill values(?,?,?,?,?)";
			
			for(ElectricityBill bill : billList) {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, bill.getConsumerNumber());
				ps.setString(2, bill.getConsumerName());
				ps.setString(3, bill.getConsumerAddress());
				ps.setInt(4, bill.getUnitsConsumed());
				ps.setDouble(5, bill.getBillAmount());
				ps.executeUpdate();
//				ps.close();
	    	}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    }
    
    public List<ElectricityBill> generateBill(String filePath) 
    {
        //fill your code here
    	List<ElectricityBill> electricityBillList = null; 
		Scanner sc = null;
		try{
			sc = new Scanner(new File(filePath));
			electricityBillList =  new ArrayList<ElectricityBill>();
			
            while (sc.hasNextLine()) {
            	String total = sc.nextLine();
                String[] segments = total.trim().split(",");
                ElectricityBill bill = null;
                try {
                	
                	 if(validate(segments[0])) {
                		 
	            		bill = new ElectricityBill();
	            		bill.setConsumerNumber(segments[0]);
	            		bill.setConsumerName(segments[1]);
	            		bill.setConsumerAddress(segments[2]);
	            		bill.setUnitsConsumed(Integer.parseInt(segments[3]));
                 		bill.calculateBillAmount();
                     	electricityBillList.add(bill);
                     }
                }catch(InvalidConsumerNumberException ex) {
                	ex.printStackTrace();
                }
            }
            
        }
        catch (IOException io){
        	io.printStackTrace();
        }finally {
        	sc.close();
        }
		return electricityBillList;
    }
    public boolean validate(String consumerNumber) throws InvalidConsumerNumberException
	{
    		//fill your code here
	    	boolean valid = consumerNumber.matches("[0]{1}[0-9]{9}");
			if(!valid) {
				throw new InvalidConsumerNumberException("Invalid Consumer Number");
			}
			return valid;

	}

    
}
