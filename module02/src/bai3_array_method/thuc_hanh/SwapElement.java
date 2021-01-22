package bai3_array_method.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class SwapElement {
    //[Thực hành] Đảo ngược các phần tử của mảng
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array;
        int arr_length;
        do {
            System.out.print("Enter array length:");
            arr_length = sc.nextInt();
            if (arr_length > 20){
                System.out.println("Over 20 elements!");
            }
        } while (arr_length > 20);

        array = new int[arr_length];
        for (int i = 0; i < arr_length; i++){
            System.out.print("Enter " + (i+1) + "th element: ");
            array[i] = sc.nextInt();
        }
        System.out.print("Your array is: ");
        for (int arr : array){
            System.out.print(arr + " ");
        }
        //swap
        int temp;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < i; j++){
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        System.out.println("\nYour array after swap: " + Arrays.toString(array));
    }
}
