package dsAndAlgos.queue;

public class ArrayQueue {

    private int capacity;
    private int[] arry;
    private int rearPos = -1;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.arry = new int[capacity];
    }

    public int deQueue() {
        if(rearPos < 0) throw new RuntimeException("Underflow");
        int resp = arry[0];
        for(int i = 0; i < rearPos; i++) {
            arry[i] = arry[i + 1];
        }

        rearPos--;

        return resp;
    }

    public void enQueue(int i) {
        if(rearPos >= arry.length - 1) throw new RuntimeException("Overflow");
        arry[++rearPos] = i;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.enQueue(5);
        queue.enQueue(5);

        System.out.println(queue.deQueue());
    }
}
