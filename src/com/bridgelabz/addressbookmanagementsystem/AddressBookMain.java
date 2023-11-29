package com.bridgelabz.addressbookmanagementsystem;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");
        AddressBook addressBook = new AddressBook();
        addressBook.takeContactInput();
    }
}