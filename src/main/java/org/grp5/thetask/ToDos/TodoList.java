package org.grp5.thetask.ToDos;

import java.util.ArrayList;

public class TodoList {

    private final ArrayList<TodoTask> tasks = new ArrayList<>();
    private final int id;
    private final String title;

    // COnstruktor
    public TodoList(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // Create new todo and add to list
    public void createTodoTask(long taskId, String title, long deadline) {
        tasks.add(new TodoTask(taskId, title, deadline));
    }

    //Get specific todo based on id
    public TodoTask getTodoTask(int id) {
        for (TodoTask task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null; // if no task is found
    }

    // Return all todotask on todolist
    public ArrayList<TodoTask> getTasks() {
        return tasks;
    }

    // Getters  id and title
    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
}
