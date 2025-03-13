public interface Scheduler {
    void addTask(Task task);
    void execute();
}
