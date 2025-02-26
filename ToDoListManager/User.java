public class User {
    private String name;
    private TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public void addTask(Task task) {
        taskList.addTask(task);
    }

    public boolean markTaskAsCompleted(String description) {
        return taskList.markTaskAsCompleted(description);
    }

    public void printTasks() {
        System.out.println("Tasks for " + name + ":");
        taskList.printTasks();
        System.out.println();
    }

    public String getName() {
        return name;
    }
}
