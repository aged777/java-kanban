import java.util.HashMap;

/**
 * Класс создан для хранения, изменения, получения объектов всех видов задач.
 * Методы класса ничего не должны выводить в консоль или запрашивать что-либо от пользователя, для этого создан класс
 * ConsoleInterface.
 */
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
    public static HashMap<Integer, Task> getAllTasks() {
        return tasks;
    }

    public static void deleteAllTasks() {
        tasks.clear();
    }

    public static Task getTaskById(int id) {
        return tasks.get(id);
    }

    public static void createTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public static void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public static void deleteTaskById(int id) {
        tasks.remove(id);
    }

    // Методы для SubTask
    public static HashMap<Integer, SubTask> getAllSubTasks() {
        return subTasks;
    }

    public static void deleteAllSubTasks() {
        subTasks.clear();
    }

    public static void deleteEpicIDSubTasks(int id) {
        for (SubTask subTask : TaskManager.getAllSubTasks().values()) {
            if (subTask.getEpicTaskID() == id) {
                TaskManager.deleteSubTaskById(subTask.getId());
            }
        }
    }

    public static HashMap<Integer, SubTask> getEpicIDSubTasks(int id) {
        HashMap<Integer, SubTask> result = new HashMap<>();
        for (SubTask subTask : TaskManager.getAllSubTasks().values()) {
            if (subTask.getEpicTaskID() == id) {
                result.put(subTask.getId(), subTask);
            }
        }
        return result;
    }

    public static SubTask getSubTaskById(int id) {
        return subTasks.get(id);
    }

    public static void createSubTask(SubTask task) {
        subTasks.put(task.getId(), task);
        getEpicTaskById(task.getEpicTaskID()).addSubTask(task);
    }

    public static void updateSubTask(SubTask task) {
        subTasks.put(task.getId(), task);
        getEpicTaskById(task.getEpicTaskID()).evaluateEpicTaskStatus();
    }

    public static void deleteSubTaskById(int id) {
        EpicTask epicTask = TaskManager.getEpicTaskById(subTasks.get(id).getEpicTaskID());
        epicTask.removeSubTaskId(id);
        subTasks.remove(id);
        epicTask.evaluateEpicTaskStatus();
    }

    // Методы для EpicTask
    public static HashMap<Integer, EpicTask> getAllEpicTasks() {
        return epicTasks;
    }

    public static void deleteAllEpicTasks() {
        epicTasks.clear();
    }

    public static EpicTask getEpicTaskById(int id) {
        return epicTasks.get(id);
    }

    public static void createEpicTask(EpicTask task) {
        epicTasks.put(task.getId(), task);

    }

    public static void updateEpicTask(EpicTask task) {
        epicTasks.put(task.getId(), task);
    }

    public static void deleteEpicTaskById(int id) {
        EpicTask epicToDelete = getEpicTaskById(id);
        for (int subTaskID : epicToDelete.getSubTasksID()) {
            TaskManager.subTasks.remove(subTaskID);
        }
        epicTasks.remove(id);
    }
}
