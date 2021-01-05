package bai2_loop_condition.bai_tap;

import java.util.Scanner;

public class Display20Prime {
    //[Bài tập] Hiển thị 20 số nguyên tố đầu tiên
    static boolean isPrime(int nto) {
        //Với một số nguyên dương nto lớn hơn 1,
        if (nto < 2) {
            return false;
        }
        //Kiểm tra từ  2 đến căn bậc 2 của nto.
        for (int i = 2; i <= Math.sqrt(nto); i++) {
            //Nếu nto chia hết cho một số trong khoảng đó thì nto không phải là số nguyên tố,
            if (nto % i == 0) {
                return false;
            }
        }
        //Ngược lại A là số nguyên tố.
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of prime:");
        //Khai báo biến số nguyên numbers và nhập cho nó một giá trị từ bàn phím để lưu số lượng số nguyên tố cần in ra.
        int numbers = sc.nextInt();
        //Khai báo biến count và gán cho nó giá trị 0, biến này để đếm xem số lượng lượng số nguyên tố cần in ra đã bằng numbers hay chưa.
        int count = 0;
        //Khai báo biến N và gán cho giá trị 2, biến này để kiểm tra xem các giá trị nó nhận được có phải là số nguyên tố không, mỗi lần lặp giá trị của biến sẽ được tăng lên 1.
        int n = 2;
        while (count < numbers) {
            if (isPrime(n)) {
                System.out.print(n + " | ");
                count++;
            }
            n++;
        }
    }
}
