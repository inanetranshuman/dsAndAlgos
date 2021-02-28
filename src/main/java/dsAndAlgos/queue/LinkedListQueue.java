package dsAndAlgos.queue;

public class LinkedListQueue {

    public static void main(String[] args) {
        LinkedListQueue llq = new LinkedListQueue();
        llq.enQueue(4);
        llq.enQueue(3);
        llq.enQueue(5);
        System.out.println(llq.deQueue());
        System.out.println(llq.deQueue());
        llq.enQueue(15);
        System.out.println(llq.deQueue());
        System.out.println(llq.deQueue());
    }

    LinkedList ll = new LinkedList();

    public void enQueue(int val) {
        ll.addToTail(val);
    }

    public int deQueue() {
        ListNode head = ll.removeHead();
        if(head == null)
            return -1;
        else
            return head.val;
    }

    class LinkedList {

        private ListNode head;
        private ListNode tail;

        public ListNode removeHead() {
            if(head == null) return null;
            ListNode current = head;
            head = current.next;
            current.next = null;
            return current;
        }

        public void addToTail(int val) {
            ListNode node = new ListNode(val);
            if(tail != null) tail.next = node;
            tail = node;
            if(head == null) head = tail;
        }
    }

    class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
