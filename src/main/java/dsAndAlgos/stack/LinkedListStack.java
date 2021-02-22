package dsAndAlgos.stack;

import dsAndAlgos.linkedlist.LinkedList;
import dsAndAlgos.linkedlist.LinkedList.ListNode;

public class LinkedListStack {

    LinkedList ll;

    public LinkedListStack() {
        ll = new LinkedList();
    }

    public void push(int val) {
        ll.addNode(new ListNode(val));
    }

    public int pop() {
        ListNode node = ll.getHead();
        ll.delete(node.val);
        return node.val;
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
