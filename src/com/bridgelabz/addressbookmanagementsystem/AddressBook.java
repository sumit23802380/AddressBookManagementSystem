package com.bridgelabz.addressbookmanagementsystem;

import java.util.ArrayList;
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
    public void addContact(Contact contact){
        this.contactList.add(contact);
    }
}
