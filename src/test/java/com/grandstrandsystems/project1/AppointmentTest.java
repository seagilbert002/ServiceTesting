// Developer: Chrysanthemum Gribble Gilbert
// Project: Project 1
package com.grandstrandsystems.project1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import java.util.Date;

 public class AppointmentTest {
        Appointment control = new Appointment(new Date(2026, 8, 30), "You go get them");
        Appointment defaultAppointment = new Appointment();
        Appointment nullAppointment = new Appointment(null, null);
        Appointment wrong = new Appointment(
                new Date(2025, 6, 13),
                "Dig a holes with the post hole digger, Drop in posts, Open a new bag of Concrete, Put it in wheelbarrow, Mix with water, Pour slurry into holes, Set the posts plum, Wait to dry, Put up panels between posts, Nail or screw them together."
            );

    @Test
    public void testAppointmentIdNull() {
        assertTrue(
                control.getId() != null,
                "FAILED: testAppointmentIdNull() control Appointment ID null"
                );
        assertTrue(
                nullAppointment.getId() != null,
                "FAILED: testAppointmentIdNull() nullAppointment ID null"
                );
    }

    @Test
    public void testAppointmentIdUnique() {
        assertTrue(
                !control.getId().equals(defaultAppointment.getId()),
                "FAILED: testTestIdUnique() id's are the same."
                );
    }

    @Test
    public void testAppointmentIdLength() {
        assertTrue(
                control.getId().length() <= 10,
                "FAILED: testAppointmentIdLength() ID too long"
                );
    }

    @Test
    public void testAppointmentDateNull() {
        assertTrue(
                nullAppointment.getDate() != null,
                "FAILED: testAppointmentDateNull() Date is null"
                );
    }

    @Test
    public void testAppointmentDateBefore() {
        assertTrue(
                !wrong.getDate().before(new Date()),
                "FAILED: testAppointmentDateBefore() Date is before current date"
                );
    }

    @Test
    public void testAppointmentDescNull() {
        assertTrue(
                nullAppointment.getDescription() != null,
                "FAILED: testAppointmentDescNull() Description is null"
                );
        assertTrue(
                defaultAppointment.getDescription() != null,
                "FAILED: testAppointmentDescNull() Description is null"
                );
    }
    
    @Test
    public void testAppointmentDescLength() {
        assertTrue(
                wrong.getDescription().length() <= 50,
                "FAILED: testAppointmentDescLength() Description too long"
                );
    }
}
