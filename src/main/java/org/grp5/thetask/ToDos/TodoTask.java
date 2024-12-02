package org.grp5.thetask.ToDos;

public class TodoTask {
    private final long taskId; 
    private String title;
    private long timeInMilliSecDeadLine;
    private boolean taskStatus = false; // True if the task is completed, false if the task is incomplete.

    public TodoTask(long taskId, String title, long timeInMilliSecDeadLine) {
        this.taskId = taskId;
        this.title = title;
        this.timeInMilliSecDeadLine = timeInMilliSecDeadLine;

    }
    
    public boolean deadlinePassed() {
        return System.currentTimeMillis() > this.timeInMilliSecDeadLine;
    }

    public long getTaskId() {
        return taskId;
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
