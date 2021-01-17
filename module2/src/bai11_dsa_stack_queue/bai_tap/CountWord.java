package bai11_dsa_stack_queue.bai_tap;

import java.util.Set;
import java.util.TreeMap;

public class CountWord {
    public static void countingWord(String str) {
        TreeMap<String, Integer> tree = new TreeMap<>();
        String[] arrayStr = str.split(" ");

        for (String word : arrayStr) {
            if (!tree.containsKey(word)) {
                tree.put(word, 1);
            } else {
                tree.put(word, (tree.get(word) + 1));
            }
        }

        Set<String> ketSet = tree.keySet();
        for (String key : ketSet) {
            System.out.println("'" + key + "' (" + tree.get(key) + ")");
        }
    }

    public static void main(String[] args) {
        String str = "chương trình đếm các lần xuất hiện của từ trong trong một chuỗi sử dụng map và hiển thị các từ và sự xuất hiện của chúng theo thứ tự trong bảng chữ cái của các từ";
        countingWord(str);
    }
}
