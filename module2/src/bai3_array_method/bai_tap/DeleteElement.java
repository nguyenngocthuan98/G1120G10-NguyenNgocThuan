package bai3_array_method.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        int[] arrInts = {1, 5, 9, 9, 8, 9, 10, 4, 7};
        Scanner sc = new Scanner(System.in);
        boolean checked = true;
        int input;
        System.out.println("Before array: " + Arrays.toString(arrInts) + "\nEnter value to delete: (recommended 9) ");
        input = sc.nextInt();
        for (int i = 0; i < arrInts.length; i++) {
            if (input == arrInts[i]) {
                for (int j = i; j < arrInts.length - 1; j++) {
                    arrInts[j] = arrInts[j + 1];
                }
                i--;
                arrInts[arrInts.length - 1] = 0;
            } else {
                checked = false;
            }
        }
        if (checked) {
            System.out.println("This number not found");
        }
        System.out.println("After array: " + Arrays.toString(arrInts));
    }
}
