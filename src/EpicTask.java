import java.util.ArrayList;

public class EpicTask extends Task {

    private ArrayList<Integer> subTasksID = new ArrayList<>();

    public EpicTask(String title, String description) {
        super(title, description);
    }

    public void addSubTask(SubTask subtask) {
        subTasksID.add(subtask.getId());
    }

    public ArrayList<Integer> getAllSubtasksID() {
        return subTasksID;
    }

    @Override
    public String toString() {
        return "EpicTask{" +
                "subtasks=" + TaskManager.getAllSubTasks().toString() +
                '}' + super.toString();
    }

}
