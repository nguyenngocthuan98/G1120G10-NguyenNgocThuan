package bai17_io_binary_file_serialization.bai_tap.product_manager_file_binary.service;

public class cc {
    public static void main(String[] args) {
        String x = "   CodeGym_Viet_Nam    ";
        x = x.trim();
        int index = x.indexOf("_");
        String y = x.substring(0, index);
        System.out.println(y);

        String xa = "user@fpt.edu.vn";
        String ya = "\\w+@\\w+(\\.\\w+){1,2}";
        if(xa.matches(ya)){
            System.out.print("A");
        }
        else{
            System.out.print("B");
        }
    }
}
