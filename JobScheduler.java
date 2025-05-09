public class JobScheduler {

    // Node to represent each job in the linked list
    private class Node {
        String data; // Job name
        int execTime; // Job execution time
        Node next; // Link to the next node in the list

        public Node(String data, int execTime) {
            this.data = data;
            this.execTime = execTime;
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

        // Display the jobs in the FIFO queue
        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return;
            }
            Node temp = head;
            System.out.println("FIFO Job Queue:");
            while (temp != null) {
                System.out.println("Job: " + temp.data + ", Exec Time: " + temp.execTime);
                temp = temp.next;
            }
        }
    }

    // The actual JobScheduler which uses LinkedList
    private LinkedList jobQueue;

    public JobScheduler() {
        jobQueue = new LinkedList();
    }

    // Add job to the scheduler
    public void addJob(String data, int execTime) {
        jobQueue.insert(data, execTime);
    }

    // Remove job from the scheduler
    public String removeJob() {
        return jobQueue.removeFirst();
    }

    // Execute all jobs in FIFO order
    public void executeAllJobs() {
        System.out.println("\nJob Execution Started");

        // Process all jobs in the order they were added (FIFO)
        while (!jobQueue.isEmpty()) {
            String job = removeJob(); // Remove the first job
            System.out.println("Executing: " + job);

            // Simulate job execution (use a delay equal to the job's execution time)
            try {
                Thread.sleep(2000); // Simulating job execution for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Completed: " + job);
        }
        System.out.println("All jobs executed successfully.");
    }

    // Display the current job queue
    public void showQueue() {
        jobQueue.display();
    }

    // Main method to test the JobScheduler
    public static void main(String[] args) {
        JobScheduler scheduler = new JobScheduler();

        // Adding jobs to the scheduler with execution times
        scheduler.addJob("Job1", 5); // Job1 with execution time of 5 seconds
        scheduler.addJob("Job2", 3); // Job2 with execution time of 3 seconds
        scheduler.addJob("Job3", 4); // Job3 with execution time of 4 seconds
        scheduler.addJob("Job4", 6); // Job4 with execution time of 6 seconds

        // Displaying the current job queue
        scheduler.showQueue();

        // Execute all jobs in FIFO order
        scheduler.executeAllJobs();
    }
}
