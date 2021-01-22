package bai3_array_method.thuc_hanh;

import java.util.Scanner;

public class Temperature {
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (5.0 / 9) * (fahrenheit - 32);
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (9.0 / 5) * (celsius - 32);
    }

    public static void main(String[] args) {
        byte choose;
        double inputC, inputF;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Menu\n" +
                    "1. Fahrenheit to Celsius\n" +
                    "2. Celsius to Fahrenheit\n" +
                    "0. Exit ");
            choose = sc.nextByte();
            switch (choose) {
                case 1:
                    System.out.print("Enter fahrenheit: ");
                    inputF = sc.nextDouble();
                    System.out.println(fahrenheitToCelsius(inputF));
                    break;
                case 2:
                    System.out.print("Enter celsius: ");
                    inputC = sc.nextDouble();
                    System.out.println(celsiusToFahrenheit(inputC));
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (choose != 0);
    }
}
