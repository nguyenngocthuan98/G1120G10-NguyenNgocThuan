package bai11_dsa_stack_queue.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        System.out.print("Enter number: ");
        int decimal = cs.nextInt();
        Stack<Integer> elements = new Stack<>();
        StringBuilder result = new StringBuilder();
        while (decimal != 0) {
            elements.push(decimal % 2);
            decimal = decimal / 2;
        }
        while (!elements.isEmpty()) {
            result.append(elements.pop());
        }

        System.out.println("Result = " + result);
    }
}
