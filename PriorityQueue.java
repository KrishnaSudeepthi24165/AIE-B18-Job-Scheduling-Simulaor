public class PriorityQueue {
    LinkedList list;

    public PriorityQueue() {
        list = new LinkedList();
    }

    public void insert(String jobName, int priority) {
        list.insert(jobName, priority);
    }

    public String delete() {
        return list.removeFirst();
    }

    public void display() {
        list.display();
    }

    public void updatePriority(String jobName, int newPriority) {
        list.updatePriority(jobName, newPriority);
    }
}
