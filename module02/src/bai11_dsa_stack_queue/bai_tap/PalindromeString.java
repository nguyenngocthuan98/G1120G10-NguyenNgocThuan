package bai11_dsa_stack_queue.bai_tap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);

        System.out.print("Enter string: ");
        String inputString = cs.nextLine();

        Stack<Character> stringStack = new Stack<>();
        Queue<Character> stringQueue = new LinkedList<>();

        for (int i = 0; i < inputString.length(); i++) {
            stringStack.push(inputString.charAt(i));
            stringQueue.add(inputString.charAt(i));
        }

        boolean check = true;
        for (int i = 0; i < stringQueue.size(); i++) {
            if (stringStack.pop() != stringQueue.poll()) {
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("palindrome string");
        } else {
            System.out.println("not a palindrome string");
        }
    }
}
