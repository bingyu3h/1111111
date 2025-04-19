public class Task {
    private int id;
    private String description;
    private boolean status;  // true = 完成，false = 待办
    private String createdAt;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = false;
        this.createdAt = java.time.LocalDate.now().toString();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void markAsCompleted() {
        this.status = true;
    }

    public void updateDescription(String description) {
        this.description = description;
    }
}
