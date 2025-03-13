public class JobScheduler {
    public static void main(String[] args) {
        Scheduler fifoScheduler = new FIFOScheduler();
        Scheduler roundRobinScheduler = new RoundRobinScheduler(4);
        Scheduler priorityScheduler = new PriorityScheduler();

        Task task1 = new Task(1, 1, 10);
        Task task2 = new Task(2, 3, 5);
        Task task3 = new Task(3, 2, 8);

        fifoScheduler.addTask(task1);
        fifoScheduler.addTask(task2);
        fifoScheduler.addTask(task3);

        roundRobinScheduler.addTask(task1);
        roundRobinScheduler.addTask(task2);
        roundRobinScheduler.addTask(task3);

        priorityScheduler.addTask(task1);
        priorityScheduler.addTask(task2);
        priorityScheduler.addTask(task3);

        fifoScheduler.execute();
        roundRobinScheduler.execute();
        priorityScheduler.execute();
    }
}
