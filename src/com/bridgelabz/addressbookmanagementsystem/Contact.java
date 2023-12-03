package com.bridgelabz.addressbookmanagementsystem;

/**
 * Contact Class
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

    /**
     * Constructor to create the contact
     * @param firstName
     * first name of the contact
     * @param lastName
     * last name of the contact
     * @param address
     * address of the contact
     * @param city
     * city of the contact
     * @param state
     * state of the contact
     * @param zip
     * zipcode of the contact
     * @param phoneNumber
     * phone number of the contact
     * @param email
     * email of the contact
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

    /**
     * Method to get the firstname of the contact
     * @return firstname of the contact
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * Method to get the lastname of the contact
     * @return lastname of the contact
     */
    public String getLastName(){
        return this.lastName;
    }
}