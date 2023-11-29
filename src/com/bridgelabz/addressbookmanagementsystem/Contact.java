package com.bridgelabz.addressbookmanagementsystem;
/*
    @desc : Contact Class
 */
public class Contact {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phoneNumber;
    String email;
    /*
     * @desc : Constructor to create contact
     */
    public Contact(String firstName , String lastName , String address , String city , String state , String zip , String phoneNumber , String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

}
