import java.util.LinkedList;
import java.util.Queue;

public class RoundRobinScheduler implements Scheduler {
    private Queue<Task> roundRobinQueue;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
        roundRobinQueue = new LinkedList<>();
    }

    @Override
    public void addTask(Task task) {
        roundRobinQueue.add(task);
    }

    @Override
    public void execute() {
        System.out.println("Simulating Round Robin Scheduling:");
        while (!roundRobinQueue.isEmpty()) {
            Task task = roundRobinQueue.poll();
            if (task.burstTime > timeQuantum) {
                task.burstTime -= timeQuantum;
                System.out.println("Executing " + task + " for " + timeQuantum + " units.");
                roundRobinQueue.add(task);
            } else {
                executeTask(task);
            }
        }
    }

    private void executeTask(Task task) {
        System.out.println("Executing " + task);
    }
}
