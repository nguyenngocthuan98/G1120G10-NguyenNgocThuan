package bai2_loop_condition.bai_tap;

import java.util.Scanner;

public class DisplayTypes {
    public static void main(String[] args) {
        int choice = -1;
        int i = 1;
        Scanner input = new Scanner(System.in);

        while (choice != 0) {
            System.out.println("1. Draw the square");
            System.out.println("2. Draw the triangle botton-left");
            System.out.println("3. Draw the triangle top-left");
            System.out.println("4. Draw the isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Draw the square");
                    for (i = 1; i <= 3; i++) {
                        for (int j = 1; j <= 3; j++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    i = 1;
                    break;
                case 2:
                    System.out.println("Draw the triangle botton-left");
                    for (; i <= 5; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    i = 1;
                    break;
                case 3:
                    System.out.println("Draw the triangle top-left");
                    for (i = 5; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    i = 1;
                    break;
                case 4:
                    System.out.println("Draw the isosceles rectangle");
                    for (; i <= 5; i++) {
                        for (int j = i; j <= 5; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    i = 1;
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
