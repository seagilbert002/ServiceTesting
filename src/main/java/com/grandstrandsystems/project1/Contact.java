// Developer: Chrysanthemum Gribble Gilbert
// Project: Project 1
package com.grandstrandsystems.project1;

public class Contact {
    private String firstName;
    private String lastName;
    private String Number;
    private String Address;
    private String Id;
    private static long Count = 1;

    public Contact () {
        this.setId();
        this.setFirstName("first name");
        this.setLastName("last name");
        this.setNumber("0000000000");
        this.setAddress("address");
    }
    
    public Contact (String firstName, String lastName, String Number, String Address) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setNumber(Number);
        this.setAddress(Address);
        this.setId();
    } 

    public static void resetCounter() {
        Contact.Count = 1;
        System.out.println("Delete before production");
    }
    
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getNumber() {
        return this.Number;
    }

    public String getAddress() {
        return this.Address;
    }

    public String getId() {
        return this.Id;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            this.firstName = "name empty";
        }
        else if (firstName.length() > 10) {
            this.firstName = "too long";
        }
        else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            this.lastName = "name empty";
        }
        else if (lastName.length() > 10) {
            this.lastName = "too long";
        }
        else {
            this.lastName = lastName;
        }
    }

    public void setNumber(String Number) {
        if (Number == null) {
            this.Number = "0000000000";
        }
        else if (Number.length() != 10) {
            this.Number = "0000000000";
        }
        else {
            this.Number = Number;
        } 
    }

    public void setAddress(String Address) {
        if (Address == null) {
            this.Address = "Address empty";
        }
        else if (Address.length() > 30) {
            this.Address = "Address too long.";
        }
        else {
            this.Address = Address;
        }
    }

    private void setId() {
        if (Count > 9999999999L)
        {
            System.out.println("Error: Contacts Full, How do you know so many people?!?");
            return;
        }
        else {
            this.Id = String.format("%010d", Contact.Count);
            Count++;
        }
    }
}
