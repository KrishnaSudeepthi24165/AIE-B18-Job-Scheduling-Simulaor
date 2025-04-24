class PriorityQueue {
    private LinkedList linkedList;

    public PriorityQueue() {
        linkedList = new LinkedList();
    }

    public void insert(String data, int priority) {
        linkedList.insert(data, priority);
    }

    public String delete() {
        return linkedList.removeFirst();
    }

    public void display() {
        linkedList.display();
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.insert("Task1", 2);
        pq.insert("Task2", 1);
        pq.insert("Task3", 3);
        pq.insert("Task4", 0);
        pq.insert("Task5", 2);

        pq.display();

        System.out.println("Deleted: " + pq.delete());
        pq.display();
    }
}
