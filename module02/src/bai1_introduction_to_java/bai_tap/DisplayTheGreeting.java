package bai1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class DisplayTheGreeting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Hello " + name);
    }
}
