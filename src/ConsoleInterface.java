import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс создан для взаимодействия с пользователем и вывода информации в консоль.
 * Вся информация в консоль выводится только из методов этого класса.
 */

public class ConsoleInterface {

    private static Scanner scanner = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("Список доступных команд:");
        System.out.println("1 - Создать задачу");
        System.out.println("2 - Создать эпик задачу");
        System.out.println("3 - Создать подзадачу для определённого эпика");
        System.out.println("4 - Получить список всех задач");
        System.out.println("5 - Получить список всех подзадач");
        System.out.println("6 - Получить список всех эпик задач");
        System.out.println("7 - Получить список всех подзадач определённого эпика");
        System.out.println("8 - Изменить (обновить) задачу");
        System.out.println("9 - Изменить (обновить) подзадачу");
        System.out.println("10 - Изменить (обновить) эпик задачу");
        System.out.println("11 - Удалить все задачи");
        System.out.println("12 - Удалить все подзадачи определённого эпика");
        System.out.println("13 - Удалить все эпик задачи");
        System.out.println("14 - Получить задачу по ее ID");
        System.out.println("15 - Получить подзадачу по ее ID");
        System.out.println("16 - Получить эпик задачу по ее ID");
        System.out.println("17 - Удалить задачу по ее ID");
        System.out.println("18 - Удалить подзадачу по ее ID");
        System.out.println("19 - Удалить эпик задачу по ее ID");
        System.out.println("0 - Завершение работы.");
    }

    public static int getMenuItem() {
        System.out.print("Введите номер необходимой команды: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getTaskTitleFromUser() {
        System.out.println("Введите заголовок задачи: ");
        return scanner.nextLine();
    }

    public static String getTaskDescriptionFromUser() {
        System.out.println("Введите описание задачи: ");
        return scanner.nextLine();
    }

    public static Status getStatusFromUser() {
        String answer;
        System.out.println("Введите новое значение статуса задачи: NEW или IN_PROGRESS или DONE");
        while (true) {
            answer = scanner.nextLine();
            if (answer.equals("NEW")) {
                return Status.NEW;
            } else if (answer.equals("IN_PROGRESS")) {
                return Status.IN_PROGRESS;
            } else if (answer.equals("DONE")) {
                return Status.DONE;
            } else {
                System.out.println("Введите NEW или IN_PROGRESS или DONE");
            }
        }
    }

    public static int getIDFromUser() {
        System.out.println("Введите ID задачи:");
        return Integer.parseInt(scanner.nextLine());
    }

    public static boolean getYesOrNoFromUser() {
        String answer;
        while (true) {
            System.out.println("Введите y или n : ");
            answer = scanner.nextLine();
            if (answer.equals("y")) {
                return true;
            } else if (answer.equals("n")) {
                return false;
            }
            System.out.println("Вы ввели что-то не то, введите y или n : ");
        }
    }

    public static void createTask(TaskManager taskManager) {
        String title = getTaskTitleFromUser();
        String description = getTaskDescriptionFromUser();
        Task task = new Task(title, description);
        taskManager.createTask(task);
        System.out.println("Задача: " + title + ", с id "
                + task.getId() + " успешно создана.");
    }

    public static void createEpicTask(TaskManager taskManager) {
        String title = getTaskTitleFromUser();
        String description = getTaskDescriptionFromUser();
        EpicTask task = new EpicTask(title, description);
        taskManager.createEpicTask(task);
        System.out.println("Эпик задача: " + title + ", с id "
                + task.getId() + " успешно создана.");
    }

    public static void createSubTask(TaskManager taskManager) {
        System.out.println("Введите ID эпик задачи, для которой нужно создать подзадачу: ");
        int id = Integer.parseInt(scanner.nextLine());
        String title = getTaskTitleFromUser();
        String description = getTaskDescriptionFromUser();
        SubTask task = new SubTask(taskManager.getEpicTaskById(id), title, description);
        taskManager.createSubTask(task);
        System.out.println("Подзадача: " + title + ", с индексом "
                + task.getId() + " успешно создана.");
    }

    public static void deleteAllTasks(TaskManager taskManager) {
        System.out.println("Вы действительно хотите удалить все задачи?");
        if (getYesOrNoFromUser()) {
            taskManager.deleteAllTasks();
            System.out.println("Все задачи успешно удалены.");
        }
    }

    public static void deleteAllSubTasksByEpicID(TaskManager taskManager) {
        System.out.println("Введите ID эпик задачи, для которой нужно удалить все подзадачи: ");
        int id = Integer.parseInt(scanner.nextLine());
        EpicTask epicTask = taskManager.getEpicTaskById(id);
        if (epicTask == null) {
            System.out.println("Задачи с таким ID не существует.");
            return;
        }
        System.out.println("Вы действительно хотите удалить все подзадачи?");
        if (getYesOrNoFromUser()) {
            taskManager.deleteAllSubTasksByEpicID(id);
            System.out.println("Все подзадачи успешно удалены.");
        }
    }

    public static void deleteAllEpicTasks(TaskManager taskManager) {
        System.out.println("Вы действительно хотите удалить все эпик задачи?");
        if (getYesOrNoFromUser()) {
            taskManager.deleteAllEpicTasks();
            System.out.println("Все эпик задачи успешно удалены.");
        }
    }

    public static void updateTask(TaskManager taskManager) {
        int id = ConsoleInterface.getIDFromUser();
        Task taskToUpdate = taskManager.getTaskById(id);
        if (taskToUpdate == null) {
            System.out.println("Задачи с таким ID не существует.");
            return;
        }
        System.out.println("Хотите изменить заголовок задачи?");
        if (getYesOrNoFromUser()) {
            taskToUpdate.setTitle(getTaskTitleFromUser());
        }
        System.out.println("Хотите изменить описание задачи?");
        if (getYesOrNoFromUser()) {
            taskToUpdate.setDescription(getTaskDescriptionFromUser());
        }
        System.out.println("Хотите изменить статус задачи? Сейчас статус: " + taskToUpdate.getStatus());
        if (getYesOrNoFromUser()) {
            taskToUpdate.setStatus(getStatusFromUser());
        }
        taskManager.updateTask(taskToUpdate);
    }

    public static void updateSubTask(TaskManager taskManager) {
        int id = ConsoleInterface.getIDFromUser();
        SubTask subTaskToUpdate = taskManager.getSubTaskById(id);
        if (subTaskToUpdate == null) {
            System.out.println("Задачи с таким ID не существует.");
            return;
        }
        System.out.println("Хотите изменить заголовок задачи?");
        if (getYesOrNoFromUser()) {
            subTaskToUpdate.setTitle(getTaskTitleFromUser());
        }
        System.out.println("Хотите изменить описание подзадачи?");
        if (getYesOrNoFromUser()) {
            subTaskToUpdate.setDescription(getTaskDescriptionFromUser());
        }
        System.out.println("Хотите изменить статус подзадачи? Сейчас статус: " + subTaskToUpdate.getStatus());
        if (getYesOrNoFromUser()) {
            subTaskToUpdate.setStatus(getStatusFromUser());
        }
        taskManager.updateSubTask(subTaskToUpdate);
    }

    public static void updateEpicTask(TaskManager taskManager) {
        int id = ConsoleInterface.getIDFromUser();
        EpicTask epicTaskToUpdate = taskManager.getEpicTaskById(id);
        if (epicTaskToUpdate == null) {
            System.out.println("Задачи с таким ID не существует.");
            return;
        }
        System.out.println("Хотите изменить заголовок эпик задачи?");
        if (getYesOrNoFromUser()) {
            epicTaskToUpdate.setTitle(getTaskTitleFromUser());
        }
        System.out.println("Хотите изменить описание эпик задачи?");
        if (getYesOrNoFromUser()) {
            epicTaskToUpdate.setDescription(getTaskDescriptionFromUser());
        }

        taskManager.updateEpicTask(epicTaskToUpdate);
    }

    public static void getAllTasks(TaskManager taskManager) {
        ArrayList<Task> tasks = taskManager.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("Cписок задач пуст.");
            return;
        }
        System.out.println("Список всех задач:");
        for (Task task : tasks) {
            System.out.println("Задача ID: " + task.getId() + ", статус: "
                    + task.getStatus() + ",  Заголовок: " + task.getTitle() +
                    "  Описание: " + task.getDescription());
        }
    }

    public static void getAllSubTasks(TaskManager taskManager) {
        ArrayList<SubTask> tasks = taskManager.getAllSubTasks();
        if (tasks.isEmpty()) {
            System.out.println("Cписок подзадач пуст.");
            return;
        }
        System.out.println("Список всех подзадач:");
        for (Task task : tasks) {
            System.out.println("Подзадача ID: " + task.getId() + ", статус: "
                    + task.getStatus() + ",  Заголовок: " + task.getTitle() +
                    "  Описание: " + task.getDescription());
        }
    }

    public static void getAllEpicTasks(TaskManager taskManager) {
        ArrayList<EpicTask> tasks = taskManager.getAllEpicTasks();
        if (tasks.isEmpty()) {
            System.out.println("Cписок эпикзадач пуст.");
            return;
        }
        System.out.println("Список всех эпикзадач:");
        for (Task task : tasks) {
            System.out.println("Эпик задача ID: " + task.getId() + ", статус: "
                    + task.getStatus() + ",  Заголовок: " + task.getTitle() +
                    "  Описание: " + task.getDescription());
        }
    }

    public static void getEpicIDSubTasks(TaskManager taskManager) {
        int id = ConsoleInterface.getIDFromUser();
        EpicTask epicTask = taskManager.getEpicTaskById(id);
        if (epicTask == null) {
            System.out.println("Эпик задачи с ID: " + id + " не существует.");
            return;
        }
        ArrayList<SubTask> subTasks = taskManager.getEpicIDSubTasks(id);

        if (subTasks.isEmpty()) {
            System.out.println("Cписок подзадач этого эпика пуст");
            return;
        }

        System.out.println("Список всех подзадач эпика ID: " + taskManager.getEpicTaskById(id).getId());
        for (SubTask subtask : subTasks) {
            if (subtask.getEpicTaskID() == id) {
                System.out.println("Подзадача ID: " + subtask.getId() + ", статус: "
                        + subtask.getStatus() + ",  Заголовок: " + subtask.getTitle()
                        + "  Описание: " + subtask.getDescription());
            }
        }
    }

    public static void getTaskById(TaskManager taskManager) {
        int id = ConsoleInterface.getIDFromUser();
        Task task = taskManager.getTaskById(id);
        if (task == null) {
            System.out.println("Задачи с таким ID не существует.");
            return;
        }
        System.out.println(task);
    }

    public static void getSubTaskById(TaskManager taskManager) {
        int id = ConsoleInterface.getIDFromUser();
        SubTask subTask = taskManager.getSubTaskById(id);
        if (subTask == null) {
            System.out.println("Подзадачи с таким ID не существует.");
            return;
        }
        System.out.println(subTask);
    }

    public static void getEpicTaskById(TaskManager taskManager) {
        int id = ConsoleInterface.getIDFromUser();
        EpicTask epicTask = taskManager.getEpicTaskById(id);
        if (epicTask == null) {
            System.out.println("Эпик задачи с таким ID не существует.");
            return;
        }
        System.out.println(epicTask);
    }

    public static void deleteTaskById(TaskManager taskManager) {
        int id = ConsoleInterface.getIDFromUser();
        if (taskManager.getTaskById(id) == null) {
            System.out.println("Задачи с таким ID не существует.");
            return;
        }
        taskManager.deleteTaskById(id);
    }

    public static void deleteSubTaskById(TaskManager taskManager) {
        int id = ConsoleInterface.getIDFromUser();
        if (taskManager.getSubTaskById(id) == null) {
            System.out.println("Подзадачи с таким ID не существует.");
            return;
        }
        taskManager.deleteSubTaskById(id);
    }

    public static void deleteEpicTaskById(TaskManager taskManager) {
        int id = ConsoleInterface.getIDFromUser();
        if (taskManager.getEpicTaskById(id) == null) {
            System.out.println("Эпик задачи с таким ID не существует.");
            return;
        }
        taskManager.deleteEpicTaskById(id);
    }

    public static void printGoodBye() {
        System.out.println("***** Спасибо за использование программы. *****");
    }

    public static void printHello() {
        System.out.println("Вас приветствует трекер задач!");
    }
}
