// Developer: Chrysanthemum Gribble Gilbert
// Project: Project 1
package com.grandstrandsystems.project1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Date;

public class AppointmentServiceTest {

    AppointmentService appointmentList = new AppointmentService();

    @BeforeEach
    public void AppointmentServiceSetup() {
        Appointment.resetCount();
        appointmentList.addAppointment(new Date(2926, 8, 25), "Meet Charlie");
        appointmentList.addAppointment(new Date(2092, 7, 4), "Be Alive");
        appointmentList.addAppointment(new Date(2099, 12, 31), "See a turn of the century");
    }

    @Test
    public void testAppointmentServiceAdd() {
        Appointment appointmentToAdd = new Appointment(new Date(2042,5,13), "50th Birthday");
        String idToCheck = appointmentToAdd.getId();
        appointmentList.addAppointment(appointmentToAdd);

        assertTrue(
                appointmentToAdd.equals(appointmentList.findAppointment(idToCheck)),
                "FAILED: testAppointmentServiceAdd() appointmentToAdd not in appointmentList"
                );
    }

    @Test
    public void testAppointmentServiceDelete() {
        assertTrue(
                appointmentList.findAppointment("0000000001") != null,
                "FAILED: testAppointmentServiceDelete() Does not exist to delete"
                );

        appointmentList.deleteAppointment("0000000001");

        assertTrue(
                appointmentList.findAppointment("0000000001") == null,
                "FAILED: testAppointmentServiceDelete() Appointment still present in appointmentList"
                );
    }

    @Test
    public void testAppointmentServiceUpdateDate() {
        Date newAppointmentDate = new Date(2035,4,25);
        String idToChange = "0000000002";

        assertTrue(
                appointmentList.findAppointment(idToChange) != null,
                "FAILED: testAppointmentServiceUpdateDate() Appointment to update does not exist"
                );
        assertTrue(
                !appointmentList.findAppointment(idToChange).getDate().equals(newAppointmentDate),
                "FAILED: testAppointmentServiceUpdateDate() Appointments already have the same date"
                );

        appointmentList.updateDate(idToChange, newAppointmentDate);

        assertTrue(
                appointmentList.findAppointment(idToChange).getDate().equals(newAppointmentDate),
                "FAILED: testAppointmentServiceUpdateDate() Failed to update the date"
                );
    }

    @Test
    public void testAppointmentServiceUpdateDescription() {
        String newAppointmentDescription = "Whoa you made it dude";
        String idToChange = "0000000002";

        assertTrue(
                appointmentList.findAppointment(idToChange) != null,
                "FAILED: testAppointmentServiceUpdateDescription() Appointment to update does not exist"
                );
        assertTrue(
                !appointmentList.findAppointment(idToChange).getDescription().equals(newAppointmentDescription),
                "FAILED: testAppointmentServiceUpdateDescription() Appointments already have the same description"
                );

        appointmentList.updateDescription(idToChange, newAppointmentDescription);

        assertTrue(
                appointmentList.findAppointment(idToChange).getDescription().equals(newAppointmentDescription),
                "FAILED: testAppointmentServiceUpdateDescription() Failed to update the description"
                );
    }
}
