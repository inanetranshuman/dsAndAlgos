package dsAndAlgos.linkedlist;

import dsAndAlgos.linkedlist.LinkedList.ListNode;

public class MergeSort {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addNode(new ListNode(18));
        ll.addNode(new ListNode(5));
        ll.addNode(new ListNode(6));
        ll.addNode(new ListNode(24));
        ll.addNode(new ListNode(8));
        ll.addNode(new ListNode(4));
        ll.addNode(new ListNode(1));
        printLinkedList(mergeSort(ll.getHead()));
    }

    private static void printLinkedList(ListNode node) {
        System.out.print("Linked list:");
        while(node != null) {
            System.out.print(" " + node.val);
            node = node.next;
        }
        System.out.println();
    }

    private static ListNode mergeSort(ListNode node) {
        if(node == null || node.next == null) return node;
        ListNode node1 = node;
        ListNode node2 = divideList(node);
        node1 = mergeSort(node1);
        node2 = mergeSort(node2);
        return merge(node1, node2);
    }

    private static ListNode divideList(ListNode node) {
        ListNode fastNode = node.next.next;
        while(fastNode != null && fastNode.next != null) {
            node = node.next;
            fastNode = fastNode.next.next;
        }

        ListNode node2 = node.next;
        node.next = null;
        return node2;
    }

    private static ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(node1 != null && node2 != null) {
            if(node1.val < node2.val) {
                tail.next = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
            }

            tail = tail.next;

        }

        if(node1 != null) {
            tail.next = node1;
        }

        if(node2 != null) {
            tail.next = node2;
        }

        return dummy.next;
    }
}
