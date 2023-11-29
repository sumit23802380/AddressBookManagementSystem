package com.bridgelabz.addressbookmanagementsystem;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");
        AddressBook addressBook = new AddressBook();
        Contact contact = new Contact("Sumit" , "Jangid" , "Heerapura" , "Jaipur" , "Rajasthan" , "302021" , "9876543210" , "sumit@gmail.com");
    }
}