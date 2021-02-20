package dsAndAlgos.linkedlist;

import dsAndAlgos.linkedlist.DoublyLinkedList.DoublyNode;

public class CircularLinkedList {

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertNode(new ListNode(1));
        cll.insertNode(new ListNode(2));
        cll.insertNode(new ListNode(3));
        cll.insertNode(new ListNode(4));
        cll.insertNode(new ListNode(5));

        cll.printList();

        System.out.println(cll.getFirstIn());
        cll.printList();

        System.out.println(cll.getFirstIn());
        cll.printList();
    }

    ListNode last;

    public void insertNode(ListNode node) {
        if(last == null) {
            last = node;
            node.link = node;
            return;
        }
        node.link = last.link;
        last.link = node;
        last = node;
    }

    public int getFirstIn() {
        int resp = last.link.val;
        last.link = last.link.link;
        return resp;
    }

    public void printList() {
        ListNode node = this.last.link;
        System.out.print("Circular List:");
        do {
            System.out.print(" " + node.val);
            node = node.link;
        }
        while(node != last.link);

        System.out.println();
    }

    public static class ListNode {

        int val;
        ListNode link;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
