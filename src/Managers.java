import java.util.ArrayList;

public class Managers {
    public TaskManager getDefault() {
        return new TaskManager() {
            @Override
            public void writeHistory(Task task) {
            }

            @Override
            public ArrayList<Task> getAllTasks() {
                return null;
            }

            @Override
            public void deleteAllTasks() {
            }

            @Override
            public Task getTaskById(int id) {
                return null;
            }

            @Override
            public void createTask(Task task) {
            }

            @Override
            public void updateTask(Task task) {

            }

            @Override
            public void deleteTaskById(int id) {

            }

            @Override
            public ArrayList<SubTask> getAllSubTasks() {
                return null;
            }

            @Override
            public void deleteAllSubTasksByEpicID(int id) {

            }

            @Override
            public SubTask getSubTaskById(int id) {
                return null;
            }

            @Override
            public ArrayList<SubTask> getEpicIDSubTasks(int id) {
                return null;
            }

            @Override
            public void createSubTask(SubTask task) {

            }

            @Override
            public void updateSubTask(SubTask task) {

            }

            @Override
            public void deleteSubTaskById(int id) {

            }

            @Override
            public ArrayList<EpicTask> getAllEpicTasks() {
                return null;
            }

            @Override
            public void deleteAllEpicTasks() {

            }

            @Override
            public EpicTask getEpicTaskById(int id) {
                return null;
            }

            @Override
            public void createEpicTask(EpicTask task) {

            }

            @Override
            public void updateEpicTask(EpicTask task) {

            }

            @Override
            public void deleteEpicTaskById(int id) {

            }

            @Override
            public void evaluateEpicTaskStatus(EpicTask epicTask) {

            }

            @Override
            public int generateID() {
                return 0;
            }
        };
    }
}
