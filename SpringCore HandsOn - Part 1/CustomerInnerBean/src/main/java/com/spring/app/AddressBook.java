package com.spring.app;

public class AddressBook {
    private String phoneNumber;
    private Address tempAddress;
    
    public AddressBook(Address tempAddress){
        this.tempAddress=tempAddress;
    }
    
    public void setphoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    
    public String getphoneNumber(){
        return phoneNumber;
    }
    
    public void settempAddress(Address tempAddress){
        this.tempAddress=tempAddress;
    }
    
    public Address gettempAddress(){
        return tempAddress;
}
}