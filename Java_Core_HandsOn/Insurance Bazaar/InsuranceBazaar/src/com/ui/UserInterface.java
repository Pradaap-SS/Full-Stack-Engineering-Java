package com.ui;
import com.utility.*;
import java.util.*;

public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		
		//Fill the UI code
		System.out.println("Enter the no of Policy names you want to store");
		int n=sc.nextInt();
		sc.nextLine();
		
		Bazaar ob=new Bazaar();
		Map<Integer,String> policyMap=new HashMap<Integer,String>();
		ob.setPolicyMap(policyMap);
		
		for(int i=0;i<n;i++)
		{
		    System.out.println("Enter the Policy ID");
		    int k=sc.nextInt();
		    sc.nextLine();
		    System.out.println("Enter the Policy Name");
		    String name=sc.nextLine();
		    ob.addPolicyDetails(k,name);
		}
	  
	  TreeMap<Integer, String> map = new TreeMap<>(ob.getPolicyMap());

		for (Integer key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
		System.out.println("Enter the policy type to be searched");
		String policy=sc.nextLine();
		
		List<Integer> keys=new ArrayList<>(ob.searchBasedOnPolicyType(policy));
		Collections.sort(keys);
		for(int i: keys)
		System.out.println(i);

	}

}
