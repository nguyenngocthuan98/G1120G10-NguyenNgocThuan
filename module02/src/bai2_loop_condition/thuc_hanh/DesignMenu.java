package bai2_loop_condition.thuc_hanh;

import java.util.Scanner;

public class DesignMenu {
    public static void main(String[] args) {
        int choice = -1;
        int i = 1;
        Scanner input = new Scanner(System.in);

        while (choice != 0) {
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the square");
            System.out.println("3. Draw the rectangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Draw the triangle");
                    for (; i <= 5; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    i = 1;
                    break;
                case 2:
                    System.out.println("Draw the square");
                    for (i = 1; i <= 3; i++) {
                        for (int k = 1; k <= 3; k++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    i = 1;
                    break;
                case 3:
                    System.out.println("Draw the rectangle");
                    for (i = 1; i <= 3; i++) {
                        for (int k = 1; k <= 6; k++) {
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
