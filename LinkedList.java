public class LinkedList {
    Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(String jobName, int priority) {
        Node newNode = new Node(jobName, priority);
        if (isEmpty() || head.priority < priority) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null && temp.next.priority >= priority) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public String removeFirst() {
        if (isEmpty()) return null;
        String job = head.jobName;
        head = head.next;
        return job;
    }

    public void updatePriority(String jobName, int newPriority) {
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (temp.jobName.equals(jobName)) {
                if (temp.priority != newPriority) {
                    if (prev != null) {
                        prev.next = temp.next;
                    } else {
                        head = temp.next;
                    }
                    insert(jobName, newPriority);
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Job queue is empty.");
            return;
        }
        System.out.println("Job Queue (Job Name -> Priority):");
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.jobName + " -> Priority " + temp.priority);
            temp = temp.next;
        }
    }
}
