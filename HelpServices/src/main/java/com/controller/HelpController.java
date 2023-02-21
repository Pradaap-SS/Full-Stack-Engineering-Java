package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.HelperBean;
import com.service.HelperService;

//use appropriate annotation to configure HelpController as Controller
@Controller
public class HelpController {
    
    @Autowired
    private HelperService helpService;

    // invoke the service class - calculateTotalCost method.
    @RequestMapping(value = "/helpDesk", method = RequestMethod.POST)
    public String calculateTotalCost(@ModelAttribute("helper") HelperBean helperBean, ModelMap model) {
        model.addAttribute("totalCost", helpService.calculateTotalCost(helperBean));
        return "helpdesk";

    }
    
    
    @RequestMapping(value = "/showPage", method = RequestMethod.GET )
    public String showPage(@ModelAttribute("helper") HelperBean helperBean) {
        
        return "showpage";
    }
    
    @ModelAttribute("serviceList")
    public Map<String, String> buildState(){
        Map<String, String> serviceList = new HashMap<>();
        serviceList.put("ACService", "ACService");
        serviceList.put("RefrigeratorService", "RefrigeratorService");
        serviceList.put("WashingMachineService", "WashingMachineService");
        return serviceList;
    }

}
