package dsAndAlgos.stack;

public class ArrayStack {

    int[] arry;
    int top = 0;

    public ArrayStack(int size) {
        this.arry = new int[size];
    }

    public void push(int val) {
        if(top >= arry.length) throw new RuntimeException("Overflow");

        arry[top++] = val;
    }

    public int pop() {
        if(top <= 0) throw new RuntimeException("Underflow");
        return arry[--top];
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
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
