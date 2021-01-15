package bai10_dsa_list.thuc_hanh.simple_list;

import java.util.Arrays;

/*
 * chương trình cho phép cài đặt cấu trúc List đơn giản sử dụng generic để lưu một tập dữ liệu bất kỳ.
 */
public class MyList<E> {
    private int size = 0;
    private int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    //Phương thức khởi tạo không tham số
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    //Phương thức thay đổi số phần tử tối đa trong danh sách
    public void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    //Phương thức thêm một phần tử mới vào danh sách
    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }

    //Phương thức truy cập một phần tử trong danh sách
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }
}
