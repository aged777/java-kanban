import java.util.ArrayList;
import java.util.HashMap;

/**
 * Класс создан для хранения, изменения, получения объектов всех видов задач.
 * Методы класса ничего не должны выводить в консоль или запрашивать что-либо от пользователя, для этого создан класс
 * ConsoleInterface.
 */
public class TaskManager {
    private int id = 0;
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, SubTask> subTasks = new HashMap<>();
    private HashMap<Integer, EpicTask> epicTasks = new HashMap<>();

    // Методы для Task
    public ArrayList<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public void deleteAllTasks() {
        tasks.clear();
    }

    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public void createTask(Task task) {
        task.setId(generateID());
        tasks.put(task.getId(), task);
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void deleteTaskById(int id) {
        tasks.remove(id);
    }

    // Методы для SubTask
    public ArrayList<SubTask> getAllSubTasks() {
        return new ArrayList<>(subTasks.values());
    }

    public void deleteAllSubTasksByEpicID(int id) {
        EpicTask epicTask = getEpicTaskById(id);
        ArrayList<Integer> subTasksID = epicTask.getSubTasksID();
        for (Integer integer : subTasksID) {
            subTasks.remove(integer);
        }
        subTasksID.clear();
        evaluateEpicTaskStatus(epicTask);
    }

    public SubTask getSubTaskById(int id) {
        return subTasks.get(id);
    }

    public ArrayList<SubTask> getEpicIDSubTasks(int id) {
        EpicTask epicTask = getEpicTaskById(id);
        ArrayList<SubTask> result = new ArrayList<>();
        for (int subTaskID : epicTask.getSubTasksID()) {
            result.add(getSubTaskById(subTaskID));
        }
        return result;
    }

    public void createSubTask(SubTask task) {
        task.setId(generateID());
        subTasks.put(task.getId(), task);
        EpicTask epicTask = getEpicTaskById(task.getEpicTaskID());
        epicTask.addSubtaskID(task.getId());
        evaluateEpicTaskStatus(epicTask);
    }

    public void updateSubTask(SubTask task) {
        subTasks.put(task.getId(), task);
        evaluateEpicTaskStatus(getEpicTaskById(task.getEpicTaskID()));
    }

    public void deleteSubTaskById(int id) {
        EpicTask epicTask = this.getEpicTaskById(subTasks.get(id).getEpicTaskID());
        epicTask.removeSubTaskId(id);
        subTasks.remove(id);
        evaluateEpicTaskStatus(epicTask);
    }

    // Методы для EpicTask
    public ArrayList<EpicTask> getAllEpicTasks() {
        return new ArrayList<>(epicTasks.values());
    }

    public void deleteAllEpicTasks() {
        ArrayList<EpicTask> epicTasksCopy = getAllEpicTasks();
        for (EpicTask epicTask : epicTasksCopy) {
            for (int id : epicTask.getSubTasksID()) {
                subTasks.remove(id);
            }
        }

        epicTasks.clear();
    }

    public EpicTask getEpicTaskById(int id) {
        return epicTasks.get(id);
    }

    public void createEpicTask(EpicTask task) {
        task.setId(generateID());
        epicTasks.put(task.getId(), task);
    }

    public void updateEpicTask(EpicTask task) {
        epicTasks.put(task.getId(), task);
        evaluateEpicTaskStatus(task);
    }

    public void deleteEpicTaskById(int id) {
        EpicTask epicToDelete = getEpicTaskById(id);
        for (int subTaskID : epicToDelete.getSubTasksID()) {
            this.subTasks.remove(subTaskID);
        }
        epicTasks.remove(id);
    }

    private void evaluateEpicTaskStatus(EpicTask epicTask) {
        int[] util = new int[2];
        ArrayList<Integer> subTasksID = epicTask.getSubTasksID();
        if (subTasksID == null) {
            epicTask.setStatus(Status.NEW);
            return;
        }
        for (Integer subTaskID : subTasksID) {
            if (this.getSubTaskById(subTaskID).getStatus().equals(Status.NEW)) {
                util[0]++;
            } else if (this.getSubTaskById(subTaskID).getStatus().equals(Status.DONE)) {
                util[1]++;
            }
        }
        if (util[0] == subTasksID.size()) {
            epicTask.setStatus(Status.NEW);
        } else if (util[1] == subTasksID.size()) {
            epicTask.setStatus(Status.DONE);
        } else {
            epicTask.setStatus(Status.IN_PROGRESS);
        }
    }

    private int generateID() {
        return ++id;
    }

}
