package dsAndAlgos.linkedlist;

public class LinkedList {

    ListNode dummy = new ListNode(-1);
    ListNode tail = null;

    public ListNode getHead() {
        return dummy.next;
    }

    public ListNode getTail() {
        if(tail != null) return tail;

        ListNode node = dummy.next;
        while(node.next != null) {
            node = node.next;
        }

        return node;
    }

    public void addNode(ListNode node) {
        if(tail == null) tail = node;
        node.next = dummy.next;
        dummy.next = node;

    }

    public void addNodeToTail(ListNode node) {
        if(tail == null) {
            tail = node;
            dummy.next = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void delete(int val) {
        ListNode node = getHead();
        ListNode previous = dummy;
        while(node != null) {
            if(node.val == val) {
                previous.next = node.next;
                break;
            }
            previous = node;
            node = node.next;
        }
    }

    public static class ListNode {

        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
