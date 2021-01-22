package bai10_dsa_list.bai_tap.arraylist;

import java.util.Arrays;

public class ArrayList<E> {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[]; // chứa các phần tử

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];
        } else {
            throw new IndexOutOfBoundsException("Capacity = " + capacity);
        }
    }

    // trả về số lượng phần tử
    public int size() {
        return this.size;
    }

    // clear array list
    public void clear() {
        size = 0;
//        for (int i = 0; i < elements.length; i++) {
//            elements[i] = null;
//        }
        Arrays.fill(elements, null); // replace for loop
    }

    // add 1 phần tử
    public boolean add(E element) throws IllegalAccessException {
        if (elements.length == size) {
            ensureCapacity(5);
        }
        elements[size] = element;
        size++;
        return true;
    }

    // tang kich thuoc mang
    public void ensureCapacity(int minCap) throws IllegalAccessException {
        if (minCap >= 0) {
            int newSize = this.elements.length + minCap;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalAccessException("Min capacity = " + minCap);
        }
    }

    // them phan tu tai vi tri index
    public void addIndex(E element, int index) throws IllegalAccessException {
        if (index > elements.length) {
            throw new IllegalAccessException("index = " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(5);
        }

        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            //duyệt từ cuối mảng đến index
            for (int i = 0; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    // lay 1 phan tu tai vi tri index
    public E get(int index) {
        return (E) elements[index];
    }

    // lay vi tri cua phan tu trong mang
    public int indexOf(E element) {
        int index = -1; // gan index = -1 (phan tu khong ton tai trong array list)
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return index;
    }

    // kiem tra phan tu co trong mang k
    public boolean contains(E element) {
        return this.indexOf(element) >= 0; // return true if exist, false if not exist
    }

    // tao ban sao array list
    public ArrayList<E> clone() {
        ArrayList<E> cloneArray = new ArrayList<>();
        cloneArray.elements = Arrays.copyOf(this.elements, this.size);
        cloneArray.size = this.size;
        return cloneArray;
    }

    // xoa 1 phan tu ra khoi array list
    public E remove(int index) throws IllegalAccessException {
        if (index < 0 || index > elements.length) {
            throw new IllegalAccessException("Wrong index = " + index);
        }

        E element = (E) elements[index];
        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return element;
    }
}
