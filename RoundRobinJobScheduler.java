public class RoundRobinJobScheduler {

    // Node to represent each job in the linked list
    private class Node {
        String data; // Job name
        int execTime; // Total execution time
        int remainingTime; // Remaining time to execute
        Node next; // Link to the next node in the list

        public Node(String data, int execTime) {
            this.data = data;
            this.execTime = execTime;
            this.remainingTime = execTime;
            this.next = null;
        }
    }

    // Linked list to hold jobs
    private class LinkedList {
        private Node head;
        private Node tail;

        // Check if the queue is empty
        public boolean isEmpty() {
            return head == null;
        }

        // Insert job at the end of the queue (FIFO order)
        public void insert(String data, int execTime) {
            Node newNode = new Node(data, execTime);
            if (isEmpty()) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            System.out.println("Added: " + newNode.data);
        }

        // Remove the first job from the queue (FIFO)
        public String removeFirst() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return null;
            }
            String removedData = head.data;
            head = head.next;
            if (head == null) {
                tail = null; // If the list becomes empty, reset tail
            }
            return removedData;
        }

        // Display the jobs in the queue
        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return;
            }
            Node temp = head;
            System.out.println("Round Robin Job Queue:");
            while (temp != null) {
                System.out.println("Job: " + temp.data + ", Exec Time: " + temp.execTime + ", Remaining Time: " + temp.remainingTime);
                temp = temp.next;
            }
        }
    }

    // The actual RoundRobinJobScheduler which uses LinkedList
    private LinkedList jobQueue;
    private int timeQuantum;

    public RoundRobinJobScheduler(int timeQuantum) {
        jobQueue = new LinkedList();
        this.timeQuantum = timeQuantum;
    }

    // Add job to the scheduler
    public void addJob(String data, int execTime) {
        jobQueue.insert(data, execTime);
    }

    // Remove job from the scheduler
    public String removeJob() {
        return jobQueue.removeFirst();
    }

    // Execute jobs in round-robin fashion
    public void executeAllJobs() {
        System.out.println("\nJob Execution Started");

        // Execute jobs until all are completed
        while (!jobQueue.isEmpty()) {
            Node currentJob = jobQueue.head;

            // Simulate job execution
            if (currentJob.remainingTime <= timeQuantum) {
                // If the job can finish within one time slice
                System.out.println("Executing: " + currentJob.data);
                try {
                    Thread.sleep(currentJob.remainingTime * 1000); // Simulating execution for job's remaining time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Completed: " + currentJob.data);
                jobQueue.removeFirst(); // Remove the completed job
            } else {
                // If the job needs more time, reduce the remaining time and move it to the end of the queue
                currentJob.remainingTime -= timeQuantum;
                System.out.println("Executing: " + currentJob.data + " for " + timeQuantum + " seconds.");
                try {
                    Thread.sleep(timeQuantum * 1000); // Simulating execution for time slice
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Job " + currentJob.data + " is not complete, re-adding to the queue with remaining time: " + currentJob.remainingTime);
                jobQueue.removeFirst(); // Remove the current job and re-add it at the end
                jobQueue.insert(currentJob.data, currentJob.remainingTime);
            }
        }
        System.out.println("All jobs executed successfully.");
    }

    // Display the current job queue
    public void showQueue() {
        jobQueue.display();
    }

    // Main method to test the Round Robin Job Scheduler
    public static void main(String[] args) {
        RoundRobinJobScheduler scheduler = new RoundRobinJobScheduler(3); // Time quantum = 3 seconds

        // Adding jobs to the scheduler with execution times
        scheduler.addJob("Job1", 5); // Job1 with execution time of 5 seconds
        scheduler.addJob("Job2", 4); // Job2 with execution time of 4 seconds
        scheduler.addJob("Job3", 7); // Job3 with execution time of 7 seconds

        // Displaying the current job queue
        scheduler.showQueue();

        // Execute all jobs in round-robin fashion
        scheduler.executeAllJobs();
    }
}
