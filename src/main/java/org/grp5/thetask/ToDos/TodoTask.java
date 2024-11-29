package org.grp5.thetask.ToDos;

public class TodoTask {
    private final long id; // Unique ID for a task.
    private String title;
    private long timeInMilliSecDeadLine;
    private boolean taskStatus = false; // True if the task is completed, false if the task is incomplete.

    public TodoTask(long id, String title, long timeInMilliSecDeadLine) {
        this.id = id;
        this.title = title;
        this.timeInMilliSecDeadLine = timeInMilliSecDeadLine;

    }
    
    public boolean isDeadLinePassed(long timeInMilliSecDeadLine){

        return false;
    }

    public long getId() {
        return id;
    }

    public boolean isTaskStatus() {
        return taskStatus;
    }

    public String getTitle() {
        return title;
    }

    public long getTimeInMilliSecDeadLine() {
        return timeInMilliSecDeadLine;
    }
}
