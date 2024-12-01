import java.util.Objects;

public class Task {

    private final int id;
    private String title;
    private String description;
    private Status status;

    public Task(String title, String description) {
        TaskManager.increaseId();
        this.id = TaskManager.getId();
        this.title = title;
        this.description = description;
        this.status = Status.NEW;
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Task task = (Task) object;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }

    @Override
    public String toString() {
        return "Задача " +
                "ID: " + id +
                ", статус: " + status +
                ",  Заголовок: " + title +
                ", Описание: " + description + '\'';
    }
}
