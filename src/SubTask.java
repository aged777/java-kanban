public class SubTask extends Task {
    private int epicTaskID;

    public SubTask(EpicTask epicTask, String title, String description, int id) {
        super(title, description, id);
        this.epicTaskID = epicTask.getId();
    }

    public int getEpicTaskID() {
        return epicTaskID;
    }

    @Override
    public String toString() {
        return "Подзадача: " +
                "ID: " + super.getId() +
                ", статус: " + super.getStatus() +
                ",  Заголовок: " + super.getTitle() +
                ", Описание: " + super.getDescription() +
                ", является частью эпик задачи с ID: " + epicTaskID + '\'';
    }
}
