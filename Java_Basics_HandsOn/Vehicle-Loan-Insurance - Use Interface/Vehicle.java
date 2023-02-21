public class Vehicle implements Loan,Insurance
{
	private String vehicleNumber;
	private String modelName;
	private String vehicleType;
	private double price;
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Vehicle(String vehicleNumber, String modelName, String vehicleType,double price) {
		
		this.vehicleNumber = vehicleNumber;
		this.modelName = modelName;
		this.vehicleType=vehicleType;
		this.price = price;
	}
	
	public double issueLoan()
	{
	    double amount=0;
	    if(vehicleType=="4 wheeler")
	        amount=(double)80/100*price;
	    else if(vehicleType=="3 wheeler")
	        amount=(double)75/100*price;
	    else if(vehicleType=="2 wheeler")
	        amount=(double)50/100*price;
	    return amount;
	}
	
	public double takeInsurance()
	{
	    double insuranceAmount=0;
	    if(price<=150000)
	        insuranceAmount=3500;
	    else if(price>150000 && price<=300000)
	        insuranceAmount=4000;
	    else if(price>300000)
	        insuranceAmount=5000;
	   return insuranceAmount;
	}

}
