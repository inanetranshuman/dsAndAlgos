package dsAndAlgos.queue;

import java.util.Arrays;

public class Deque {
    private int front = -1;
    private int rear = -1;
    private int[] queue;
    private int capacity;

    public Deque(int capacity) {
        this.queue = new int[capacity];
        this.capacity = capacity;
    }

    public void addToFront(int val) {
        if (rear == -1)
            rear = 0;

        if (front == -1)
            front=0;
        else if (front == 0)
            front = capacity-1;
        else
            front--;
        queue[front] = val;

    }

    public void addToRear(int val) {
        if (front == -1)
            front = 0;

        if (rear == -1 || rear == capacity-1)
            rear=0;
        else
            rear++;

        queue[rear] = val;
    }

    public int deleteFromFront() {
        int val = queue[front];
        if (front == capacity - 1)
            front = 0;
        else
            front++;
        return val;
    }

    public int deleteFromRear() {
        int val = queue[rear];
        if (rear == 0)
            rear = capacity-1;
        else
            rear--;

        return val;
    }

    public boolean isFull() {
        return (front == 0 && rear == capacity-1) ||
                (front == rear+1);
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void display() {
        System.out.println(Arrays.toString(queue));
    }

    public static void main(String[] args) {
        Deque dq = new Deque(10);
        dq.addToFront(5);
        dq.addToFront(3);
        dq.addToFront(2);
        dq.addToRear(7);
        dq.addToRear(8);
        dq.display();

        System.out.println(dq.deleteFromFront());
        System.out.println(dq.deleteFromFront());
        System.out.println(dq.deleteFromRear());
        System.out.println(dq.deleteFromRear());
        dq.display();
    }

}
