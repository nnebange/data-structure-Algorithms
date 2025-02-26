import java.util.Scanner;

public class Main {
    private static User[] users = new User[10];
    private static int userCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- To-Do List Manager ---");
            System.out.println("1. Create User");
            System.out.println("2. Add Task to User");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View User Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    createUser();
                    break;
                case 2:
                    addTaskToUser();
                    break;
                case 3:
                    markTaskAsCompleted();
                    break;
                case 4:
                    viewUserTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private static void createUser() {
        if (userCount < users.length) {
            System.out.print("Enter user name: ");
            String userName = scanner.nextLine();
            users[userCount] = new User(userName);
            userCount++;
            System.out.println("User created successfully!");
        } else {
            System.out.println("Maximum number of users reached. Cannot create more users.");
        }
    }

    private static void addTaskToUser() {
        if (userCount > 0) {
            System.out.println("Select a user:");
            for (int i = 0; i < userCount; i++) {
                System.out.println((i + 1) + ". " + users[i].getName());
            }
            System.out.print("Enter user number: ");
            int userNumber = scanner.nextInt();
            scanner.nextLine();

            if (userNumber > 0 && userNumber <= userCount) {
                System.out.print("Enter task description: ");
                String taskDescription = scanner.nextLine();
                users[userNumber - 1].addTask(new Task(taskDescription));
                System.out.println("Task added successfully!");
            } else {
                System.out.println("Invalid user number.");
            }
        } else {
            System.out.println("No users in the system. Please create a user first.");
        }
    }

    private static void markTaskAsCompleted() {
        if (userCount > 0) {
            System.out.println("Select a user:");
            for (int i = 0; i < userCount; i++) {
                System.out.println((i + 1) + ". " + users[i].getName());
            }
            System.out.print("Enter user number: ");
            int userNumber = scanner.nextInt();
            scanner.nextLine();

            if (userNumber > 0 && userNumber <= userCount) {
                users[userNumber - 1].printTasks();
                System.out.print("Enter task description to mark as completed: ");
                String taskDescription = scanner.nextLine();
                if (users[userNumber - 1].markTaskAsCompleted(taskDescription)) {
                    System.out.println("Task marked as completed successfully!");
                } else {
                    System.out.println("Task not found.");
                }
            } else {
                System.out.println("Invalid user number.");
            }
        } else {
            System.out.println("No users in the system. Please create a user first.");
        }
    }

    private static void viewUserTasks() {
        if (userCount > 0) {
            System.out.println("Select a user:");
            for (int i = 0; i < userCount; i++) {
                System.out.println((i + 1) + ". " + users[i].getName());
            }
            System.out.print("Enter user number: ");
            int userNumber = scanner.nextInt();
            scanner.nextLine();

            if (userNumber > 0 && userNumber <= userCount) {
                users[userNumber - 1].printTasks();
            } else {
                System.out.println("Invalid user number.");
            }
        } else {
            System.out.println("No users in the system. Please create a user first.");
        }
    }
}
