// Developer: Chrysanthemum Gribble Gilbert
// Project: Project 1
 package com.grandstrandsystems.project1;

 import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

 public class TaskTest {
        Task control = new Task("Groceries", "You go get them");
        Task defaultTask = new Task();
        Task nullTask = new Task(null, null);
        Task tooLong = new Task(
                "Build a Fence in your Dad's Counsin's Bestfriend's Backyard",
                "Dig a holes with the post hole digger, Drop in posts, Open a new bag of Concrete, Put it in wheelbarrow, Mix with water, Pour slurry into holes, Set the posts plum, Wait to dry, Put up panels between posts, Nail or screw them together."
            );

    @Test
    public void testTaskIdNull() {
        assertTrue(
                control.getId() != null,
                "FAILED: testTaskIdNull() control Task ID null"
                );
        assertTrue(
                nullTask.getId() != null,
                "FAILED: testTaskIdNull() nullTask ID null"
                );
    }

    @Test
    public void testTaskIdUnique() {
        assertTrue(
                !control.getId().equals(defaultTask.getId()),
                "FAILED: testTestIdUnique() id's are the same."
                );
    }

    @Test
    public void testTaskIdLength() {
        assertTrue(
                control.getId().length() <= 10,
                "FAILED: testTaskIdLength() ID too long"
                );
    }

    @Test
    public void testTaskNameNull() {
        assertTrue(
                nullTask.getName() != null,
                "FAILED: testTaskNameNull() Name is null"
                );
    }

    @Test
    public void testTaskNameLength() {
        assertTrue(
                tooLong.getName().length() <= 20,
                "FAILED: testTaskNameNull() Name too long"
                );
    }

    @Test
    public void testTaskDescNull() {
        assertTrue(
                nullTask.getDescription() != null,
                "FAILED: testTaskDescNull() Description is null"
                );
    }
    
    @Test
    public void testTaskDescLength() {
        assertTrue(
                tooLong.getDescription().length() <= 50,
                "FAILED: testTaskDescLength() Description too long"
                );
    }
}
