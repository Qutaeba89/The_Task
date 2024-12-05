package org.grp5.thetask.ToDos;

import java.util.ArrayList;

public class TodoList {

    private final ArrayList<TodoTask> tasks = new ArrayList<>();
    private final int id;
    private final String title;
    private int lastTaskId = 0;

    // COnstruktor
    public TodoList(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // Create new todo and add to list
    public void createTodoTask(String title, long deadline) {
        tasks.add(new TodoTask(lastTaskId++, title, deadline));
    }

    public boolean deleteTask(int taskId) {
        return tasks.removeIf(task -> task.getTaskId() == taskId);
    }

    //Get specific todo based on id
    public TodoTask getTodoTask(int id) {
        for (TodoTask task : tasks) {
            if (task.getTaskId() == id) {
                return task;
            }
        }
        return null; // if no task is found
    }

    public boolean updateTaskStatus(boolean status, int taskId) {
        TodoTask task = getTodoTask(taskId);
        if (task != null) {
            task.setTaskCompleted(status);
            return true;
        }


        return false;
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
