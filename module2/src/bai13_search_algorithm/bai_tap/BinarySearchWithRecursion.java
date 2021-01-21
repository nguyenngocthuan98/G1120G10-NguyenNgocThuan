package bai13_search_algorithm.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchWithRecursion {
    public static int searchRecursive(int[] array, int low, int high, int value) {
        if (high >= low) {
            int middle = low + (high - low) / 2;
            if (value == array[middle]) {
                return middle;  //be like index
            } else if (value > array[middle]) {
                return searchRecursive(array, middle + 1, high, value);
            } else {
                return searchRecursive(array, low, middle - 1, value);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 11, 13, 14, 16};
        int lower = 0;
        int higher = arr.length - 1;
        Scanner scan = new Scanner(System.in);
        System.out.print(Arrays.toString(arr)+"\nInput number you want to check: ");
        int valueInput = scan.nextInt();

        if (searchRecursive(arr, lower, higher, valueInput) == -1) {
            System.out.println(valueInput + " not exist");
        } else {
            System.out.println(valueInput + " exist in index is " + searchRecursive(arr, lower, higher, valueInput));
        }
    }
}
