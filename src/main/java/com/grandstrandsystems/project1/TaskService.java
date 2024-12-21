package com.grandstrandsystems.project1;

import java.util.ArrayList;

public class TaskService {
    ArrayList<Task> tasks = new ArrayList<Task>();

    public TaskService() {}

    public Task findTask(String Id) {
        if (tasks.isEmpty()) {
            return null;
        }
        else {
            for (Task task : tasks) {
                if(task.getId().equals(Id)) {
                    return task;
                }
            }
        }
        return null;
    }

    public void addTask(String name, String description) {
        Task newTask = new Task(name, description);
        tasks.add(newTask);
    }

    public void addTask(Task newTask) {
        tasks.add(newTask);
    }

    public void deleteTask(String Id) {
        Task delTask = findTask(Id);
        if (delTask != null) {
            tasks.remove(tasks.indexOf(delTask));
        }
    }

    public void updateName(String Id, String newName) {
        Task updateTask = findTask(Id);
        if (updateTask != null) {
            updateTask.setName(newName);
        }
    }

    public void updateDescription(String Id, String newDescription) {
        Task updateTask = findTask(Id);
        if(updateTask != null) {
            updateTask.setDescription(newDescription);
        }
    }
}
