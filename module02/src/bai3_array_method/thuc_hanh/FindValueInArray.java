package bai3_array_method.thuc_hanh;

import java.util.Scanner;

public class FindValueInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        System.out.print("Enter value: ");
        String input = sc.nextLine();

        for (int i = 0; i < students.length; i++){
            if (input.equals(students[i])){
                System.out.println(input + " have been found in array in index = " + i);
                check = true;
                break;
            } else {
                check = false;
            }
        }
        if (!check){
            System.out.println(input + " not found!");
        }
    }
}
