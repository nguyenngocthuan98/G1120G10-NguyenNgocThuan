package bai11_dsa_stack_queue.thuc_hanh.stack_use_linkedlist;

import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> stack;

    public MyGenericStack() {
        stack = new LinkedList<>();
    }

    public void push(T element) {
        stack.push(element);
    }

    public T pop() {
        if (!isEmpty()) {
            return stack.pop();
        }
        return null;
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
//        if (stack.size() == 0) {
//            return true;
//        }
//        return false;
        return stack.size() == 0; // replace for above
    }
}
