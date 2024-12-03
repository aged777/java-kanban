import java.util.ArrayList;

public class EpicTask extends Task {

    private ArrayList<Integer> subTasksID = new ArrayList<>();

    public EpicTask(String title, String description, int id) {
        super(title, description, id);
    }

    public ArrayList<Integer> getSubTasksID() {
        return subTasksID;
    }

    public void removeSubTaskId(Integer id) {
        subTasksID.remove(id);
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
