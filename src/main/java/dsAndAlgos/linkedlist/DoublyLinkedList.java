package dsAndAlgos.linkedlist;

import dsAndAlgos.linkedlist.LinkedList.ListNode;

public class DoublyLinkedList {

    DoublyNode start;
    DoublyNode tail;

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertHead(new DoublyNode(3));
        dll.insertHead(new DoublyNode(4));
        dll.insertHead(new DoublyNode(5));
        dll.insertHead(new DoublyNode(6));
        dll.printLinkedList();

        DoublyLinkedList dll2 = new DoublyLinkedList();
        dll2.insertTail(new DoublyNode(3));
        dll2.insertTail(new DoublyNode(4));
        dll2.insertTail(new DoublyNode(5));
        dll2.insertTail(new DoublyNode(6));
        dll2.printLinkedList();

        dll2.delete(new DoublyNode(6));
        dll2.printLinkedList();

    }

    public void printLinkedList() {
        DoublyNode node = this.start;
        System.out.print("Linked list:");
        while(node != null) {
            System.out.print(" " + node.val);
            node = node.next;
        }
        System.out.println();
    }

    public void insertHead(DoublyNode node) {
        if(start != null) {
            node.next = start;
            start.previous = node;
        }
        start = node;

        if(tail == null) tail = node;
    }

    public void insertTail(DoublyNode node) {
        if(start == null) start = node;

        node.previous = tail;
        node.next = null;
        if(tail != null) {
            tail.next = node;
        }

        tail = node;
    }

    public void delete(DoublyNode targetNode) {
        DoublyNode node = start;
        while(node != null) {
            if(targetNode.val == node.val) {
                if(node.previous != null)
                    node.previous.next = node.next;
                else
                    start = node.next;

                if(node.next != null) node.next.previous = node.previous;

                if(tail.equals(node)) tail = node.previous;

                break;
            }
            node = node.next;
        }
    }

    static class DoublyNode {

        int val;
        DoublyNode next;
        DoublyNode previous;

        public DoublyNode(int val) {
            this.val = val;
            this.next = null;
            this.previous = null;
        }
    }
}
