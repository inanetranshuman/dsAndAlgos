package dsAndAlgos.linkedlist;

import dsAndAlgos.linkedlist.LinkedList.ListNode;

public class Traverser {

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

        System.out.println("2nd to last: " + find2ndToLast(ll).val);

        System.out.println("1st: " + getByPos(ll, 1).val);
        System.out.println("2nd: " + getByPos(ll, 2).val);
        System.out.println("3rd: " + getByPos(ll, 3).val);
        ll.delete(8);
        System.out.println("1st: " + getByPos(ll, 1).val);
        System.out.println("2nd: " + getByPos(ll, 2).val);
        System.out.println("3rd: " + getByPos(ll, 3).val);

    }

    private static ListNode getByPos(LinkedList ll, int i) {
        ListNode node = ll.getHead();
        while(node != null && i > 0) {
            node = node.next;
            i--;

        }

        return node;
    }

    private static ListNode find2ndToLast(LinkedList ll) {
        ListNode node = ll.getHead();
        while(node.next.next != null)
            node = node.next;

        return node;
    }

}
