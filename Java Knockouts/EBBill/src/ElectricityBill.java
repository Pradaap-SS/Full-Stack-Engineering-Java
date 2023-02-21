//This is the POJO/model class
public class ElectricityBill
{
    
    private String consumerNumber;
    private String consumerName;
    private String consumerAddress;
    private int unitsConsumed;
    private double billAmount;
    
    
	
    public String getConsumerNumber() {
		return consumerNumber;
	}



	public void setConsumerNumber(String consumerNumber) {
		this.consumerNumber = consumerNumber;
	}



	public String getConsumerName() {
		return consumerName;
	}



	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}



	public String getConsumerAddress() {
		return consumerAddress;
	}



	public void setConsumerAddress(String consumerAddress) {
		this.consumerAddress = consumerAddress;
	}



	public int getUnitsConsumed() {
		return unitsConsumed;
	}



	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}



	public double getBillAmount() {
		return billAmount;
	}



	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}


	//Write the required business logic as expected in the question description
	public void calculateBillAmount()
    {
    	//fill the code here
		double billAmt = 0;
		if(unitsConsumed<=100) {
			billAmt = 0;
		}else if(unitsConsumed>100 && unitsConsumed<=300) {
			billAmt = (unitsConsumed-100)*1.5;
		}else if(unitsConsumed>300 && unitsConsumed<=600) {
			billAmt = ((unitsConsumed-300)*3.5) + (200*1.5);
		}else if(unitsConsumed>600 && unitsConsumed<=1000) {
			billAmt = ((unitsConsumed-600)*5.5) + (200*1.5) + (300*3.5);
		}else if(unitsConsumed>1000)  {
			billAmt = ((unitsConsumed-1000)*7.5) + (200*1.5) + (300*3.5) + (400*5.5);
		}
		setBillAmount(billAmt);
    }
    
    
    
}