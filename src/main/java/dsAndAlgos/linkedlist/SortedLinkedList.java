package dsAndAlgos.linkedlist;

public class SortedLinkedList {

    ListNode start;

    public void insert(int val) {
        ListNode node = new ListNode(val);

        if(start == null) {
            start = node;
            return;
        }

        ListNode curNode = start;
        ListNode previous = null;
        while(curNode != null) {
            if(node.val < curNode.val) {
                if(previous == null) {
                    node.link = start;
                    start = node;
                    return;
                } else {
                    previous.link = node;
                    node.link = curNode;
                    return;
                }
            } else {
                previous = curNode;
                curNode = curNode.link;
            }
        }

        previous.link = node;
    }

    public static void main(String[] args) {
        SortedLinkedList sll = new SortedLinkedList();
        sll.insert(2);
        sll.printList();
        sll.insert(3);
        sll.insert(3);
        sll.insert(-1);
        sll.insert(6);
        sll.insert(1);
        sll.printList();
    }

    public void printList() {
        ListNode node = this.start;
        System.out.print("Sorted List:");
        while(node != null) {
            System.out.print(" " + node.val);
            node = node.link;
        }

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
