package com.spring.app;

public class Address {
    private String houseName;
    private String street;
    private String city;
    private String state;
    
    public void sethouseName(String houseName){
        this.houseName=houseName;
    }
    
    public String gethouseName(){
        return houseName;
    }
    
    public void setstreet(String street){
        this.street=street;
    }
    
    public String getstreet(){
        return street;
    }
    
    public void setcity(String city){
this.city=city;
    }
    
    public String getcity(){
        return city;
    }
    
    public void setstate(String state){
        this.state=state;
    }
	
	public String getstate(){
	    return state;
	}

}