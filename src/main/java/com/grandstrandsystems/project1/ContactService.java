// Developer: Chrysanthemum Gribble Gilbert
// Project: Project 1
package com.grandstrandsystems.project1;

import java.util.ArrayList;

class ContactService {
    ArrayList<Contact> contacts = new ArrayList<Contact>();

    public ContactService() {}

    public Contact findContact(String Id) {
        if (contacts.isEmpty()) {
            return null;
        }
        else {
            for (Contact contact : contacts) {
                if (contact.getId().equals(Id)) {
                    return contact;
                }
            }
        }
        return null;
    }

    public void addContact(String firstName, String lastName, String number, String address) {
        Contact newContact = new Contact(firstName, lastName, number, address);
        contacts.add(newContact);
    }

    public void addContact(Contact newContact) {
        contacts.add(newContact);
    }

    public void deleteContact(String Id) {
        Contact delContact = findContact(Id);
        if (delContact != null) {
            contacts.remove(contacts.indexOf(delContact));
        }
    }

    public void updateFirstName(String Id, String newFirstName) {
        Contact updateContact = findContact(Id);
        if (updateContact != null) {
            updateContact.setFirstName(newFirstName);
        }
    }
    
    public void updateLastName(String Id, String newLastName) {
        Contact updateContact = findContact(Id);
        if (updateContact != null) {
            updateContact.setLastName(newLastName);
        }
    }

    public void updateNumber(String Id, String newNumber) {
        Contact updateContact = findContact(Id);
        if (updateContact != null) {
            updateContact.setNumber(newNumber);
        }
    }

    public void updateAddress(String Id, String newAddress) {
        Contact updateContact = findContact(Id);
        if (updateContact != null) {
            updateContact.setAddress(newAddress);
        }
    }
}
