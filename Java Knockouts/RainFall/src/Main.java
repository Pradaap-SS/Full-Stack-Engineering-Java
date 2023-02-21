import java.util.*;
public class Main {
   public static void main(String[] args) throws Exception { 
	   
	   //to check the functionality
	   RainfallReport rainfallReport = new RainfallReport();
	   rainfallReport.generateRainfallReport("AllCityMonthlyRainfall.txt");
	   List<AnnualRainfall> annualRainfallList = rainfallReport.findMaximumRainfallCities();
	   for(AnnualRainfall annualRainfall : annualRainfallList) {
		   System.out.println(annualRainfall.getCityName()+" "+annualRainfall.getAverageAnnualRainfall());
	   }
   }
}
          