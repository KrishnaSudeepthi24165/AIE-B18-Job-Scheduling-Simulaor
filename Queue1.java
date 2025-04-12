public class Queue1 {
    private LinkedList1 list;

    public Queue1() {
        list = new LinkedList1();
    }

    public void enqueue(String value) {
        list.append(value);
    }

    public String dequeue() {
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void display() {
        list.display();
    }

    public String[] remainingJobs() {
        return list.toArray();
    }
}
