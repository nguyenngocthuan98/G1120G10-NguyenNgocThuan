package bai3_array_method.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class BiggestInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input_arr_length;
        int[] array;
        int max;

        do {
            System.out.print("Enter array length:");
            input_arr_length = sc.nextInt();
            if (input_arr_length > 20) {
                System.out.println("Over 20 elements");
            }
        } while (input_arr_length > 20);

        array = new int[input_arr_length];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter element " + i + " :");
            array[i] = sc.nextInt();
        }

        max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        System.out.println("Your array: " + Arrays.toString(array));
        System.out.println("Biggest number in array is " + max);
    }
}
