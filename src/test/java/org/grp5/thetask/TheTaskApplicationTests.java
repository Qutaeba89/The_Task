package org.grp5.thetask;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TheTaskApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testAddTaskIncreasesSize() {
        // Adds an empty list for new tasks
        List<Object> tasks = new ArrayList<>(); 
    
        // Adds a new task to the list
        int initialSize = tasks.size(); // Gets the initial size of tasks list
        tasks.add(new Object()); // A new task is added to the list
        int newSize = tasks.size(); // Get the new size of tasks list
    
        // Controls that the initial size has been incremented by 1
        assertEquals(initialSize + 1, newSize);
    }

}
