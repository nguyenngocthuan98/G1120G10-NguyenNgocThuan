package bai11_dsa_stack_queue.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class CheckBrackets {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);

        System.out.print("Enter expression: ");
        String expression = cs.nextLine();
        boolean check = true;
        Stack<Character> stringStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                stringStack.push(expression.charAt(i));
            }
            if (expression.charAt(i) == ')') {
                if (!stringStack.isEmpty()) {
                    stringStack.pop();
                } else {
                    check = false;
                    break;
                }
            }
        }
        // (s – a) * (s – b) * (s – c)
        if (stringStack.isEmpty() && check) {
            System.out.println("expression well");
        } else {
            System.out.println("expression false");
        }
    }
}
