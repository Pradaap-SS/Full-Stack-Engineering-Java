package com.cts.engineAnalysis;

public class DieselEngine extends Engine {

	
	@Override
	public int getPerformance() {
		// TODO Auto-generated method stub
		int horsepower=getTorque()*getRpm()/63025;
		return horsepower;
	}



	// Type your code here
	

}
