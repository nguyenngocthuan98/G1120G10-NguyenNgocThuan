package bai14_sort_algorithm.bai_tap;

import java.util.Arrays;

public class InsertSort {
    public static void insertSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int currentElement = list[i];
            int k;
            System.out.println("i = " + i + ", Current element = " + currentElement);
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                list[k + 1] = list[k];
                System.out.println("\tk >= 0 && list[k] > currentElement: " + list[k] + " > " + currentElement);
                System.out.println("\tlist[k+1] = list[k] = " + list[k + 1]);
            }
            list[k + 1] = currentElement;
        }
    }

    public static void main(String[] args) {
        int[] list = {33, 75, 59, 78, 1};
        insertSort(list);
        System.out.print("_________\nList after: " + Arrays.toString(list) + "\nList before: ");
        for (int listSorted : list) {
            System.out.print(listSorted + " ");
        }
    }
}
