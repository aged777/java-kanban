/**
 * В классе Main запустается бесконечный цикл консольного интерфейса,
 * в котором посредством выбора пользователем пунктов основного меню происходит основная работа программы.
 */
public class Main {

    public static void main(String[] args) {
        int menuItem;
        TaskManager taskManager = new TaskManager();

        ConsoleInterface.printHello();

        while (true) {
            ConsoleInterface.printMenu();
            menuItem = ConsoleInterface.getMenuItem();
            switch (menuItem) {
                case 1:
                    ConsoleInterface.createTask(taskManager);
                    break;
                case 2:
                    ConsoleInterface.createEpicTask(taskManager);
                    break;
                case 3:
                    ConsoleInterface.createSubTask(taskManager);
                    break;
                case 4:
                    ConsoleInterface.getAllTasks(taskManager);
                    break;
                case 5:
                    ConsoleInterface.deleteAllSubTasksByEpicID(taskManager);
                    break;
                case 6:
                    ConsoleInterface.getAllEpicTasks(taskManager);
                    break;
                case 7:
                    ConsoleInterface.getEpicIDSubTasks(taskManager);
                    break;
                case 8:
                    ConsoleInterface.updateTask(taskManager);
                    break;
                case 9:
                    ConsoleInterface.updateSubTask(taskManager);
                    break;
                case 10:
                    ConsoleInterface.updateEpicTask(taskManager);
                    break;
                case 11:
                    ConsoleInterface.deleteAllTasks(taskManager);
                    break;
                case 12:
                    ConsoleInterface.deleteAllSubTasksByEpicID(taskManager);
                    break;
                case 13:
                    ConsoleInterface.deleteAllEpicTasks(taskManager);
                    break;
                case 14:
                    ConsoleInterface.getTaskById(taskManager);
                    break;
                case 15:
                    ConsoleInterface.getSubTaskById(taskManager);
                    break;
                case 16:
                    ConsoleInterface.getEpicTaskById(taskManager);
                    break;
                case 17:
                    ConsoleInterface.deleteTaskById(taskManager);
                    break;
                case 18:
                    ConsoleInterface.deleteSubTaskById(taskManager);
                    break;
                case 19:
                    ConsoleInterface.deleteEpicTaskById(taskManager);
                    break;
                case 0:
                    ConsoleInterface.printGoodBye();
                    return;
            }
        }
    }
}
