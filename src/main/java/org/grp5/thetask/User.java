package org.grp5.thetask;

import java.util.ArrayList;

import org.grp5.thetask.ToDos.TodoList;

public class User {
    private final String username;
    private final String password;
    private final ArrayList<TodoList> userLists = new ArrayList<>();
    private int lastListId = 0;

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

    public void createTodoList(String title) {
        TodoList todoList = new TodoList(lastListId++, title);
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


    @SuppressWarnings("UnusedReturnValue")
    public boolean addNewTask(String taskTitle, int listId, String deadline) {
        TodoList list = getTodoList(listId);
        if (list != null) {
            long timeInMilliSecDeadline = -1;
            // if input then this:
            if (deadline != null && !deadline.isEmpty())
                timeInMilliSecDeadline = Helper.convertToMilliSeconds(deadline);

            list.createTodoTask(taskTitle, timeInMilliSecDeadline);
            return true;
        }

        // Returns false if task could not be created for some reason
        return false;
    }

    @SuppressWarnings("UnusedReturnValue")
    public boolean deleteTask(int listId, int taskId) {
        TodoList list = getTodoList(listId);
        if (list != null)
            return list.deleteTask(taskId);

        // Returns false if task could not be deleted for some reason
        return false;
    }


}
