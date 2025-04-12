public class Node {
    String jobName;
    int priority;
    Node next;

    public Node(String jobName, int priority) {
        this.jobName = jobName;
        this.priority = priority;
        this.next = null;
    }
}
