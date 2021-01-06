package bai3_array_method.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size_a, size_b, size_result;
        int[] arr_a;
        int[] arr_b;
        int[] arr_result;

        System.out.print("SIZE first array: ");
        size_a = scanner.nextInt();
        arr_a = new int[size_a];
        for (int i = 0; i < size_a; i++) {
            System.out.print("Element " + i+": ");
            arr_a[i] = scanner.nextInt();
        }

        System.out.print("SIZE second array: ");
        size_b = scanner.nextInt();
        arr_b = new int[size_b];
        for (int i = 0; i < size_b; i++) {
            System.out.print("Element " + i+": ");
            arr_b[i] = scanner.nextInt();
        }

        size_result = size_a + size_b;
        arr_result = new int[size_result];
        for (int i = 0; i < arr_a.length; i++) {
            arr_result[i] = arr_a[i];
        }
        for (int i = 0; i < arr_b.length; i++) {
            arr_result[i + arr_a.length] = arr_b[i];
        }
        System.out.print("First array: ");
        for (int element : arr_a) {
            System.out.print(" " + element);
        }

        System.out.print("\nSecond array: ");
        for (int element : arr_b) {
            System.out.print(" " + element);
        }

        System.out.print("\nFinal array : ");
        for (int value : arr_result) {
            System.out.print(" " + value);
        }
    }
}
