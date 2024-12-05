package org.grp5.thetask;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

import org.grp5.thetask.ToDos.TodoTask;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TheTaskApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testCorrectPasswordLogin() {
        //variables
        String correctUsername = "admin";
        String correctPassword = "admin";

        // logIn is true by checking username and pw using method from "Check".
        boolean isLoggedIn = Check.isLoginCredentialsCorrect(correctUsername, correctPassword);

        // check if inlogg is correct
        assertTrue(isLoggedIn, "Inloggning med rätt användarnamn och lösenord ska lyckas");
    }


    // @Test
    // public void testAddTaskIncreasesSize() {
    //     // Adds an empty list for new tasks
    //     TodoList newList = new TodoList();

    //     // Adds a new task to the list
    //     int initialSize = newList.getTodoTasks().size(); // Gets the initial size of tasks list
    //     newList.createTodoTask(null, 0); // A new task is added to the list
    //     int newSize = newList.getTodoTasks().size(); // Get the new size of tasks list

    //     // Controls that the initial size has been incremented by 1
    //     assertEquals(initialSize + 1, newSize);
    // }


    // @Test
    // public void testAddUser() {  // Testing om user already exists
    //     User user = new User("SS", "WW");
    //     assertEquals("SS", user.getUsername());
    //     assertEquals("WW", user.getPassword());
    //     //Testing add new user
    //     user.setUsername("rr");
    //     user.setPassword("22");

    //     assertEquals("rr", user.getUsername());
    //     assertEquals("22", user.getPassword());
    // }

    @Test
    public void testIsDeadLineOver() {

        long currentTime = System.currentTimeMillis();
        long oneHour = 1000 * 60 * 60;
        long inFuture = currentTime + oneHour;
        long inPast = currentTime - oneHour;

        TodoTask taskInFuture = new TodoTask(0, null, inFuture);
        TodoTask taskInPast = new TodoTask(0, null, inPast);

        assertFalse(taskInFuture.isDeadlinePassed());
        assertTrue(taskInPast.isDeadlinePassed());
    }
}
