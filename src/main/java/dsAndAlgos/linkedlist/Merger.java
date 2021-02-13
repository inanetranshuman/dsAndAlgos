package dsAndAlgos.linkedlist;

import dsAndAlgos.linkedlist.LinkedList.ListNode;

public class Merger {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addNode(new ListNode(1));
        ll.addNode(new ListNode(4));
        ll.addNode(new ListNode(5));
        ll.addNode(new ListNode(10));
        LinkedList ll2 = new LinkedList();
        ll2.addNode(new ListNode(2));
        ll2.addNode(new ListNode(5));
        ll2.addNode(new ListNode(9));
        printLinkedList(ll);
        printLinkedList(ll2);
        // printLinkedList(mergeSortedNewList(ll, ll2));
        mergeIntoList(ll, ll2);
        printLinkedList(ll);
        // printLinkedList(ll2);

    }

    private static void printLinkedList(LinkedList ll) {
        ListNode node = ll.getHead();
        System.out.print("Linked list:");
        while(node != null) {
            System.out.print(" " + node.val);
            node = node.next;
        }
        System.out.println();
    }

    private static void mergeIntoList(LinkedList ll, LinkedList ll2) {
        ListNode node = ll.getHead();
        ListNode node2 = ll2.getHead();
        ListNode pm = ll.dummy;
        while(node != null && node2 != null) {
            if(node.val < node2.val) {
                pm.next = node2;
                pm = pm.next;
                node2 = node2.next;
            } else {
                pm.next = node;
                pm = pm.next;
                node = node.next;
            }
        }

        if(node != null)
            pm.next = node;
        else if(node2 != null) pm.next = node2;
    }

    private static LinkedList mergeSortedNewList(LinkedList ll, LinkedList ll2) {
        LinkedList nll = new LinkedList();
        ListNode node = ll.getHead();
        ListNode node2 = ll2.getHead();
        ListNode next = null;
        while(node != null || node2 != null) {
            if(node == null) {
                next = node2.next;
                node2.next = null;
                nll.addNode(node2);
                node2 = next;
                continue;
            }

            if(node2 == null) {
                next = node.next;
                node.next = null;
                nll.addNode(node);
                node = next;
                continue;
            }

            if(node.val > node2.val) {
                next = node.next;
                node.next = null;
                nll.addNode(node);
                node = next;
            } else {
                next = node2.next;
                node2.next = null;
                nll.addNode(node2);
                node2 = next;
            }
        }

        return nll;
    }
}
