package com.somniatores.lesson4;

/**
 * Created by locisvv on 24.10.2016.
 */

public class Task {
    private long id;
    private String task;
    private boolean isDone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(int done) {
        isDone = done == 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task1 = (Task) o;

        if (id != task1.id) return false;
        if (isDone != task1.isDone) return false;
        return task != null ? task.equals(task1.task) : task1.task == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (task != null ? task.hashCode() : 0);
        result = 31 * result + (isDone ? 1 : 0);
        return result;
    }
}
