package bai3_array_method.bai_tap;

import java.util.Scanner;

public class SmallestInArray {
    public static int minFunction(int[] arr) {
        int min = arr[0];
        for (int value : arr) {
            if (min > value) {
                min = value;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = sc.nextInt();
        if (size < 0) {
            System.out.println("Size not invalid");
        } else {
            arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                System.out.print("Element " + i + ": ");
                arr[i] = sc.nextInt();
            }
            System.out.println("Smallest number in array is: " + minFunction(arr));
        }

    }
}
