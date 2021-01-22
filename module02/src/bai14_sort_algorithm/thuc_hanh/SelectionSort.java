package bai14_sort_algorithm.thuc_hanh;

public class SelectionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    static void selectionSort(double[] list) {
        for (int i = 0; i < list.length -1; i++) {
            double maxValue = list[i];
            int maxIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (maxValue < list[j]) {
                    maxValue = list[j];
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                list[maxIndex] = list[i];
                list[i] = maxValue;
            }
        }
    }

    public static void main(String[] args) {
        selectionSort(list);
        for (double value : list) System.out.print(value + ", ");
    }
}
