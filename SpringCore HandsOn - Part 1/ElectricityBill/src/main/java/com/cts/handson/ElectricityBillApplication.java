package com.cts.handson;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import java.util.List;
import com.cts.handson.dao.EBillDAO;
import com.cts.handson.model.EBill;
import com.cts.handson.util.DateUtil;
@ComponentScan("com.cts.handson")
public class ElectricityBillApplication {
	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
		//get dao bean
		EBillDAO dao = appContext.getBean(EBillDAO.class);
		//delete ebill
		//dao.deleteBill(100,99);
		try {
			dao.deleteBill(100,99);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.format("%-5s %-15s %-10s %10s %5s %s\n", "Id","Consumer Id","Month","Reading","Unit","Amount");
		//display all bills
		
		
		List<EBill> list = dao.getAllBill();
		int i = 0;
		for (EBill e : list) {
			i = i + 1;
			//DateUtil.stringToDate("27/12/2020");
			
			System.out.format("%-5s %-15s %-10s %10s %5s %s\n", i, e.getConsumerId(), DateUtil.dateToString(e.getBillingMonth()), e.getReading(),
					e.getUnit(), e.getAmount());

		}
	}
}
