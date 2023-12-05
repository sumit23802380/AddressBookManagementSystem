package com.bridgelabz.addressbookmanagementsystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Address Book Class
 */
public class AddressBook {
    private final AddressBookSystem addressBookSystem;
    private static final int ADD_CONTACT=1;
    private static final int EDIT_CONTACT=2;
    private static final int CLOSE_ADDRESS_BOOK =0;
    private static final int DELETE_CONTACT=3;
    private static final int SORT_CONTACTS_BY_NAME = 4;
    private static final int SORT_CONTACTS_BY_STATE = 5;
    private static final int SORT_CONTACTS_BY_ZIP = 6;
    private static final int PRINT_ADDRESS_BOOK = 7;
    // Adds multiple person contact to the address book
    List<Contact> contactList;

    private final Scanner scanner;
    private String name;
    /**
     * Constructor of AddressBook Class
     */
    public AddressBook(AddressBookSystem addressBookSystem){
        this.addressBookSystem = addressBookSystem;
        this.contactList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Method to get the name of the address book
     * @return name of the address book
     */
    public String getName(){
        return this.name;
    }

    /**
     * Method to set the name of the address book
     * @param name
     * name of the address book
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Method to open the address book , can add , edit , delete and close the address book
     */
    public void open(){
        System.out.println("Select options : ");
        System.out.println("Press 1 if want to add a new contact");
        System.out.println("Press 2 if you want to edit an existing contact");
        System.out.println("Press 3 if you want to delete an existing contact");
        System.out.println("Press 4 if you want to sort contacts by name");
        System.out.println("Press 5 if you want to sort contacts by state");
        System.out.println("Press 6 if you want to sort contacts by zip code");
        System.out.println("Press 7 if you want to print address book");
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
            case DELETE_CONTACT:
                this.deleteContact();
                break;
            case SORT_CONTACTS_BY_NAME:
                this.sortContactsByName();
                break;
            case PRINT_ADDRESS_BOOK:
                this.printAddressBook();
                break;
            case SORT_CONTACTS_BY_STATE:
                this.sortContactsByState();
                break;
            case SORT_CONTACTS_BY_ZIP:
                this.sortContactsByZip();
                break;
            case CLOSE_ADDRESS_BOOK:
                return;
            default:
                System.out.println("Please press valid button");
        }
        open();
    }

    private void sortContactsByZip() {
        contactList = contactList.stream()
                .sorted(Comparator.comparing(Contact::getZip))
                .collect(Collectors.toList());
    }

    private void sortContactsByState() {
        contactList = contactList.stream()
                .sorted(Comparator.comparing(Contact::getState))
                .collect(Collectors.toList());
    }

    private void sortContactsByName() {
        contactList = contactList.stream()
                .sorted(Comparator.comparing(Contact::getFirstName).thenComparing(Contact::getLastName))
                .collect(Collectors.toList());
    }

    private void printAddressBook() {
        System.out.println(this.toString());
    }
    /**
     * Method to add the new contact to the contact list if by name it doesn't exists already in contactList
     */
    private void addContact(){
        System.out.println("Please provide all the details to add a new Contact:");
        System.out.println("Enter First Name");
        String firstName = scanner.next();
        System.out.println("Enter Last Name");
        String lastName = scanner.next();
        System.out.println("Enter Address");
        String address = scanner.next();
        System.out.println("Enter City");
        String city = scanner.next();
        System.out.println("Enter State");
        String state = scanner.next();
        System.out.println("Enter zipCode");
        String zip = scanner.next();
        System.out.println("Enter Phone Number");
        String phoneNumber = scanner.next();
        System.out.println("Enter Email");
        String email = scanner.next();
        // Uses Java Stream to check if find any match
        if(contactList.stream().anyMatch(contact -> contact.equals(new Contact(firstName,lastName , address , city , state , zip , phoneNumber , email)))){
            System.out.println("Already present , please add new contact or edit the existing contact");
            return;
        }
        Contact contact = new Contact(firstName , lastName , address , city , state , zip , phoneNumber , email);
        contactList.add(contact);
        addContactToAddressBookFile(contact);
        addressBookSystem.addContactByCity(contact.getCity() , contact);
        addressBookSystem.addContactByState(contact.getState() , contact);

        System.out.println("New contact is Added.");
    }

    private void addContactToAddressBookFile(Contact contact) {
        String directoryPath =  "AddressBookSystem/" + this.name;
        String fileName = contact.getFirstName() + contact.getLastName();
        String content = contact.toString();
        Path directory = Path.of(directoryPath);
        Path filePath = directory.resolve(fileName);
        try {
            Files.createFile(filePath);
            Files.writeString(filePath, content, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            System.out.println("Directory and file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to find the index of the contact in contact list using firstname and lastname
     * @param firstName
     *        FirstName in the contact List
     * @param lastName
     *        LastName in the contact List
     * @return  index of the contact
     */
    private int findIndexOfContactByName(String firstName , String lastName){
        for(int i=0;i<contactList.size();i++){
            Contact contact = contactList.get(i);
            if(contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Method to edit the existing contact
     */
    private void editContact(){
        System.out.println("Edit the contact");
        System.out.println("Enter existing First Name");
        System.out.println("Enter existing Last Name");
        String firstNameEntered = scanner.next();
        String lastNameEntered = scanner.next();
        int contactIndex = findIndexOfContactByName(firstNameEntered, lastNameEntered);
        if(contactIndex!=-1){
            System.out.println("Contact found! Enter new details:");
            System.out.println("Enter New First Name:");
            String newFirstName = scanner.next();
            System.out.println("Enter New Last Name:");
            String newLastName = scanner.next();
            System.out.println("Enter New Address:");
            String newAddress = scanner.next();
            System.out.println("Enter New City:");
            String newCity = scanner.next();
            System.out.println("Enter New State:");
            String newState = scanner.next();
            System.out.println("Enter New zipCode:");
            String newZip = scanner.next();
            System.out.println("Enter New Phone Number:");
            String newPhoneNumber = scanner.next();
            System.out.println("Enter New Email:");
            String newEmail = scanner.next();
            Contact editedContact = new Contact(newFirstName, newLastName, newAddress, newCity, newState, newZip, newPhoneNumber, newEmail);
            contactList.set(contactIndex, editedContact);
            System.out.println("Your contact is updated , Thanks");
        }
        else{
            System.out.println("Contact with given name is not found");
        }
    }

    /**
     * Method to delete the contact by name
     */
    private void deleteContact(){
        System.out.println("Delete the contact");
        System.out.println("Enter existing First Name");
        System.out.println("Enter existing Last Name");
        String firstNameEntered = scanner.next();
        String lastNameEntered = scanner.next();
        int contactIndex = findIndexOfContactByName(firstNameEntered, lastNameEntered);
        if(contactIndex!=-1){
            contactList.remove(contactIndex);
            System.out.println("Contact is Deleted , Thanks");
        }
        else{
            System.out.println("Contact with given name is not found");
        }
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Contact contact : contactList) {
            result.append(contact.toString()).append("\n");
        }
        return result.toString();
    }
}
