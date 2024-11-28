package org.grp5.thetask;

public class TodoTask {
    private boolean taskStatus = false; // true if the task is completed, false if the task is incomplete.
    private String title;
    private long timeInMilliSecDeadLine;

    public TodoTask(String title, long timeInMilliSecDeadLine) {
        this.title = title;
        this.timeInMilliSecDeadLine = timeInMilliSecDeadLine;

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

    public boolean isDeadLinePassed(long timeInMilliSecDeadLine){

        return false;
    }
}
