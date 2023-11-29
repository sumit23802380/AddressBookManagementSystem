package com.bridgelabz.addressbookmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

/*
    @desc : Address Book Class
 */
public class AddressBook {
    private static final int ADD_CONTACT=1;
    private static final int EDIT_CONTACT=2;
    private static final int CLOSE_ADDRESS_BOOK =0;
    ArrayList<Contact> contactList;
    /*
        @desc : Constructor of AddressBook Class
     */
    public AddressBook(){
        this.contactList = new ArrayList<>();
    }
    public void open(){
        System.out.println("Select options : ");
        System.out.println("Press 1 if want to add a new contact");
        System.out.println("Press 2 if you want to edit an existing contact");
        System.out.println("Press 0 To exit");
        Scanner sc = new Scanner(System.in);
        int pressedOption = sc.nextInt();
        switch (pressedOption){
            case ADD_CONTACT :
                this.addContact();
                break;
            case EDIT_CONTACT:
                this.editContact();
                break;
            case CLOSE_ADDRESS_BOOK:
                return;
            default:
                System.out.println("Please press valid button");
        }
        open();
    }
    private void addContact(){
        System.out.println("Please provide all the details to add a new Contact:");
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
    private void editContact(){
        System.out.println("Edit the contact");
        System.out.println("Enter existing First Name");
        System.out.println("Enter existing Last Name");
    }
}
