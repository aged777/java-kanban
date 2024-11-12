import java.util.HashMap;
import java.util.Scanner;

public class ConsoleInterface {

    Scanner scanner = new Scanner(System.in);
    public void printMenu() {
        System.out.println("Список доступных команд:");
        System.out.println("1 - Создать задачу");//
        System.out.println("2 - Создать эпик задачу");//
        System.out.println("3 - Создать подзадачу для определённого эпика");//
        System.out.println("4 - Получить список всех задач");//
        System.out.println("5 - Получить список всех подзадач");
        System.out.println("6 - Получить список всех эпик задач");
        System.out.println("7 - Получить список всех подзадач определённого эпика");
        System.out.println("8 - Изменить (обновить) задачу");
        System.out.println("9 - Изменить (обновить) подзадачу");
        System.out.println("10 - Изменить (обновить) эпик задачу");
        System.out.println("11 - Удалить все задачи");
        System.out.println("12 - Удалить подзадачи определённого эпика");
        System.out.println("13 - Удалить все эпик задачи");
        System.out.println("14 - Удалить подзадачи всех эпиков");
        System.out.println("0 - Завершение работы.");
    }

    public int getMenuNumber() {
        System.out.print("Введите номер необходимой команды: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void createTask(TaskManager taskManager) {
        String title = getTaskTitleFromUser();
        String description = getTaskDescriptionFromUser();
        Task task = new Task(title, description);
        taskManager.createTask(task);
        System.out.println("Задача: " + title + ", с индексом " + task.getId() + " успешно создана.");
    }

    public void createSubTask(TaskManager taskManager) {
        System.out.println("Введите ID эпик задачи, для которой нужно создать подзадачу:");
        int id = scanner.nextInt();
        String title = getTaskTitleFromUser();
        String description = getTaskDescriptionFromUser();
        SubTask subTask = new SubTask(taskManager.getEpicTaskById(id), title, description);
        taskManager.createSubTask(subTask);
        System.out.println("Подзадача: " + title + ", с индексом " + subTask.getId() +
                " для эпик задачи " + taskManager.getEpicTaskById(id).getTitle() +
                " с индексом " + id + " успешно создана.");
    }

    public String getTaskTitleFromUser() {
        System.out.println("Введите заголовок задачи: ");
        return scanner.nextLine();
    }

    public String getTaskDescriptionFromUser() {
        System.out.println("Введите описание задачи: ");
        return scanner.nextLine();
    }

    public void createEpicTask(TaskManager taskManager) {
        String title = getTaskTitleFromUser();
        String description = getTaskDescriptionFromUser();
        EpicTask task = new EpicTask(title, description);
        taskManager.createEpicTask(task);
        System.out.println("Эпик задача: " + title + ", с индексом " + task.getId() + " успешно создана.");
    }

    public void getAllTasks(TaskManager taskManager) {
        HashMap<Integer, Task> tasks = taskManager.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("Cписок задач пуст.");
            return;
        }
        System.out.println("Список всех задач:");
        for (Task task : tasks.values()) {
            System.out.println("Задача ID: " + task.getId() +
                    ", статус: " + task.getStatus() +
                    ",  Заголовок: " + task.getTitle() +
                    "  Описание: " + task.getDescription());
        }
    }

    public void getAllSubTasks(TaskManager taskManager) {
        HashMap<Integer, SubTask> subTasks = taskManager.getAllSubTasks();
        if (subTasks.isEmpty()) {
            System.out.println("Cписок подзадач пуст.");
            return;
        }
        System.out.println("Список всех подзадач:");
        for (SubTask subTask : subTasks.values()) {
            System.out.println("Подзадача ID: " + subTask.getId() +
                    ", статус: " + subTask.getStatus() +
                    ",  Заголовок: " + subTask.getTitle() +
                    "  Эпик ID: " + subTask.getEpicTaskID() +
                    ", статус: " + taskManager.getEpicTaskById(subTask.getId()).getStatus());
        }
    }

    public void getAllEpicTasks(TaskManager taskManager) {
        HashMap<Integer, EpicTask> epicTasks = taskManager.getAllEpicTasks();
        if (epicTasks.isEmpty()) {
            System.out.println("Cписок эпик задач пуст.");
            return;
        }
        System.out.println("Список всех эпик задач: ");
        for (EpicTask epicTask : epicTasks.values()) {
            System.out.println("Эпик задача ID: " + epicTask.getId() +
                    ", статус: " + epicTask.getStatus() +
                    ",  Заголовок: " + epicTask.getTitle() +
                    "  Описание: " + epicTask.getDescription());
        }
    }

    public void printGoodBye() {
        System.out.println("***** Спасибо за использование программы. *****");
    }

    public void printHello() {
        System.out.println("Вас приветствует трекер задач!");
    }
}
