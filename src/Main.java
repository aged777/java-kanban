/**
 * В классе Main запустается бесконечный цикл консольного интерфейса,
 * в котором посредством выбора пользователем пунктов основного меню происходит основная работа программы.
 *
 */
public class Main {

    public static void main(String[] args) {

        int menuItem;

        ConsoleInterface.printHello();

        while(true) {
            ConsoleInterface.printMenu();
            menuItem = ConsoleInterface.getMenuItem();
            switch(menuItem) {
                case 1:
                    ConsoleInterface.createTask();
                    break;
                case 2:
                    ConsoleInterface.createEpicTask();
                    break;
                case 3:
                    ConsoleInterface.createSubTask();
                    break;
                case 4:
                    ConsoleInterface.getAllTasks();
                    break;
                case 5:
                    ConsoleInterface.getAllSubTasks();
                    break;
                case 6:
                    ConsoleInterface.getAllEpicTasks();
                    break;
                case 7:
                    ConsoleInterface.getEpicIDSubTasks();
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    ConsoleInterface.deleteAllTasks();
                    break;
                case 12:
                    ConsoleInterface.deleteAllSubTasks();
                    break;
                case 13:
                    ConsoleInterface.deleteAllEpicTasks();
                    break;
                case 14:
                    ConsoleInterface.deleteAllEpicIdSubTasks();
                    break;
                case 15:
                    ConsoleInterface.getTaskById();
                    break;
                case 16:
                    ConsoleInterface.getSubTaskById();
                    break;
                case 17:
                    ConsoleInterface.getEpicTaskById();
                    break;
                case 0:
                    ConsoleInterface.printGoodBye();
                    return;
            }
        }
    }
}
