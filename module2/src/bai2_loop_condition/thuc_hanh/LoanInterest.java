package bai2_loop_condition.thuc_hanh;

import java.util.Scanner;

public class LoanInterest {
    //[Thực hành] Ứng dụng tính tiền lãi cho vay
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter loan amount: ");
        float loan_amount = sc.nextFloat();
        System.out.print("Enter interest rates in year: ");
        float interest_rate = sc.nextFloat();
        System.out.print("Enter number of month: ");
        short number_of_months = sc.nextShort();

        float result = 0;
        for (int index = 0; index < number_of_months; index++) {
            result += loan_amount * (interest_rate / 100) / 12 * number_of_months;
        }
        System.out.println("Loan interest after " + number_of_months + " months with interest rate " + interest_rate + "%/year is: " + result);
    }
}
