package dsAndAlgos.linkedlist;

import dsAndAlgos.linkedlist.LinkedList.ListNode;

public class CycleDetector {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addNodeToTail(new ListNode(18));
        ll.addNodeToTail(new ListNode(5));
        ListNode node = new ListNode(8);
        ll.addNodeToTail(node);
        ll.addNodeToTail(new ListNode(6));
        ll.addNodeToTail(new ListNode(24));
        ll.addNodeToTail(new ListNode(4));
        ll.addNodeToTail(node);
        ll.addNodeToTail(new ListNode(1));
        printLinkedList(ll.getHead());
        System.out.println("Cycle: " + hasCycle(ll.getHead()));
        removeCycle(ll.getHead());
        System.out.println("Cycle: " + hasCycle(ll.getHead()));
        printLinkedList(ll.getHead());

    }

    private static void printLinkedList(ListNode node) {
        System.out.print("Linked list:");
        while(node != null) {
            System.out.print(" " + node.val);
            node = node.next;
        }
        System.out.println();
    }

    private static boolean hasCycle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }

    private static ListNode findCycle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return slow;
        }

        return null;
    }

    private static void removeCycle(ListNode node) {
        ListNode start = node;
        ListNode cycleNode = findCycle(node);

        ListNode ptrNode = cycleNode;
        ListNode ptr2Node = cycleNode;
        int cycleLength = 0;
        do {
            ptrNode = ptrNode.next;
            cycleLength++;
        }
        while(ptr2Node != ptrNode);

        int remainderLength = 0;
        ptr2Node = start;
        while(ptrNode != ptr2Node) {
            ptrNode = ptrNode.next;
            ptr2Node = ptr2Node.next;
            remainderLength++;
        }

        System.out.println("Cycle length: " + cycleLength);
        System.out.println("Remainder length: " + remainderLength);
        int totalLength = cycleLength + remainderLength;
        ptrNode = start;
        for(int i = 0; i < totalLength; i++) {
            ptrNode = ptrNode.next;
        }

        ptrNode.next = null;

    }
}
