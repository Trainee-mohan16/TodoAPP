import java.util.List;
import java.util.Scanner;

public class TodoApp {
    private static TaskDAO taskDAO = new TaskDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Is the task completed (true/false)? ");
        boolean completed = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        Task task = new Task(0, title, completed);
        taskDAO.addTask(task);
        System.out.println("Task added successfully.");
    }

    private static void viewTasks() {
        List<Task> tasks = taskDAO.getAllTasks();
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private static void updateTask() {
        System.out.print("Enter task ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new task title: ");
        String title = scanner.nextLine();
        System.out.print("Is the task completed (true/false)? ");
        boolean completed = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        taskDAO.updateTask(id, title, completed);
        System.out.println("Task updated successfully.");
    }

    private static void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int id = scanner.nextInt();
        taskDAO.deleteTask(id);
        System.out.println("Task deleted successfully.");
    }
}
