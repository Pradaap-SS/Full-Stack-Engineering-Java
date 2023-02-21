//import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

public class Main {
   
   public static void main(String[] args)throws Exception {
	  
	   Scanner sc=new Scanner(System.in);
	   //fill your code here
	   ElectricityBoard eb=new ElectricityBoard();
	   List<ElectricityBill> billList =  eb.generateBill("ElectricityBill.txt");
	   for(ElectricityBill e: billList)
		   System.out.println(e.getConsumerNumber()+" "+e.getConsumerName()+" "+e.getConsumerAddress()+" "+e.getUnitsConsumed()+" "+e.getBillAmount());
	   eb.addBill(billList);
	   
	   DBHandler dbHandler = new DBHandler();
			Connection connection = dbHandler.establishConnection();
			String query = "select * from ElectricityBill";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println();
				System.out.print(resultSet.getString(1)+" ");
				System.out.print(resultSet.getString(2)+" ");
				System.out.print(resultSet.getString(3)+" ");
				System.out.print(resultSet.getInt(4)+" ");
				System.out.print(resultSet.getDouble(5));
			}
			connection.close();
	   sc.close();
   }
}
          