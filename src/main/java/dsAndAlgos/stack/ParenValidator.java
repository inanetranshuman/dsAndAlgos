package dsAndAlgos.stack;

import java.util.Stack;

public class ParenValidator {
    Stack<Character> charStack = new Stack();

    public boolean validate(String stmt) {
        for (int i=0; i < stmt.length(); i++) {
            Character c = stmt.charAt(i);
            if (c == ']' || c == '}' || c == ')') {
                Character sc = charStack.pop();
                if (c == ']' && sc != '[')
                    return false;
                else if (c == '}' && sc != '{')
                    return false;
                else if (c == ')' && sc != '(')
                    return false;
            } else if (c == '[' || c == '{' || c == '(') {
                charStack.push(c);
            } else {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ParenValidator().validate("[({})]"));
        System.out.println(new ParenValidator().validate("[({}})]"));
    }



}
