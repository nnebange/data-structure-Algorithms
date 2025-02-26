public class TaskList {
    private Task head;
    private Task tail;

    public TaskList() {
        this.head = null;
        this.tail = null;
    }

    public void addTask(Task task) {
        if (head == null) {
            head = task;
            tail = task;
        } else {
            tail.setNext(task);
            tail = task;
        }
    }

    public boolean markTaskAsCompleted(String description) {
        Task current = head;
        while (current != null) {
            if (current.getDescription().equals(description)) {
                current.markAsCompleted();
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void printTasks() {
        Task current = head;
        while (current != null) {
            System.out.println(current.toString());
            current = current.getNext();
        }
    }
}
