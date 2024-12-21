// Developer: Chrysanthemum Gribble Gilbert
// Project: Project 1
package com.grandstrandsystems.project1;

import java.util.Date;

public class Appointment {
    private static long Count = 1;
    private Date date;
    private String Id;
    private String description;

    public Appointment() {
        this.setId();
        this.setDate();
        this.setDescription("Description");
    }

    public Appointment(Date date, String description) {
        this.setId();
        this.setDate(date);
        this.setDescription(description);
    }

    public static void resetCount() {
        Appointment.Count = 1;
        System.out.println("Delete before Production");
    }

    private void setId() {
        if (Count > 9999999999L) {
            System.out.println("Error: Too many Appointments. You can't have this many thing on your calendar.");
        }
        else {
            this.Id = String.format("%010d", Appointment.Count);
            Count++;
        }
    }

    public void setDate() {
        Date currentDay = new Date();
        this.setDate(currentDay);
    }

    public void setDate(Date date) {
        if (date == null || date.before(new Date())) {
            this.date = new Date();
        }
        else {
            this.date = date;
        }
    }

    public void setDescription(String taskDescription) {
        if (taskDescription == null) {
            this.description = "Lorem Ipsum";
        }
        else if (taskDescription.length() > 50) {
            this.description = "Too Long";
        }
        else {
            this.description = taskDescription;
        }
    }

    public String getId() {
        return this.Id;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
    }
}
