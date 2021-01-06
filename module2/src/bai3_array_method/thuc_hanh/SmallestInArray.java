package bai3_array_method.thuc_hanh;

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
        int []arr = {4, 12, 7, 8, 1, 6, 9};
        System.out.println("Smallest number in array is: " + minFunction(arr));
    }
}
