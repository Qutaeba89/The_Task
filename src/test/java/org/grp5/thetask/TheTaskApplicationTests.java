package org.grp5.thetask;
import static org.junit.jupiter.api.Assertions.*;


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
    public void testCorrectPasswordLogin() {
        // variables
        String correctUsername = "testUser";
        String correctPassword = "12345";

        // logIn is true by checking username and pw. 
        boolean isLoggedIn = Check.isCorrectLogin(correctUsername, correctPassword);

        // check if inlogg is correct
        assertTrue(isLoggedIn, "Inloggning med rätt användarnamn och lösenord ska lyckas");
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


    @Test
    public void testAddUser() {  // Testing om user already exists
        User user = new User("SS", "WW");
        assertEquals("SS", user.getUsername());
        assertEquals("WW", user.getPassword());
        //Testing add new user
        user.setUsername("rr");
        user.setPassword("22");

        assertEquals("rr", user.getUsername());
        assertEquals("22", user.getPassword());
    }

    @Test
    public void testIsDeadLineOver() {

        long currentTime = System.currentTimeMillis();
        long oneHour = 1000 * 60 * 60;
        long inFuture = currentTime + oneHour;
        long inPast = currentTime - oneHour;

        TodoTask task = new TodoTask(null, 0);
        assertTrue(task.isDeadLinePassed(inPast));
        assertFalse(task.isDeadLinePassed(inFuture));
    }
}
