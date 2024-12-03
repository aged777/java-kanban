import java.util.ArrayList;
import java.util.HashMap;

/**
 * Класс создан для хранения, изменения, получения объектов всех видов задач.
 * Методы класса ничего не должны выводить в консоль или запрашивать что-либо от пользователя, для этого создан класс
 * ConsoleInterface.
 */
public class TaskManager {
    private int id = 1;
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, SubTask> subTasks = new HashMap<>();
    private HashMap<Integer, EpicTask> epicTasks = new HashMap<>();

    public int getId() {
        return id;
    }

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
        tasks.put(task.getId(), task);
        generateID();
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
        for (int subTaskID : epicTask.getSubTasksID()) {
            subTasks.remove(subTaskID);
        }
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
        subTasks.put(task.getId(), task);
        generateID();
        evaluateEpicTaskStatus(getEpicTaskById(task.getEpicTaskID()));
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
        epicTasks.clear();
        // Этот метод должен не только удалять все эпики, но и обновлять их статус
        // вопрос - не понимаю, зачем обновлять статус эпиков, если мы их удаляем?
    }

    public EpicTask getEpicTaskById(int id) {
        return epicTasks.get(id);
    }

    public void createEpicTask(EpicTask task) {
        epicTasks.put(task.getId(), task);
        generateID();
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
        for (Integer subTaskID : epicTask.getSubTasksID()) {
            if (this.getSubTaskById(subTaskID).getStatus().equals(Status.NEW)) {
                util[0]++;
            } else if (this.getSubTaskById(subTaskID).getStatus().equals(Status.DONE)) {
                util[1]++;
            }
        }
        if (util[0] == epicTask.getSubTasksID().size()) {
            epicTask.setStatus(Status.NEW);
        } else if (util[1] == epicTask.getSubTasksID().size()) {
            epicTask.setStatus(Status.DONE);
        } else {
            epicTask.setStatus(Status.IN_PROGRESS);
        }
    }

    private int generateID() {
        return ++id;
    }

    public void testingMethod() {

        Task task1 = new Task("задача1", "описаниезадача1", getId());
        createTask(task1);
        Task task2 = new Task("задача2", "описаниезадача2", getId());
        createTask(task2);
        Task task3 = new Task("задача3", "описаниезадача3", getId());
        createTask(task3);

        EpicTask epicTask1 = new EpicTask("эпик1", "описаниеэпик1", getId());
        createEpicTask(epicTask1);
        EpicTask epicTask2 = new EpicTask("эпик2", "описаниеэпик2", getId());
        createEpicTask(epicTask2);
        EpicTask epicTask3 = new EpicTask("эпик3", "описаниеэпик3", getId());
        createEpicTask(epicTask3);

        SubTask subTask1 = new SubTask(epicTask1, "подзадача1эпик1", "описаниеподзадача1эпик1", getId());
        createSubTask(subTask1);
        SubTask subTask2 = new SubTask(epicTask1, "подзадача2эпик1", "описаниеподзадача2эпик1", getId());
        createSubTask(subTask2);
        SubTask subTask3 = new SubTask(epicTask1, "подзадача3эпик1", "описаниеподзадача3эпик1", getId());
        createSubTask(subTask3);


        SubTask subTask4 = new SubTask(epicTask2, "подзадача1эпик2", "описаниеподзадача1эпик2", getId());
        createSubTask(subTask4);
        SubTask subTask5 = new SubTask(epicTask2, "подзадача2эпик2", "описаниеподзадача2эпик2", getId());
        createSubTask(subTask5);
        SubTask subTask6 = new SubTask(epicTask2, "подзадача3эпик2", "описаниеподзадача3эпик2", getId());
        createSubTask(subTask6);
        SubTask subTask7 = new SubTask(epicTask2, "подзадача4эпик2", "описаниеподзадача4эпик2", getId());
        createSubTask(subTask7);

        SubTask subTask8 = new SubTask(epicTask3, "подзадача1эпик3", "описаниеподзадача1эпик3", getId());
        createSubTask(subTask8);
        SubTask subTask9 = new SubTask(epicTask3, "подзадача2эпик3", "описаниеподзадача2эпик3", getId());
        createSubTask(subTask9);
        SubTask subTask10 = new SubTask(epicTask3, "подзадача3эпик3", "описаниеподзадача3эпик3", getId());
        createSubTask(subTask10);
        SubTask subTask11 = new SubTask(epicTask3, "подзадача4эпик3", "описаниеподзадача4эпик3", getId());
        createSubTask(subTask11);
        SubTask subTask12 = new SubTask(epicTask3, "подзадача5эпик3", "описаниеподзадача5эпик3", getId());
        createSubTask(subTask12);

    }
}
