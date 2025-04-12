import java.util.Random;

public class JobScheduler {
    private static final int MEMORY_THRESHOLD = 80;
    private static final String CLEANING_JOB = "Clean RAM";
    private static final int CLEANING_PRIORITY_HIGH = 5;
    private static final int CLEANING_PRIORITY_LOW = 1;

    public static int checkMemory() {
        return new Random().nextInt(51) + 50; // Generates 50 to 100
    }

    public static void main(String[] args) {
        PriorityQueue scheduler = new PriorityQueue();

        scheduler.insert("Backup Files", 3);
        scheduler.insert("Download Update", 2);
        scheduler.insert("User Application", 1);
        scheduler.insert(CLEANING_JOB, CLEANING_PRIORITY_LOW);
        scheduler.insert("Monitor Logs", 0);

        boolean cleaningPriorityBoosted = false;

        for (int cycle = 1; cycle <= 5; cycle++) {
            System.out.println("\n--- Scheduling Cycle " + cycle + " ---");
            int memoryUsage = checkMemory();
            System.out.println("Current Memory Usage: " + memoryUsage + "%");

            if (memoryUsage > MEMORY_THRESHOLD && !cleaningPriorityBoosted) {
                System.out.println("High memory usage detected. Boosting priority of cleaning job.");
                scheduler.updatePriority(CLEANING_JOB, CLEANING_PRIORITY_HIGH);
                cleaningPriorityBoosted = true;
            } else {
                System.out.println("Memory usage is normal or cleaning job already boosted.");
            }

            scheduler.display();
            String runningJob = scheduler.delete();
            if (runningJob != null) {
                System.out.println("✅ Running Job: " + runningJob);
            } else {
                System.out.println("No job to run.");
            }
        }
    }
}
