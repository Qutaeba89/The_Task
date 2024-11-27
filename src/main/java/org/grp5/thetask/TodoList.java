package org.grp5.thetask;

import java.util.ArrayList;

public class TodoList {
    private ArrayList<TodoTask> tasks;

    //Assume we get time in milliSec.
    public void createTodoTask(String title, long timeInMilliSecDeadLine) {
        // tasks.add(new TodoTask(title, timeInMilliSecDeadLine));
    }

    public ArrayList<TodoTask> getTodoTasks(){
        return tasks;
    }


}

