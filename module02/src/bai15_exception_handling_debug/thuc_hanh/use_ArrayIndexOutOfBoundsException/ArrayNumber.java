package bai15_exception_handling_debug.thuc_hanh.use_ArrayIndexOutOfBoundsException;

import java.util.Random;
import java.util.Scanner;

public class ArrayNumber {
    public static Integer[] createRandom() {
        Random randomNumber = new Random();
        Integer[] array = new Integer[100];
        System.out.println("List 100 numbers: ");
        for (int i = 0; i < 100; i++) {
            array[i] = randomNumber.nextInt(100);
            System.out.print(array[i] + " ");
        }
        return array;
    }

    public static void main(String[] args) {
        Integer[] array = ArrayNumber.createRandom();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter index: ");
        int input = sc.nextInt();
        try {
            System.out.println("In index = " + input + " have value = " + array[input]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Index over!");
        }
    }
}
