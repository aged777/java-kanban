import java.util.HashMap;

public class TaskManager {
    private static int id = 0;
    private static HashMap<Integer, Task> tasks = new HashMap<>();
    private static HashMap<Integer, SubTask> subTasks = new HashMap<>();
    private static HashMap<Integer, EpicTask> epicTasks = new HashMap<>();

    public static void increaseId() {
        id++;
    }

    public static int getId() {
        return id;
    }

    // Методы для Task
    public HashMap<Integer, Task> getAllTasks() {
        return tasks;
    }

    public void deleteAllTasks() {
        tasks.clear();
        System.out.println("Все задачи успешно удалены.");
    }

    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public void createTask(Task task) {
        tasks.put(task.getId() - 1, task);
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
        System.out.println("Задача с id " + task.getId() + " успешно обновлена.");
    }

    public void deleteTaskById(int id) {
        tasks.remove(id);
        System.out.println("Задача с id " + id + " успешно удалена.");
    }

    // Методы для SubTask
    public HashMap<Integer, SubTask> getAllSubTasks() {
        return subTasks;
    }

    public void deleteAllSubTasks() {
        subTasks.clear();
        System.out.println("Все подзадачи успешно удалены.");
    }

    public SubTask getSubTaskById(int id) {
        return subTasks.get(id);
    }

    public void createSubTask(SubTask task) {
        subTasks.put(task.getId(), task);
    }

    public void updateSubTask(SubTask task) {
        subTasks.put(task.getId(), task);
        System.out.println("Подзадача с id " + task.getId() + " успешно обновлена.");
    }

    public void deleteSubTaskById(int id) {
        subTasks.remove(id);
        System.out.println("Подзадача с id " + id + " успешно удалена.");
    }

    // Методы для EpicTask
    public HashMap<Integer, EpicTask> getAllEpicTasks() {
        return epicTasks;
    }

    public void deleteAllEpicTasks() {
        epicTasks.clear();
        System.out.println("Все эпик задачи успешно удалены.");
    }

    public EpicTask getEpicTaskById(int id) {
        return epicTasks.get(id);
    }

    public void createEpicTask(EpicTask task) {
        epicTasks.put(task.getId(), task);
    }

    public void updateEpicTask(EpicTask task) {
        epicTasks.put(task.getId(), task);
        System.out.println("Эпик задача с id " + task.getId() + " успешно обновлена.");
    }

    public void deleteEpicTaskById(int id) {
        epicTasks.remove(id);
        System.out.println("Эпик задача с id " + id + " успешно удалена.");
    }

    public HashMap<Integer, SubTask> getAllEpicTaskSubTasks(EpicTask epicTask) {
        HashMap<Integer, SubTask> result = new HashMap<>();
        for (SubTask subTask : subTasks.values()) {
            if (subTask.getEpicTaskID() == epicTask.getId()) {
                result.put(subTask.getId(), subTask);
            }
        }
        return result;
    }
}
