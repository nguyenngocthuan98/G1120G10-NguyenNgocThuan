package bai14_sort_algorithm.thuc_hanh;

public class BubbleSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12, 25, 23, 24};
//    static int[] list = {2, 3, 4, 5, 6};

    static void bubbleSort(int[] list) {
        // giảm các thao tác so sánh và tráo đổi không cần thiết nếu như mảng này không cần sự tráo đổi nào nữa khi tất cả các phần tử đã được sắp xếp theo thứ tự rồi.
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        bubbleSort(list);
        for (Integer value : list) {
            System.out.print(value + " ");
        }
    }

}
