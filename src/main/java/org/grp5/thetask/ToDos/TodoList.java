package org.grp5.thetask;

import java.util.ArrayList;

public class TodoList {

    private final ArrayList<TodoTask> tasks = new ArrayList<>();
    private final int id;
    private final String title;

    public TodoList(int id, String title) {
        this.id = id;
        this.title = title;
    }


    //Assume we get time in milliSec.
    public void createTodoTask(int id, String title, long timeInMilliSecDeadLine) {
        tasks.add(new TodoTask(id, title, timeInMilliSecDeadLine));
    }

    public TodoTask getTodoTask(int id) {
        for (TodoTask task : tasks)
            if (task.getId() == id)
                return task;
        //If id does not exist, it returns null
        return null;
    }

    public ArrayList<TodoTask> getAllTodoTasks() {
        return tasks;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
}

