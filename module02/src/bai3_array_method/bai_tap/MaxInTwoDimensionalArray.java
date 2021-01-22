package bai3_array_method.bai_tap;

import java.util.Scanner;

public class MaxInTwoDimensionalArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr_size_x, arr_size_y;
        int[][] array;
        int max;

        do {
            System.out.print("Enter array length X: ");
            arr_size_x = sc.nextInt();
            System.out.print("Enter array length y: ");
            arr_size_y = sc.nextInt();

            if (arr_size_x <= 0 || arr_size_y <= 0) {
                System.out.println("Size for two dimensional array NOT invalid");
            }
        } while (arr_size_x <= 0 || arr_size_y <= 0);

        array = new int[arr_size_x][arr_size_y];
        for (int i = 0; i < arr_size_x; i++) {
            for (int j = 0; j < arr_size_y; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                array[i][j] = sc.nextInt();
            }
        }

        max = array[0][0];
        int count = 1;
        for (int i = 0; i < arr_size_x; i++) {
            for (int j = 0; j < arr_size_y; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    count = 1;
                } else if (array[i][j] == max) {
                    count++;
                }
            }
        }
        System.out.println("Have " + count + " biggest number in array is " + max );
    }
}
