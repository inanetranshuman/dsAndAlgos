package dsAndAlgos.linkedlist;

public class LinkedList {

    ListNode dummy = new ListNode(-1);

    public ListNode getHead() {
        return dummy.next;
    }

    public ListNode getTail() {
        ListNode node = dummy.next;
        while(node.next != null) {
            node = node.next;
        }

        return node;
    }

    public void addNode(ListNode node) {
        node.next = dummy.next;
        dummy.next = node;
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

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
