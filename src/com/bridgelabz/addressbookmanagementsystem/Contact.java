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

    /**
     * Method Overrides the equal method of object and checks whether the contact and the object passed is same or not
     * @param obj
     * Object obj that is passed to check whether this is same as Contact same or not
     * @return the object that passed and current this Contact is same or not
     */
    @Override
    public boolean equals(Object obj){
        if(obj == null || this.getClass()!=obj.getClass()){
            return false;
        }
        Contact contact = (Contact) obj;
        return this.firstName.equalsIgnoreCase(contact.firstName)
                && lastName.equalsIgnoreCase(contact.lastName)
                && this.address.equalsIgnoreCase(contact.address)
                && this.state.equalsIgnoreCase(contact.state)
                && this.city.equalsIgnoreCase(contact.city)
                && this.zip.equalsIgnoreCase(contact.zip)
                && this.phoneNumber.equals(contact.phoneNumber)
                && this.email.equals(contact.email);
    }

    /**
     * Method to get the city
     * @return city
     * city of the contact
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Method to get the address
     * @return address
     * address of the contact
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Method to get the state
     * @return state
     * state of the contact
     */
    public String getState() {
        return this.state;
    }

    /**
     * Method to get the zip
     * @return zip
     * zip of the contact
     */
    public String getZip() {
        return this.zip;
    }
    /**
     * Method to get the phoneNumber
     * @return phoneNumber
     * phoneNumber of the contact
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Method to get the email
     * @return email
     * email of the contact
     */
    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString(){
        return "firstName=" + this.firstName + " " +
                "lastName=" + this.lastName + " " +
                "address=" + this.address + " " +
                "state=" + this.state + " " +
                "city=" + this.city + " " +
                "zip=" + this.zip + " " +
                "phoneNumber=" + this.phoneNumber + " " +
                "email=" + this.email;
    }
}