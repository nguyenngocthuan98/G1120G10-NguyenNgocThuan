package bai13_search_algorithm.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class FindConsecutiveStringMaxLength {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<Character> maxLength = new LinkedList<>();
        System.out.println("Enter string: ");
        String inputString = in.nextLine();
        for (int i = 0; i < inputString.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(inputString.charAt(i));
            for (int j = i + 1; j < inputString.length(); j++) {
                if (inputString.charAt(j) > list.getLast()) {
                    list.add(inputString.charAt(j));
                } else {
                    break;
                }
            }

            if (list.size() > maxLength.size()) {
                maxLength.clear();
                maxLength.addAll(list);
            }
            list.clear();
        }

        // Display the maximum consecutive
        // increasingly ordered substring
        for (Character ch : maxLength) { // single loop
            System.out.print(ch); // Simple statement
        }

    }
}
