package bai11_dsa_stack_queue.bai_tap.reverse_elements_stack;

import java.util.Stack;

public class ReverseInteger {
    public static void main(String[] args) {
        int[] array = new int[]{-2, 62, 58, 22, 17, 21};
        Stack<Integer> stackInteger = new Stack<>();

        for (int item : array) {
            stackInteger.push(item);
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = stackInteger.pop();
        }

        System.out.println("After reverse:");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
