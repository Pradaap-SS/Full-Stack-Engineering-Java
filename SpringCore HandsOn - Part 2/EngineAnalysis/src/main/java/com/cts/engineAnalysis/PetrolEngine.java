package com.cts.engineAnalysis;

public class PetrolEngine extends Engine {


	@Override
	public int getPerformance() {
		// TODO Auto-generated method stub
		int horsepower=getTorque()*getRpm()/5252;
		return horsepower;
	}

// Type your code here
	
	

}
