package org.grp5.thetask.ToDos;

public class TodoTask {
    private final long taskId;
    private String title;
    private long timeInMilliSecDeadLine;
    private boolean taskCompleted;

    public TodoTask(long taskId, String title, long timeInMilliSecDeadLine) {
        this.taskId = taskId;
        this.title = title;
        this.timeInMilliSecDeadLine = timeInMilliSecDeadLine;

    }

    public boolean isDeadlinePassed() {
        // checking for No deadline, so it's not considered overdue
        if (timeInMilliSecDeadLine == -1) {
            return false;
        }
        return System.currentTimeMillis() > timeInMilliSecDeadLine;
    }

    public long getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTaskCompleted(boolean taskCompleted) {
        this.taskCompleted = taskCompleted;
    }

    public boolean isTaskCompleted() {
        return taskCompleted;
    }

    public long getTimeInMilliSecDeadLine() {
        return timeInMilliSecDeadLine;
    }
}
