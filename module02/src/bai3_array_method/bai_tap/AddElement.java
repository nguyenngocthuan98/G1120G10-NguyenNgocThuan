package bai3_array_method.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrInt = {2, 41, 5, 45, 22, 74, 9, 52};
        System.out.println("Your array: " + Arrays.toString(arrInt));
        System.out.print("Enter number: ");
        int number_insert = scanner.nextInt();
        System.out.print("Enter index: ");
        int index_insert = scanner.nextInt();

        if (index_insert < 0 || index_insert > arrInt.length - 1) {
            System.out.print("Index not found");
        } else {
            arrInt = insertElement(arrInt, number_insert, index_insert);
            System.out.print("After array: ");
            for (int af_arrInt : arrInt) {
                System.out.print(af_arrInt + " ");
            }
        }
    }

    public static int[] insertElement(int[] arr, int number_insert, int index_insert) {
        int length = arr.length;
        int[] arr_result = new int[length + 1];
        System.arraycopy(arr, 0, arr_result, 0, index_insert);
        arr_result[index_insert] = number_insert;
        System.arraycopy(arr, index_insert, arr_result, index_insert + 1, length - index_insert);
        return arr_result;
    }
}
