// Developer: Chrysanthemum Gribble Gilbert
// Project: Project 1
package com.grandstrandsystems.project1;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ContactTest {
    Contact testContactDefault = new Contact();
    Contact testContactFull = new Contact("Legato", "Gribble", "5554446666", "1234 Gato Lane");
    Contact testContactWrong = new Contact("Chrysanthemum", "Gribble-Gilbert", "01234567890123", "12334458850043 Orange Grove Circle Lane, New Bostonian, Masssachusettes New York Texas, 7800002814980234984759879238402");
    Contact testContactNull = new Contact(null, null, null, null);

    @Test
    public void testContactIdNull() {
        assertTrue(
                testContactDefault.getId() != null, 
                "FAILED: testContactIdNull for testContactDefault"
            );

        assertTrue(
                testContactFull.getId() != null,
                "FAILED: testContactIdNull for testContactFull"
            );
    }

    // Test to check for a properly formatted Id
    @Test
    public void testContactIdLength() {

        assertTrue(
                testContactDefault.getId().length() > 0 && testContactDefault.getId().length() <= 10, 
                "FAILED: testContactIdLength()" 
            );
    }
    
    // Test to check for Id uniqueness
    @Test
    public void testContactUnique() {
        assertTrue(
                !testContactFull.getId().equals(testContactDefault.getId()),
                "FAILED: testContactUnique()"
            );
    }

    // Test to check Id is unmodifiable
    @Test
    public void testContactIdImmutable() {
        assertThrows(
                NoSuchMethodException.class,
                () -> {
                    testContactDefault.getClass().getMethod("setId").invoke(testContactDefault);
                },
                "FAILED: testContactImmutable"
            );
    }

    // Test to check that the first name is not null
    @Test
    public void testContactFirstNameNull() {
        assertTrue(
                testContactNull.getFirstName() != null,
                "FAILED: testContactFirstNameNull"
                );

    }

    // Test to check that the firstName cannot be longer than 10 characters
    @Test 
    public void testContactFirstNameLength() {
        assertTrue(
                testContactWrong.getFirstName().length() <= 10,
                "FAILED: testContactFirstNameLength"
                );
    }

    // Test to check for last name not null
    @Test
    public void testContactLastNameNull() {
        assertTrue(
                testContactNull.getLastName() != null,
                "FAILED: testContactLastNameNull"
                );

    }

    // Test to check that the firstName cannot be longer than 10 characters
    @Test 
    public void testContactLastNameLength() {
        assertTrue(
                testContactWrong.getLastName().length() <= 10,
                "FAILED: testContactLastNameLength"
                );
    }
    
    // Test that Number is not null
    @Test
    public void testContactNumberNull() {
        assertTrue(
                testContactNull.getNumber() != null,
                "FAILED: testContactNumberNull()"
                );
    }

    // Test that Number is exactly 10 digits
    @Test
    public void testContactNumberLength() {
        assertTrue(
                testContactWrong.getNumber().length() == 10,
                "FAILED: testContactNumberLength()"
                );
    }        

    // Test that the address is not null
    @Test
    public void testContactAddressNull() {
        assertTrue(
                testContactNull.getAddress() != null,
                "FAILED: testContactAddressNull()"
                );
    }

    // Test that checks the address length is less than 30
    @Test
    public void testContactAddressLength() {
        assertTrue(
                testContactWrong.getAddress().length() <= 30,
                "FAILED: testContactAddressLength()"
                );
    }
}
