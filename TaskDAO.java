import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskDAO {
    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    // Add a new task
    public void addTask(Task task) {
        task.setId(nextId++);
        tasks.add(task);
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    // Update a task
    public void updateTask(int id, String title, boolean completed) {
        Optional<Task> task = tasks.stream().filter(t -> t.getId() == id).findFirst();
        task.ifPresent(t -> {
            t.setTitle(title);
            t.setCompleted(completed);
        });
    }

    // Delete a task
    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }
}
