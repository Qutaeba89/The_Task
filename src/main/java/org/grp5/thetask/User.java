package org.grp5.thetask;

import java.util.ArrayList;
import org.grp5.thetask.ToDos.TodoList;

public class User {
    private final String username;
    private final String password;
    private final ArrayList<TodoList> userLists = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Returns true if passwordInput(the input from login page) matches
     * the password stored for this user
     * returns false otherwise.
     */
    public boolean isPasswordCorrect(String passwordInput) {
        return password.equals(passwordInput);
    }

    public void createTodoList(int id, String title) {
        TodoList todoList = new TodoList(id, title);
        // adding placeholder task
        todoList.createTodoTask(1, "Exempeluppgift", System.currentTimeMillis() + 10000000);
        userLists.add(todoList);
    }
    

    public ArrayList<TodoList> getAllTodoLists() {
        return userLists;
    }

    public TodoList getTodoList(int listId) {
        for (TodoList list : userLists)
            if (listId == list.getId())
                return list;

        // Returns null if id does not exist
        return null;
    }
    public void deleteTodoList(int listId) {
        userLists.removeIf(list -> list.getId() == listId);
    }
    

}
