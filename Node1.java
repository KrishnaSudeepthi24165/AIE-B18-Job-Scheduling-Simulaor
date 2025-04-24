class Node1 {
    String processName;
    int burstTime;
    int remainingTime;
    Node next;

    public Node1(String processName, int burstTime) {
        this.processName = processName;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.next = null;
    }
}

