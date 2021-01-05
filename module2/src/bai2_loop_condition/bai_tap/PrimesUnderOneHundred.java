package bai2_loop_condition.bai_tap;

public class PrimesUnderOneHundred {
    //[Bài tập] Hiển thị số nguyên tố bé hơn 100
    static boolean isPrime(int nto) {
        if (nto < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(nto); i++) {
            if (nto % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //chưa làm xong
    }
}
