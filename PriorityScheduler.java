import java.util.PriorityQueue;

public class PriorityScheduler implements Scheduler {
    private PriorityQueue<Task> priorityQueue;

    public PriorityScheduler() {
        priorityQueue = new PriorityQueue<>();
    }

    @Override
    public void addTask(Task task) {
        priorityQueue.add(task);
    }

    @Override
    public void execute() {
        System.out.println("Simulating Priority Scheduling:");
        while (!priorityQueue.isEmpty()) {
            Task task = priorityQueue.poll();
            executeTask(task);
        }
    }

    private void executeTask(Task task) {
        System.out.println("Executing " + task);
    }
}
