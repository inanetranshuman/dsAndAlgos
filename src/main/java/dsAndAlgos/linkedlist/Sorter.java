package dsAndAlgos.linkedlist;

import dsAndAlgos.linkedlist.LinkedList.ListNode;

public class Sorter {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addNode(new ListNode(4));
        ll.addNode(new ListNode(22));
        ll.addNode(new ListNode(6));
        ll.addNode(new ListNode(2));
        ll.addNode(new ListNode(8));
        ll.addNode(new ListNode(11));
        ll.addNode(new ListNode(1));

        printLinkedList(ll);
        // sortByData(ll);
        sortByLinks(ll);
        printLinkedList(ll);
    }

    private static void printLinkedList(LinkedList ll) {
        ListNode node = ll.getHead();
        int counter = 1;
        while(node != null) {
            System.out.println(counter + ": " + node.val);
            node = node.next;
            counter++;
        }
    }

    private static void sortByData(LinkedList ll) {
        ListNode node = null;
        ListNode next = null;

        for(ListNode end = null; end != ll.getHead().next; end = node) {
            for(node = ll.getHead(); node.next != end; node = node.next) {
                next = node.next;
                if(node.val > next.val) {
                    int tmp = node.val;
                    node.val = next.val;
                    next.val = tmp;
                }

            }
        }

    }

    private static void sortByLinks(LinkedList ll) {
        ListNode node = null;
        ListNode next = null;
        ListNode previous = ll.dummy;
        for(ListNode end = null; end != ll.getHead().next; end = node) {
            for(node = ll.getHead(); node.next != end; node = node.next) {
                next = node.next;
                if(node.val > next.val) {
                    node.next = next.next;

                    next.next = node;

                    if(node == ll.getHead())
                        ll.dummy.next = next;
                    else
                        previous.next = next;

                    node = next;

                }

                previous = node;

            }
        }
    }

}
