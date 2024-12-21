// Developer: Chrysanthemum Gribble Gilbert
// Project: Project 1
package com.grandstrandsystems.project1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ContactServiceTest {

    ContactService testContacts = new ContactService();
    @BeforeEach
    public void contactServiceSetup() {

        Contact.resetCounter();
        testContacts.addContact(
                "Chrysa", 
                "Gilbert", 
                "8175818775", 
                "1001 E. University Ave."
                );
        testContacts.addContact(
                "Morgan",
                "Gribble",
                "6823438763",
                "2450 Sunset Blvd."
                );
        testContacts.addContact(
                "Legato",
                "Gribble",
                "5128738989",
                "103 Mabel Ln."
                );
    }
    
    // Test for adding a contact
    // Which is funny becuase setting up the test I had to use it
    @Test
    public void testAddContact() {
        Contact newContact = new Contact(
                "Tacitus", 
                "Gilbert", 
                "4057838763", 
                "1001 E. University Ave."
                );
        String id = newContact.getId();

        testContacts.addContact(newContact);

        assertTrue(testContacts.findContact(id).equals(newContact));
    }

    // Test for deleting a Contact
    @Test
    public void testDeleteContact() {
        String idToDelete = "0000000002";

        assertTrue(testContacts.findContact(idToDelete) != null);

        testContacts.deleteContact(idToDelete);

        assertTrue(testContacts.findContact(idToDelete) == null);
    }

    // Test for updating firstName
    @Test
    public void testUpdateFirstName() {
        String newFirstName = "Yi";
        String idToUpdate = "0000000002";

        assertTrue(!testContacts.findContact(idToUpdate).getFirstName().equals(newFirstName));

        testContacts.updateFirstName(idToUpdate, newFirstName);
        
        assertTrue(testContacts.findContact(idToUpdate).getFirstName().equals(newFirstName));
    }

    // Test for updating lastName 
    @Test
    public void testUpdateLastName() {
        String newLastName = "Zhang";
        String idToUpdate = "0000000002";

        assertTrue(!testContacts.findContact(idToUpdate).getLastName().equals(newLastName));

        testContacts.updateLastName(idToUpdate, newLastName);
        
        assertTrue(testContacts.findContact(idToUpdate).getLastName().equals(newLastName));
    }

    // Test for updating Number 
    @Test
    public void testUpdateNumber() {
        String newNumber = "2544448123";
        String idToUpdate = "0000000002";

        assertTrue(!testContacts.findContact(idToUpdate).getNumber().equals(newNumber));

        testContacts.updateNumber(idToUpdate, newNumber);
        
        assertTrue(testContacts.findContact(idToUpdate).getNumber().equals(newNumber));
    }

    // Test for updating Address 
    @Test
    public void testUpdateAddress() {
        String newAddress = "2889 Oak Ridge Ct.";
        String idToUpdate = "0000000002";

        assertTrue(!testContacts.findContact(idToUpdate).getAddress().equals(newAddress));

        testContacts.updateAddress(idToUpdate, newAddress);
        
        assertTrue(testContacts.findContact(idToUpdate).getAddress().equals(newAddress));
    }

}
