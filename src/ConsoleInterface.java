import java.util.HashMap;
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
        System.out.println("12 - Удалить все подзадачи");
        System.out.println("13 - Удалить все эпик задачи");
        System.out.println("14 - Удалить подзадачи определённого эпика");
        System.out.println("15 - Получить задачу по ее ID");
        System.out.println("16 - Получить подзадачу по ее ID");
        System.out.println("17 - Получить эпик задачу по ее ID");
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

    public static void createTask() {
        String title = getTaskTitleFromUser();
        String description = getTaskDescriptionFromUser();
        Task task = new Task(title, description);
        TaskManager.createTask(task);
        System.out.println("Задача: " + title + ", с id "
                + task.getId() + " успешно создана.");
    }

    public static void createEpicTask() {
        String title = getTaskTitleFromUser();
        String description = getTaskDescriptionFromUser();
        EpicTask task = new EpicTask(title, description);
        TaskManager.createEpicTask(task);
        System.out.println("Эпик задача: " + title + ", с id "
                + task.getId() + " успешно создана.");
    }

    public static void createSubTask() {
        System.out.println("Введите ID эпик задачи, для которой нужно создать подзадачу: ");
        int id = Integer.parseInt(scanner.nextLine());
        String title = getTaskTitleFromUser();
        String description = getTaskDescriptionFromUser();
        SubTask task = new SubTask(TaskManager.getEpicTaskById(id), title, description);
        TaskManager.createSubTask(task);
        System.out.println("Подзадача: " + title + ", с индексом "
                + task.getId() + " успешно создана.");
    }

    public static void deleteAllTasks() {
        System.out.println("Вы действительно хотите удалить все задачи?   y / n :  ");
        if (getYesOrNoFromUser()) {
            TaskManager.deleteAllTasks();
            System.out.println("Все задачи успешно удалены.");
        }
    }

    public static void deleteAllSubTasks() {
        System.out.println("Вы действительно хотите удалить все подзадачи?   y / n :  ");
        if (getYesOrNoFromUser()) {
            TaskManager.deleteAllSubTasks();
            System.out.println("Все подзадачи успешно удалены.");
        }

    }

    public static void deleteAllEpicTasks() {
        System.out.println("Вы действительно хотите удалить все эпик задачи?   y / n :  ");
        if (getYesOrNoFromUser()) {
            TaskManager.deleteAllEpicTasks();
            System.out.println("Все эпик задачи успешно удалены.");
        }
    }

    public static void deleteAllEpicIdSubTasks() {
        int id = ConsoleInterface.getIDFromUser();
        System.out.println("Вы действительно хотите удалить все эпик задачи?   y / n :  ");
        if (getYesOrNoFromUser()) {
            TaskManager.deleteEpicIDSubTasks(id);
            System.out.println("Все подзадачи эпика с ID: " + id + " успешно удалены.");
        }
    }

    public static void getAllTasks() {
        HashMap<Integer, Task> tasks = TaskManager.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("Cписок задач пуст.");
            return;
        }
        System.out.println("Список всех задач:");
        for (Task task : tasks.values()) {
            System.out.println("Задача ID: " + task.getId() + ", статус: "
                    + task.getStatus() + ",  Заголовок: " + task.getTitle() +
                    "  Описание: " + task.getDescription());
        }
    }

    public static void getAllSubTasks() {
        HashMap<Integer, SubTask> tasks = TaskManager.getAllSubTasks();
        if (tasks.isEmpty()) {
            System.out.println("Cписок подзадач пуст.");
            return;
        }
        System.out.println("Список всех подзадач:");
        for (Task task : tasks.values()) {
            System.out.println("Подзадача ID: " + task.getId() + ", статус: "
                    + task.getStatus() + ",  Заголовок: " + task.getTitle() +
                    "  Описание: " + task.getDescription());
        }
    }

    public static void getAllEpicTasks() {
        HashMap<Integer, EpicTask> tasks = TaskManager.getAllEpicTasks();
        if (tasks.isEmpty()) {
            System.out.println("Cписок эпикзадач пуст.");
            return;
        }
        System.out.println("Список всех эпикзадач:");
        for (Task task : tasks.values()) {
            System.out.println("Эпик задача ID: " + task.getId() + ", статус: "
                    + task.getStatus() + ",  Заголовок: " + task.getTitle() +
                    "  Описание: " + task.getDescription());
        }
    }

    public static void getEpicIDSubTasks() {
        int id = ConsoleInterface.getIDFromUser();
        HashMap<Integer, SubTask> subTasks = TaskManager.getAllSubTasks();

        System.out.println("Список всех подзадач эпика ID: " + TaskManager.getEpicTaskById(id).getId());
        for (SubTask subtask : subTasks.values()) {
            if (subtask.getEpicTaskID() == id) {
                System.out.println("Подзадача ID: " + subtask.getId() + ", статус: "
                        + subtask.getStatus() + ",  Заголовок: " + subtask.getTitle()
                        + "  Описание: " + subtask.getDescription());
            }
        }
    }

    public static void getTaskById() {
        int id = ConsoleInterface.getIDFromUser();
        Task task = TaskManager.getTaskById(id);
        System.out.println(task);
    }

    public static void getSubTaskById() {
        int id = ConsoleInterface.getIDFromUser();
        SubTask subTask = TaskManager.getSubTaskById(id);
        System.out.println(subTask);
    }

    public static void getEpicTaskById() {
        int id = ConsoleInterface.getIDFromUser();
        EpicTask epicTask = TaskManager.getEpicTaskById(id);
        System.out.println(epicTask);
    }

    public static void printGoodBye() {
        System.out.println("***** Спасибо за использование программы. *****");
    }

    public static void printHello() {
        System.out.println("Вас приветствует трекер задач!");
    }
}
