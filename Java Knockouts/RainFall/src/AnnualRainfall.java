
public class AnnualRainfall {
	
	private int cityPincode;
	private String cityName;
	private double averageAnnualRainfall;

	public int getCityPincode() {
		return cityPincode;
	}

	public void setCityPincode(int cityPincode) {
		this.cityPincode = cityPincode;
	}

	public String getCityName(){
		return cityName;
	}

	public void setCityName(String cityName){
		this.cityName = cityName;
	}


	public double getAverageAnnualRainfall(){
		return averageAnnualRainfall;
	}


	public void setAverageAnnualRainfall(double averageAnnualRainfall){
		this.averageAnnualRainfall = averageAnnualRainfall;
	}

	//Write the required business logic as expected in the question description
	
	//business logic to calculate average annual rainfall
	public void calculateAverageAnnualRainfall (double monthlyRainfall [ ]){
		
		//fill the code
		double sum = 0;
		for(double rainfall : monthlyRainfall) {
			sum = sum + rainfall;
		}
		setAverageAnnualRainfall(sum/12);
	}
	
}
