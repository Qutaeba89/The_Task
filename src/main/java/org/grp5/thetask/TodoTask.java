package org.grp5.thetask;

public class TodoTask {
    private boolean taskStatus = false; // true if the task is completed, false if the task is incomplete.
    private String title;
    private long timeInMilliSecDeadLine;
    
    public TodoTask(String title, long timeInMilliSecDeadLine) {
        this.title = title;
        this.timeInMilliSecDeadLine = timeInMilliSecDeadLine;

    }
}
