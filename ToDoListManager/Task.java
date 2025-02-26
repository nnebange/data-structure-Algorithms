public class Task {
    private String description;
    private boolean isCompleted;
    private Task next;

    public Task(String description) {
        this.description = description.trim();
        if (description.isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty");
        }
        this.isCompleted = false;
        this.next = null;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Task getNext() {
        return next;
    }

    public void setNext(Task next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "[" + (isCompleted ? "Completed" : "Pending") + "] " + description;
    }
}
