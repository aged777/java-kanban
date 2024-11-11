import java.util.Objects;

public class SubTask extends Task {
    private int epicTaskID;
    public SubTask(EpicTask epicTask) {
        super(epicTask.getTitle(), epicTask.getDescription());
        this.epicTaskID = epicTask.getId();
        epicTask.addSubTask(this);
    }

    public int getEpicTaskID() {
        return epicTaskID;
    }


    @Override
    public String toString() {
        return "SubTask{" +
                "epicTask=" + epicTaskID +
                '}' + super.toString();
    }
}
