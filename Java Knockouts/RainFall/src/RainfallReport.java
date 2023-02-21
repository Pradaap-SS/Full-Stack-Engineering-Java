import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RainfallReport {

	//Write the required business logic as expected in the question description
	
	//business logic to generate rainfall report
	public List<AnnualRainfall> generateRainfallReport(String filePath) {
	    
		//fill the code
		List<AnnualRainfall> annualRainfallList = null;
		Scanner sc = null;
		try{
			sc = new Scanner(new File(filePath));
			annualRainfallList =  new ArrayList<AnnualRainfall>();
			
            while (sc.hasNextLine()) {
            	String total = sc.nextLine();
                String[] segments = total.trim().split(",");
                AnnualRainfall annual = null;
                try {
                	
                	 if(validate(segments[0])) {
                		 
                     	annual = new AnnualRainfall();
                     	annual.setCityName(segments[1]);
                     	annual.setCityPincode(Integer.parseInt(segments[0]));
                     	double[] monthlyRainfall = new double[segments.length-2];
                     	
                     	for(int i = 2; i<segments.length; i++) {
                         	double rainfallStats = Double.parseDouble(segments[i]);
                         	monthlyRainfall[i-2] = rainfallStats;
                         }
                     	annual.calculateAverageAnnualRainfall(monthlyRainfall);
                     	annualRainfallList.add(annual);
                     }
                }catch(InvalidCityPincodeException ex) {
                	ex.printStackTrace();
                }
            }
            
        }
        catch (IOException io){
        	io.printStackTrace();
        }finally {
        	sc.close();
        }
		return annualRainfallList;
	}
	
	//business logic to find maximum rainfall cities
	public List<AnnualRainfall>  findMaximumRainfallCities() {
	
		//fill the code
		List<AnnualRainfall> fullList = new ArrayList<>();
		List<AnnualRainfall> filteredList = new ArrayList<>();
		double max = -1;
		DBHandler dbHandler = new DBHandler();
		try {
			
			Connection connection = dbHandler.establishConnection();
			String query = "select * from AnnualRainfall";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				AnnualRainfall annualRainfall = new AnnualRainfall();
				annualRainfall.setCityPincode(resultSet.getInt(1));
				annualRainfall.setCityName(resultSet.getString(2));
				annualRainfall.setAverageAnnualRainfall(resultSet.getDouble(3));
				fullList.add(annualRainfall);
			}
			
			String query2 = "select * from AnnualRainfall where average_annual_rainfall= (Select max(average_annual_rainfall) from AnnualRainfall)";
			PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
			ResultSet resultSet2 = preparedStatement2.executeQuery();
			while(resultSet2.next())
			{
			max=resultSet2.getDouble(3);
			}
			
			/*
			 * if(!fullList.isEmpty()) { for(AnnualRainfall ar : fullList) { if(max == -1) {
			 * max = ar.getAverageAnnualRainfall(); }else { if(max <
			 * ar.getAverageAnnualRainfall()) { max = ar.getAverageAnnualRainfall(); }else {
			 * continue; } } } }
			 */
			
			
			for(AnnualRainfall annualRainfall : fullList) {
				
				if(annualRainfall.getAverageAnnualRainfall() == max) {
					
					filteredList.add(annualRainfall);
				}
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filteredList;
	}

	
	//business logic to validate city pincodes
	public boolean validate(String cityPincode) throws InvalidCityPincodeException {
		
		//fill the code
		boolean valid = cityPincode.matches("[0-9]{5}");
		if(!valid) {
			throw new InvalidCityPincodeException("Invalid City Pincode");
		}
		return valid;
	}
	
}
