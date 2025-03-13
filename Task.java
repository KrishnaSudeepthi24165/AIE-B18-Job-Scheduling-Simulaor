public class Task implements Comparable<Task> {
    int id;
    int priority;
    int burstTime;

    public Task(int id, int priority, int burstTime) {
        this.id = id;
        this.priority = priority;
        this.burstTime = burstTime;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority); /*It returns a negative integer if this.priority is less than other.priority.

        It returns zero if this.priority is equal to other.priority.
        
        It returns a positive integer if this.priority is greater than other.priority. */
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", priority=" + priority +
                ", burstTime=" + burstTime +
                '}';
    }
}
