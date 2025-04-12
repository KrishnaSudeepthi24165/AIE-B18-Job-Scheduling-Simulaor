import java.util.Random;

public class JobMemoryManager1 {
    static final int MEMORY_LIMIT = 100;

    public static int simulateMemoryUsage() {
        return new Random().nextInt(16) + 10; // Random between 10 and 25%
    }

    public static void main(String[] args) {
        Queue1 queue = new Queue1();

        // Add jobs to the queue
        queue.enqueue("Backup Files");
        queue.enqueue("Download Update");
        queue.enqueue("User Application");
        queue.enqueue("Heavy AI Processing");
        queue.enqueue("Monitor Logs");
        queue.enqueue("Video Rendering");
        queue.enqueue("Database Sync");
        queue.enqueue("Analytics Report");

        System.out.println("Initial Job Queue:");
        queue.display();

        int totalMemoryUsed = 0;

        System.out.println("\nExecuting Jobs:");
        while (!queue.isEmpty()) {
            int memoryUsed = simulateMemoryUsage();

            if (totalMemoryUsed + memoryUsed > MEMORY_LIMIT) {
                System.out.println("Memory limit reached!");
                System.out.println("Cannot execute further jobs. Current memory: " + totalMemoryUsed + "%");
                break;
            }

            String job = queue.dequeue();
            totalMemoryUsed += memoryUsed;
            System.out.println(" Running Job: " + job + " | Memory Used: " + memoryUsed + "% | Total Used: " + totalMemoryUsed + "%");
        }

        System.out.println("\nFinal Total Memory Used: " + totalMemoryUsed + "%");

        // Show jobs that were not executed
        if (!queue.isEmpty()) {
            System.out.println("Skipped Jobs:");
            String[] skipped = queue.remainingJobs();
            for (String job : skipped) {
                System.out.println("- " + job);
            }
        } else {
            System.out.println("All jobs were executed.");
        }
    }
}
