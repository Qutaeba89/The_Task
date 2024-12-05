package org.grp5.thetask;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

import org.grp5.thetask.ToDos.TodoList;
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


     @Test
     public void testAddTaskIncreasesSize() {
         // Create a new instance of TodoList
         TodoList todoList = new TodoList(1, "Test List");

         // Get initial size, adds a new task to the list and gets the new size
         int initialSize = todoList.getTasks().size();
         todoList.createTodoTask("Test Task", System.currentTimeMillis());
         int newSize = todoList.getTasks().size();

    //  Controls that the initial size has been incremented by 1
        assertEquals(initialSize + 1, newSize);
     }


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

    // @Test
    // public void testIsDeadLineOver() {

    //     long currentTime = System.currentTimeMillis();
    //     long oneHour = 1000 * 60 * 60;
    //     long inFuture = currentTime + oneHour;
    //     long inPast = currentTime - oneHour;

    //     TodoTask task = new TodoTask(0, null, 0);
    //     assertTrue(task.isDeadLinePassed(inPast));
    //     assertFalse(task.isDeadLinePassed(inFuture));
    // }
}
