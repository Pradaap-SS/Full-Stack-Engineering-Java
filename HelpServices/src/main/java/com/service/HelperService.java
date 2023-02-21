package com.service;

import org.springframework.stereotype.Service;

import com.model.HelperBean;

//use appropriate annotation to configure HelperService as a Service
@Service
public class HelperService {

    // calculate the totalCost and return the cost
    public double calculateTotalCost(HelperBean helperBean) {
        double totalCost = 0;
        if (helperBean.getServiceType().equalsIgnoreCase("ACService")) {

            helperBean.setServiceCostPerHour(400);
            totalCost = helperBean.getNoOfHours() * helperBean.getServiceCostPerHour();

        } else if (helperBean.getServiceType().equalsIgnoreCase("WashingMachineService")) {

            helperBean.setServiceCostPerHour(500);
            totalCost = helperBean.getNoOfHours() * helperBean.getServiceCostPerHour();

        } else if (helperBean.getServiceType().equalsIgnoreCase("RefrigeratorService")) {

            helperBean.setServiceCostPerHour(300);
            totalCost = helperBean.getNoOfHours() * helperBean.getServiceCostPerHour();

        } else {
            return 0;
        }
        return totalCost;

    }

}
