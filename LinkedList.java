class LinkedList {
    private Node head;

    // Check if the queue is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Insert element based on priority (higher priority first)
    public void insert(String data, int priority) {
        Node newNode = new Node(data, priority);
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

    // Remove highest priority element (head of list)
    public String removeFirst() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        String removedData = head.data;
        head = head.next;
        return removedData;
    }

    // Display queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        Node temp = head;
        System.out.println("Priority Queue:");
        while (temp != null) {
            System.out.println("Data: " + temp.data + ", Priority: " + temp.priority);
            temp = temp.next;
        }
    }
}