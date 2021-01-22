package bai2_loop_condition.thuc_hanh;

import java.util.Scanner;

public class GreatestCommonDivisor {
    //[Thực hành] Tìm ước số chung lớn nhất
    public static void main(String[] args) {
        // a % b == 0 --> a là bội của b, b là ước của a
        // ƯỚc số chung lớn nhất của a và b là b khi b là ước của cả a và b.
        // Khi a và b = 0 thì không có ước số chung lớn nhất (mọi số != 0 đều là ước chung của a và b)
        // Nếu a hoặc b bằng 0 thì ước số chung lớn nhất bằng trị tuyệt đối của số khác 0

        Scanner nhap = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int a = nhap.nextInt();
        System.out.print("Enter the second number: ");
        int b = nhap.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 && b == 0) {
            System.out.print("No greatest common factor");
        } else if (a == 0) {
            System.out.print("Greatest common factor: " + b);
        } else if (b == 0) {
            System.out.print("Greatest common factor: " + a);
        } else {
            while (a != b) {
                if (a > b) a -= b; //a = a - b
                else b -= a; //b = b - a
            }
            System.out.print("Greatest common factor: " + a);
        }
    }
}
