package bai1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year:");
        int input_year = sc.nextInt();

        if (input_year % 100 == 0){
            if (input_year % 400 == 0){
                System.out.println("This is leap year");
            } else {
                System.out.println("This ISN'T leap year");
            }
        } else if (input_year % 4 == 0){
            System.out.println("This is leap year");
        }
    }
}
