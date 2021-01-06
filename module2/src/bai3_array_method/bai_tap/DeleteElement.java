package bai3_array_method.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        int[] arrInts = {1, 5, 9, 8, 3, 2, 10, 4, 7};
        Scanner sc = new Scanner(System.in);
        int input;
        System.out.println("Before array: " + Arrays.toString(arrInts) + "\nEnter value to delete: ");
        input = sc.nextInt();
        for (int i = 0; i < arrInts.length; i++) {
            if (arrInts[i] != input) {
                continue;
            } else {
                arrInts[i] = arrInts[i + 1];
            }
            arrInts[i] = arrInts[i + 1];
        }
        System.out.println("After array: " + Arrays.toString(arrInts));
    }
}
