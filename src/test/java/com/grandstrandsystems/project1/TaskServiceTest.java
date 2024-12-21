// Developer: Chrysanthemum Gribble Gilbert
// Project: Project 1
package com.grandstrandsystems.project1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class TaskServiceTest {

    TaskService taskList = new TaskService();

    @BeforeEach
    public void TaskServiceSetup() {
        Task.resetCount();
        taskList.addTask("Groceries", "Veggie Burger, Buns, Lettuce");
        taskList.addTask("Lawn", "Trim Hedges, Mow, Edge");
        taskList.addTask("Bathe Cat", "Wrestle Cat, Get Scratched, Give Up");
    }

    @Test
    public void testTaskServiceAdd() {
        Task taskToAdd = new Task("Cook", "Star cooking, Burn it, Order Pizza");
        String idToCheck = taskToAdd.getId();
        taskList.addTask(taskToAdd);

        assertTrue(
                taskToAdd.equals(taskList.findTask(idToCheck)),
                "FAILED: testTaskServiceAdd() taskToAdd not in taskList"
                );
    }

    @Test
    public void testTaskServiceDelete() {
        assertTrue(
                taskList.findTask("0000000001") != null,
                "FAILED: testTaskServiceDelete() Does not exist to delete"
                );

        taskList.deleteTask("0000000001");

        assertTrue(
                taskList.findTask("0000000001") == null,
                "FAILED: testTaskServiceDelete() Task still present in taskList"
                );
    }

    @Test
    public void testTaskServiceUpdateName() {
        String newTaskName = "Leap Forward";
        String idToChange = "0000000002";

        assertTrue(
                taskList.findTask(idToChange) != null,
                "FAILED: testTaskServiceUpdateName() Task to update does not exist"
                );
        assertTrue(
                !taskList.findTask(idToChange).getName().equals(newTaskName),
                "FAILED: testTaskServiceUpdateName() Tasks already have the same name"
                );

        taskList.updateName(idToChange, newTaskName);

        assertTrue(
                taskList.findTask(idToChange).getName().equals(newTaskName),
                "FAILED: testTaskServiceUpdateName() Failed to update the name"
                );
    }

    @Test
    public void testTaskServiceUpdateDescription() {
        String newTaskDescription = "Brains are better for Zombies";
        String idToChange = "0000000002";

        assertTrue(
                taskList.findTask(idToChange) != null,
                "FAILED: testTaskServiceUpdateDescription() Task to update does not exist"
                );
        assertTrue(
                !taskList.findTask(idToChange).getDescription().equals(newTaskDescription),
                "FAILED: testTaskServiceUpdateDescription() Tasks already have the same description"
                );

        taskList.updateDescription(idToChange, newTaskDescription);

        assertTrue(
                taskList.findTask(idToChange).getDescription().equals(newTaskDescription),
                "FAILED: testTaskServiceUpdateDescription() Failed to update the description"
                );
    }
}
