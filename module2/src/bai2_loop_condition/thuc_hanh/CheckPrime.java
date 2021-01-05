package bai2_loop_condition.thuc_hanh;

import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        //Kiểm tra số nguyên tố
        Scanner sc = new Scanner(System.in);
        boolean checked = true;
        System.out.println("Enter your number: ");
        int input_number = sc.nextInt();
        if (input_number < 2) {
            System.out.println(input_number + " is not a primre!"); //số bé hơn 2 thì không là số nguyên tố
        } else {
            //Với một số nguyên dương A lớn hơn 1, kiểm tra từ  2 đến căn bậc 2 của A.
            //Nếu A chia hết cho một số trong khoảng đó thì A không phải là số nguyên tố, ngược lại A là số nguyên tố.
            int i = 2;
            while (i < Math.sqrt(input_number)) {
                if (input_number % i == 0) {
                    checked = false;
                    break;
                }
                i++;
            }
        }
        if (checked)
            System.out.println(input_number + " is a prime!");
        else
            System.out.println(input_number + " is not a prime!");
    }
}
