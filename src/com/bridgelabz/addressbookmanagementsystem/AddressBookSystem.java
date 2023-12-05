package com.bridgelabz.addressbookmanagementsystem;

import java.util.*;

/**
 * Address Book System Class that store multiple address books
 */
public class AddressBookSystem {
    private static final int SEARCH_PERSON_BY_STATE = 4;
    private static final int CLOSE_ADDRESS_BOOK_SYSTEM = 0;
    private static final int ADD_NEW_ADDRESSBOOK = 1;
    private static final int OPEN_EXISTING_ADDRESSBOOK = 2;
    private static final int SEARCH_PERSON_BY_CITY = 3;
    private final Map<String , AddressBook> addressBookList;
    private final Map<String , List<Contact>> cityContactList;
    private final Map<String , List<Contact>> stateContactList;
    private final Scanner scanner;
    /**
     * Address Book System Constructor
     */
    public AddressBookSystem(){
        System.out.println("Welcome to Address Book System");
        this.scanner = new Scanner(System.in);
        this.addressBookList = new HashMap<>();
        this.cityContactList = new HashMap<>();
        this.stateContactList = new HashMap<>();
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
            AddressBook addressBook = new AddressBook(this);
            addressBook.setName(addressBookName);
            addressBookList.put(addressBookName , addressBook);
            System.out.println("Address Book with name " + addressBookName + " added");
        }
    }

    /**
     * Method to search all the contacts across all the address books by city
     */
    private void searchPersonAcrossAddressBooksByCity() {
        System.out.println("Enter the city to search:");
        String city = scanner.next();
        if(cityContactList.containsKey(city)){
            System.out.println("Search results:");
            cityContactList.get(city).forEach(this::displayContactDetails);
        }
        else{
            System.out.println("No contacts are found by this city :" + city);
        }
    }

    /**
     * Method to search all the contacts across all the address books by state
     */
    private void searchPersonAcrossAddressBooksByState() {
        System.out.println("Enter the State to search :");
        String state = scanner.next();
        if(stateContactList.containsKey(state)){
            System.out.println("Search results :");
            stateContactList.get(state).forEach(this::displayContactDetails);
        }
        else{
            System.out.println("No contacts are found by this state :" + state);
        }
    }


    /**
     * Method to print the display contact details
     * @param contact
     */
    private void displayContactDetails(Contact contact) {
        System.out.println("First Name: " + contact.getFirstName());
        System.out.println("Last Name: " + contact.getLastName());
        System.out.println("Address: " + contact.getAddress());
        System.out.println("City: " + contact.getCity());
        System.out.println("State: " + contact.getState());
        System.out.println("Zip: " + contact.getZip());
        System.out.println("Phone Number: " + contact.getPhoneNumber());
        System.out.println("Email: " + contact.getEmail());
        System.out.println("---------------------------");
    }
    /**
     * Method to open the address book system
     */
    public void open(){
        System.out.println("Select options : ");
        System.out.println("Press 1 if want to add a new Address Book");
        System.out.println("Press 2 if want to open a existing Address Book");
        System.out.println("Press 3 if want to search the contact by City");
        System.out.println("Press 4 if want to search the contact by State");
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
            case SEARCH_PERSON_BY_CITY:
                this.searchPersonAcrossAddressBooksByCity();
                break;
            case SEARCH_PERSON_BY_STATE:
                this.searchPersonAcrossAddressBooksByState();
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

    /**
     * Method to add contact by city in hashmap
     * @param cityName
     * @param contact
     */
    public void addContactByCity(String cityName , Contact contact){
        if(!cityContactList.containsKey(cityName)){
            cityContactList.put(cityName , new ArrayList<>());
        }
        cityContactList.get(cityName).add(contact);
    }

    /**
     * Method to add contact by state in hashmap
     * @param stateName
     * @param contact
     */
    public void addContactByState(String stateName , Contact contact){
        if(!stateContactList.containsKey(stateName)){
            stateContactList.put(stateName , new ArrayList<>());
        }
        stateContactList.get(stateName).add(contact);
    }
}
