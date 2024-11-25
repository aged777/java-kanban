import java.util.ArrayList;

public class EpicTask extends Task {
    private ArrayList<SubTask> subtasks = new ArrayList<>();

    public EpicTask(String title, String description) {
        super(title, description);
    }

    public void addSubTask(SubTask subtask) {
        subtasks.add(subtask);
    }

    public ArrayList<SubTask> getSubtasks() {
        return subtasks;
    }

    @Override
    public String toString() {
        return "EpicTask{" +
                "subtasks=" + subtasks +
                '}' + super.toString();
    }
}
