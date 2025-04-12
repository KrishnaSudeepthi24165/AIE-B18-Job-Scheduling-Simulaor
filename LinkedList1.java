public class LinkedList1 {
    Node1 head, tail;
    int size;

    public LinkedList1() {
        head = tail = null;
        size = 0;
    }

    public void append(String value) {
        Node1 newNode = new Node1(value);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    public String removeFirst() {
        if (head == null) {
            throw new IllegalStateException("Queue underflow");
        }
        String value = head.value;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        Node1 current = head;
        System.out.print("Job Queue: [");
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) System.out.print(", ");
            current = current.next;
        }
        System.out.println("]");
    }

    public String[] toArray() {
        String[] arr = new String[size];
        Node1 current = head;
        int i = 0;
        while (current != null) {
            arr[i++] = current.value;
            current = current.next;
        }
        return arr;
    }
}
