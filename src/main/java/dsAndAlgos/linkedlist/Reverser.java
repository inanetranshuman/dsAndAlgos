package dsAndAlgos.linkedlist;

import dsAndAlgos.linkedlist.LinkedList.ListNode;

public class Reverser {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addNode(new ListNode(4));
        ll.addNode(new ListNode(5));
        ll.addNode(new ListNode(6));
        ll.addNode(new ListNode(7));
        ll.addNode(new ListNode(8));
        ll.addNode(new ListNode(9));
        ll.addNode(new ListNode(10));

        System.out.println("Head: " + ll.getHead().val);
        System.out.println("Tail: " + ll.getTail().val);

        reverse(ll);

        System.out.println("Head: " + ll.getHead().val);
        System.out.println("Tail: " + ll.getTail().val);

    }

    private static void reverse(LinkedList ll) {
        ListNode node = ll.getHead();
        ListNode previous = null;
        while(node != null) {
            ListNode next = node.next;
            node.next = previous;
            previous = node;
            node = next;
        }

        ll.dummy.next = previous;
    }
}
