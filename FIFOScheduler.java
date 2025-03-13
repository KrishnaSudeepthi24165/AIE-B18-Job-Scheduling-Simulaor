import java.util.LinkedList;
import java.util.Queue;

public class FIFOScheduler implements Scheduler {
    private Queue<Task> fifoQueue;

    public FIFOScheduler() {
        fifoQueue = new LinkedList<>();
    }

    @Override
    public void addTask(Task task) {
        fifoQueue.add(task);
    }

    @Override
    public void execute() {
        System.out.println("Simulating FIFO Scheduling:");
        while (!fifoQueue.isEmpty()) {
            Task task = fifoQueue.poll();
            executeTask(task);
        }
    }

    private void executeTask(Task task) {
        System.out.println("Executing " + task);
    }
}
