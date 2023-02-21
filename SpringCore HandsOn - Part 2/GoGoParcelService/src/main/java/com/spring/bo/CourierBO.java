package com.spring.bo;

import java.util.Map;

import com.spring.model.Courier;

public class CourierBO {

	public double calculateCourierCharge(Courier cObj, String city) {

		double courierCharge = 0.0;
		Map<String, Float> map = cObj.getServiceCharge().getLocationServiceCharge();
		// fill the code
		courierCharge = cObj.getWeight() * cObj.getChargePerKg();
		if (map.containsKey(city)) {
			courierCharge = courierCharge + cObj.getServiceCharge().getLocationServiceCharge().get(city);
		}

		return courierCharge;
	}

}
