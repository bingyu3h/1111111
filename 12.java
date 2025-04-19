import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> taskList;

    public TaskManager() {
        this.taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void removeTask(int taskId) {
        taskList.removeIf(task -> task.getId() == taskId);
    }

    public Task getTaskById(int taskId) {
        for (Task task : taskList) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null; // 如果没有找到任务
    }

    public List<Task> getAllTasks() {
        return taskList;
    }

    public void updateTaskDescription(int taskId, String newDescription) {
        Task task = getTaskById(taskId);
        if (task != null) {
            task.updateDescription(newDescription);
        }
    }
}
