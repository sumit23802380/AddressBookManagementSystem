package com.bridgelabz.addressbookmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

/*
    @desc : Address Book Class
 */
public class AddressBook {
    ArrayList<Contact> contactList;
    /*
        @desc : Constructor of AddressBook Class
     */
    public AddressBook(){
        this.contactList = new ArrayList<>();
    }
    public void addContact(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Name");
        String firstName = sc.next();
        System.out.println("Enter Last Name");
        String lastName = sc.next();
        System.out.println("Enter Address");
        String address = sc.next();
        System.out.println("Enter City");
        String city = sc.next();
        System.out.println("Enter State");
        String state = sc.next();
        System.out.println("Enter zipCode");
        String zip = sc.next();
        System.out.println("Enter Phone Number");
        String phoneNumber = sc.next();
        System.out.println("Enter Email");
        String email = sc.next();
        Contact contact = new Contact(firstName , lastName , address , city , state , zip , phoneNumber , email);
        contactList.add(contact);
    }
}
