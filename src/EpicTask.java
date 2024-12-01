import java.util.ArrayList;

public class EpicTask extends Task {

    private ArrayList<Integer> subTasksID = new ArrayList<>();

    public EpicTask(String title, String description) {
        super(title, description);
    }

    public void addSubTask(SubTask subtask) {
        subTasksID.add(subtask.getId());
        evaluateEpicTaskStatus();
    }

    public void evaluateEpicTaskStatus() {
        int[] util = new int[2];
        for (Integer subTaskID : subTasksID) {
            if (TaskManager.getSubTaskById(subTaskID).getStatus().equals(Status.NEW)) {
                util[0]++;
            } else if (TaskManager.getSubTaskById(subTaskID).getStatus().equals(Status.DONE)) {
                util[1]++;
            }
        }
        if (util[0] == subTasksID.size()) {
            this.setStatus(Status.NEW);
        } else if (util[1] == subTasksID.size()) {
            this.setStatus(Status.DONE);
        } else {
            this.setStatus(Status.IN_PROGRESS);
        }
    }

    @Override
    public String toString() {
        return "Эпик задача: " +
                "ID: " + super.getId() +
                ", статус: " + super.getStatus() +
                ",  Заголовок: " + super.getTitle() +
                ", Описание: " + super.getDescription() + '\'';
    }

}
