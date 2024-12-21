// Developer: Chrysanthemum Gribble Gilbert
// Project: Project 1
package com.grandstrandsystems.project1;

import java.util.ArrayList;
import java.util.Date;

class AppointmentService {
    ArrayList<Appointment> appointments = new ArrayList<Appointment>();

    public AppointmentService() {}

    public Appointment findAppointment(String Id) {
        if (appointments.isEmpty()) {
            return null;
        }
        else {
            for (Appointment appointment : appointments) {
                if (appointment.getId().equals(Id)) {
                    return appointment;
                }
            }
        }
        return null;
    }

    public void addAppointment(Date date, String description) {
        Appointment newAppointment = new Appointment(date, description);
        appointments.add(newAppointment);
    }

    public void addAppointment(Appointment newAppointment) {
        appointments.add(newAppointment);
    }

    public void deleteAppointment(String Id) {
        Appointment delAppointment = findAppointment(Id);
        if (delAppointment != null) {
            appointments.remove(appointments.indexOf(delAppointment));
        }
    }

    public void updateDate(String Id, Date newDate) {
        Appointment updateAppointment = findAppointment(Id);
        if (updateAppointment != null) {
            updateAppointment.setDate(newDate);
        }
    }
    
    public void updateDescription(String Id, String description) {
        Appointment updateAppointment = findAppointment(Id);
        if (updateAppointment != null) {
            updateAppointment.setDescription(description);
        }
    }
}
