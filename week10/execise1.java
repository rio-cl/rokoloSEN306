package week10;

public class execise1 implements QueueADT {

    private Node head;
    private Node tail;
    private int count;

    // Node class
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public void enqueue(int element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        count++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty");
        }

        int value = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        count--;

        return value;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    // Main method for testing
    public static void main(String[] args) {

        execise1 queue = new execise1();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue size: " + queue.size());

        System.out.println("Removed: " + queue.dequeue());

        System.out.println("Queue size after dequeue: " + queue.size());
    }
}

// Queue Interface
interface QueueADT {
    void enqueue(int element);
    int dequeue();
    boolean isEmpty();
    int size();
}