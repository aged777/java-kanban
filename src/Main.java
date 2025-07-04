/**
 * В классе Main запускается бесконечный цикл консольного интерфейса,
 * в котором посредством выбора пользователем пунктов основного меню происходит основная работа программы.
 */
public class Main {
    // статический метод testScenario(TaskManager testTaskManager) создан для реализации сценария для проверки из ТЗ
    // в нём создается ряд задач, вызываются методы InMemoryTaskManager,
    // выводится история просмотров после каждого вызова

    public static void testScenario(TaskManager testTaskManager) {

        Task task1 = new Task("задача1", "описаниезадача1");
        testTaskManager.createTask(task1);
        Task task2 = new Task("задача2", "описаниезадача2");
        testTaskManager.createTask(task2);
        Task task3 = new Task("задача3", "описаниезадача3");
        testTaskManager.createTask(task3);

        EpicTask epicTask1 = new EpicTask("эпик1", "описаниеэпик1");
        testTaskManager.createEpicTask(epicTask1);
        EpicTask epicTask2 = new EpicTask("эпик2", "описаниеэпик2");
        testTaskManager.createEpicTask(epicTask2);
        EpicTask epicTask3 = new EpicTask("эпик3", "описаниеэпик3");
        testTaskManager.createEpicTask(epicTask3);

        SubTask subTask1 = new SubTask(epicTask1, "подзадача1эпик1", "описаниеподзадача1эпик1");
        testTaskManager.createSubTask(subTask1);
        SubTask subTask2 = new SubTask(epicTask1, "подзадача2эпик1", "описаниеподзадача2эпик1");
        testTaskManager.createSubTask(subTask2);
        SubTask subTask3 = new SubTask(epicTask1, "подзадача3эпик1", "описаниеподзадача3эпик1");
        testTaskManager.createSubTask(subTask3);


        SubTask subTask4 = new SubTask(epicTask2, "подзадача1эпик2", "описаниеподзадача1эпик2");
        testTaskManager.createSubTask(subTask4);
        SubTask subTask5 = new SubTask(epicTask2, "подзадача2эпик2", "описаниеподзадача2эпик2");
        testTaskManager.createSubTask(subTask5);
        SubTask subTask6 = new SubTask(epicTask2, "подзадача3эпик2", "описаниеподзадача3эпик2");
        testTaskManager.createSubTask(subTask6);
        SubTask subTask7 = new SubTask(epicTask2, "подзадача4эпик2", "описаниеподзадача4эпик2");
        testTaskManager.createSubTask(subTask7);

        SubTask subTask8 = new SubTask(epicTask3, "подзадача1эпик3", "описаниеподзадача1эпик3");
        testTaskManager.createSubTask(subTask8);
        SubTask subTask9 = new SubTask(epicTask3, "подзадача2эпик3", "описаниеподзадача2эпик3");
        testTaskManager.createSubTask(subTask9);
        SubTask subTask10 = new SubTask(epicTask3, "подзадача3эпик3", "описаниеподзадача3эпик3");
        testTaskManager.createSubTask(subTask10);
        SubTask subTask11 = new SubTask(epicTask3, "подзадача4эпик3", "описаниеподзадача4эпик3");
        testTaskManager.createSubTask(subTask11);
        SubTask subTask12 = new SubTask(epicTask3, "подзадача5эпик3", "описаниеподзадача5эпик3");
        testTaskManager.createSubTask(subTask12);
    }

    public static void main(String[] args) {
        int menuItem;

        InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager();

        testScenario(inMemoryTaskManager);

        ConsoleInterface.printHello();

        while (true) {
            ConsoleInterface.printMenu();
            menuItem = ConsoleInterface.getMenuItem();
            switch (menuItem) {
                case 1:
                    ConsoleInterface.createTask(inMemoryTaskManager);
                    break;
                case 2:
                    ConsoleInterface.createEpicTask(inMemoryTaskManager);
                    break;
                case 3:
                    ConsoleInterface.createSubTask(inMemoryTaskManager);
                    break;
                case 4:
                    ConsoleInterface.getAllTasks(inMemoryTaskManager);
                    break;
                case 5:
                    ConsoleInterface.getAllSubTasks(inMemoryTaskManager);
                    break;
                case 6:
                    ConsoleInterface.getAllEpicTasks(inMemoryTaskManager);
                    break;
                case 7:
                    ConsoleInterface.getEpicIDSubTasks(inMemoryTaskManager);
                    break;
                case 8:
                    ConsoleInterface.updateTask(inMemoryTaskManager);
                    break;
                case 9:
                    ConsoleInterface.updateSubTask(inMemoryTaskManager);
                    break;
                case 10:
                    ConsoleInterface.updateEpicTask(inMemoryTaskManager);
                    break;
                case 11:
                    ConsoleInterface.deleteAllTasks(inMemoryTaskManager);
                    break;
                case 12:
                    ConsoleInterface.deleteAllSubTasksByEpicID(inMemoryTaskManager);
                    break;
                case 13:
                    ConsoleInterface.deleteAllEpicTasks(inMemoryTaskManager);
                    break;
                case 14:
                    ConsoleInterface.getTaskById(inMemoryTaskManager);
                    break;
                case 15:
                    ConsoleInterface.getSubTaskById(inMemoryTaskManager);
                    break;
                case 16:
                    ConsoleInterface.getEpicTaskById(inMemoryTaskManager);
                    break;
                case 17:
                    ConsoleInterface.deleteTaskById(inMemoryTaskManager);
                    break;
                case 18:
                    ConsoleInterface.deleteSubTaskById(inMemoryTaskManager);
                    break;
                case 19:
                    ConsoleInterface.deleteEpicTaskById(inMemoryTaskManager);
                    break;
                case 0:
                    ConsoleInterface.printGoodBye();
                    return;
            }
        }
    }
}
