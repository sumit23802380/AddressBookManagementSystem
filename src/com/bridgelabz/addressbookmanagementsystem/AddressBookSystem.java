package com.bridgelabz.addressbookmanagementsystem;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Address Book System Class that store multiple address books
 */
public class AddressBookSystem {
    private final int ADD_NEW_ADDRESSBOOK = 1;
    private final int CLOSE_ADDRESS_BOOK_SYSTEM = 0;
    private final int OPEN_EXISTING_ADDRESSBOOK = 2;
    private final HashMap<String , AddressBook> addressBookList;
    private final Scanner scanner;
    /**
     * Address Book System Constructor
     */
    public AddressBookSystem(){
        System.out.println("Welcome to Address Book System");
        scanner = new Scanner(System.in);
        addressBookList = new HashMap<>();
    }

    /**
     * Method to add the new address book to the system
     */
    private void addNewAddressBook(){
        System.out.println("To add the new Address book please enter the name of  address book :");
        String addressBookName = scanner.next();
        if(addressBookList.containsKey(addressBookName)){
            System.out.println("Address book with name " + addressBookName + " exists , please provide new name");
            addNewAddressBook();
        }
        else{
            AddressBook addressBook = new AddressBook();
            addressBook.setName(addressBookName);
            addressBookList.put(addressBookName , addressBook);
            System.out.println("Address Book with name " + addressBookName + " added");
        }
    }

    /**
     * Method to open the address book system
     */
    public void open(){
        System.out.println("Select options : ");
        System.out.println("Press 1 if want to add a new Address Book");
        System.out.println("Press 2 if want to open a existing Address Book");
        System.out.println("Press 0 To exit");
        Scanner sc = new Scanner(System.in);
        int pressedOption = sc.nextInt();
        switch (pressedOption){
            case ADD_NEW_ADDRESSBOOK :
                this.addNewAddressBook();
                break;
            case OPEN_EXISTING_ADDRESSBOOK :
                this.openExistingAddressBook();
                break;
            case CLOSE_ADDRESS_BOOK_SYSTEM:
                return;
            default:
                System.out.println("Please press valid button");
        }
        open();
    }

    /**
     * Method to open existing address book
     */
    private void openExistingAddressBook(){
        System.out.println("Please write the name of address you want to open");
        String nameOfAddressBook = scanner.next();
        if(addressBookList.containsKey(nameOfAddressBook)){
            AddressBook addressBook = addressBookList.get(nameOfAddressBook);
            addressBook.open();
        }
        else{
            System.out.println("Please provide the correct name of the address book");
        }
    }
}
