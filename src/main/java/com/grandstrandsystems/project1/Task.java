// Developer: Chrysanthemum Gribble Gilbert
// Project: Project 1
package com.grandstrandsystems.project1;

public class Task {
    private static long Count = 1;
    private String name;
    private String Id;
    private String description;

    public Task() {
        this.setId();
        this.setName("Task Name");
        this.setDescription("Description");
    }

    public Task(String name, String description) {
        this.setId();
        this.setName(name);
        this.setDescription(description);
    }

    public static void resetCount() {
        Task.Count = 1;
        System.out.println("Delete before Production");
    }

    private void setId() {
        if (Count > 9999999999L) {
            System.out.println("Error: Too Many Tasks, You can't possibly have this much to do.");
        }
        else {
            this.Id = String.format("%010d", Task.Count);
            Count++;
        }
    }

    public void setName(String taskName) {
        if (taskName == null) {
            this.name = "New Task";
        }
        else if (taskName.length() > 20) {
            this.name = "Too Long";
        }
        else {
            this.name = taskName;
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

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}
