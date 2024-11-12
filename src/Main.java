import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        ConsoleInterface consoleInterface = new ConsoleInterface();
        int menuItem;

        consoleInterface.printHello();

        while(true) {
            consoleInterface.printMenu();
            menuItem = consoleInterface.getMenuNumber();
            switch(menuItem) {
                case 1:
                    consoleInterface.createTask(taskManager);
                    break;
                case 2:
                    consoleInterface.createEpicTask(taskManager);
                    break;
                case 3:
                    consoleInterface.createSubTask(taskManager);
                    break;
                case 4:
                    consoleInterface.getAllTasks(taskManager);
                    break;
                case 5:
                    consoleInterface.getAllSubTasks(taskManager);
                    break;
                case 6:
                    consoleInterface.getAllEpicTasks(taskManager);
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 0:
                    consoleInterface.printGoodBye();
                    return;
            }
        }
    }
}
