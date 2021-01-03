package bai1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        System.out.println("~~ Exchange rate USD and VND today: 1 USD = 23176.28 VND ~~");
        System.out.print("Enter USD: ");
        Scanner sc = new Scanner(System.in);
        float input = sc.nextFloat();
        float output = input * 23176.28f;
        System.out.println(input + " USD = " + output + " VND");
    }
}
