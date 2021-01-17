package bai11_dsa_stack_queue.bai_tap.reverse_elements_stack;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        Stack<String> stackString = new Stack<>();

        String inputString = "Đảo ngược phần tử trong mảng số nguyên sử dụng Stack";
        String[] strings = inputString.split(" ");

        for (String s : strings) {
            stackString.push(s);
        }

        for (int i = 0; i < strings.length; i++) {
            strings[i] = stackString.pop();
        }

        System.out.println("Before reverse:\n" + inputString + "\nAfter reverse:");
        for (String value : strings) {
            System.out.print(value + " ");
        }
    }
}
