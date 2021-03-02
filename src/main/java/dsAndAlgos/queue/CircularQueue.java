package dsAndAlgos.queue;

import java.util.Arrays;

public class CircularQueue {

    public int[] arry;
    private int front = 0;
    private int rear = 0;

    public CircularQueue(int capacity) {
        arry = new int[capacity];
    }

    public void enQueue(int i) {
        arry[rear++] = i;
        if(rear > arry.length - 1) rear = 0;
    }

    public int deQueue() {
        int i = arry[front++];
        if(front > arry.length - 1) front = 0;

        return i;
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.enQueue(2);
        System.out.println(Arrays.toString(cq.arry));
        cq.enQueue(10);
        System.out.println(Arrays.toString(cq.arry));
        cq.enQueue(7);
        System.out.println(Arrays.toString(cq.arry));
        cq.enQueue(8);
        System.out.println(Arrays.toString(cq.arry));
        cq.enQueue(9);

        System.out.println(Arrays.toString(cq.arry));
        cq.enQueue(10);
        System.out.println(cq.deQueue());
        System.out.println(cq.deQueue());
        System.out.println(cq.deQueue());
        System.out.println(cq.deQueue());

    }
}
