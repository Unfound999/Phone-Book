// Authors: Christopher Waschke, Jackson Jenks, Brody Weinkauf
// Description: Data Class for entry in phonebook, linking to next entry via reference. (Linked list)

/*
 * Entry Node Class
 * Represents an entry in the phone book.
 * This class holds variables for each field we're holding
 * And then it also holds a "next" variable, for linking to the next Entry in the book.
 */
public class EntryNode {

    // List Properties 
    private int index; // Our index in the list.
    private EntryNode nextEntry; // Our reference to the next entry.

    // Entry Properties
    private String fName;
    private String lName;
    private String address;
    private String phoneNumber;
    private int zipCode;
    private String email;

    /*
     * Constructor Method
     * Initializes the properties for our entry.
     * Sets the nextEntry to null, as this will only be set when another item is added.
     */
    public EntryNode(int index, String fName, String lName, String address, String phoneNumber, int zipCode,
            String email) {
        this.nextEntry = null;
        this.index = index;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
        this.email = email;
    }

    /*
     * int method
     * Returns index of our entry in the list.
     */
    public int getIndex() {
        return index;
    }

    /*
     * void method (setter)
     * Updates the index of entry in the list. Used when shifting index.
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /*
     * EntryNode Method
     * Returns the next Entry in the List. NULL if we're at the end of the list.
     */
    public EntryNode getNextEntry() {
        return nextEntry;
    }

    /*
     * void method (setter)
     * Updates the next property, changing the next value in the list.
     */
    public void setNextEntry(EntryNode nextEntry) {
        this.nextEntry = nextEntry;
    }

    /* 
     * String Method
     * Returns first name of the contact.
     * 
     * Parameters:
     * fName (string) new value for their first name.
     */
    public String getFName() {
        return fName;
    }

    /*
     * void Method (setter)
     * sets first name of the contact.
     */
    public void setFName(String fName) {
        this.fName = fName;
    }

    /* 
     * String Method
     * Returns last name of the contact.
     */
    public String getLName() {
        return lName;
    }

    /*
     * void Method (setter)
     * sets last name of the contact.
     * 
     * Parameters:
     * lName (string) new value for their last name.
     */
    public void setLName(String lName) {
        this.lName = lName;
    }

    /* 
     * String Method
     * Returns the address of the contact.
     */
    public String getAddress() {
        return address;
    }

    /*
     * void Method (setter)
     * sets first name of the contact.
     * 
     * Parameters:
     * address (string) new value for their address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /* 
     * String Method
     * Returns phone number of the contact.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /*
     * void Method (setter)
     * sets phone number of the contact.
     * 
     * Parameters:
     * phoneNumber (string) new value for their phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /* 
     * Int Method
     * Returns the zipcode of the contact.
     */
    public int getZipCode() {
        return zipCode;
    }

    /*
     * void Method (setter)
     * sets zipcode of the contact.
     * Parameters:
     * zipcode (int) new value for their zipcode.
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /* 
     * String Method
     * Returns email of the contact.
     */
    public String getEmail() {
        return email;
    }

    /*
     * void Method (setter)
     * sets email of the contact.
     * 
     * Parameters:
     * email (string) new value for their email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /*
     * String Method
     * Returns a string representation of the current object.
     */
    public String toString(){
        return String.format("Name: %s %s, Email: %s, Phone: %s, Address: %s, Zip: %d", fName, lName, email, phoneNumber, address, zipCode);
    }
}
