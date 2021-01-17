package bai11_dsa_stack_queue.thuc_hanh.stack_use_linkedlist;

import java.util.concurrent.ThreadLocalRandom;

public class LinkedList {
    public static void stackOfString() {
        MyGenericStack<String> testStackSring = new MyGenericStack<>();
        testStackSring.push("Nguyen Ngoc Thuan");
        testStackSring.push("Tran Quoc Hoang");
        testStackSring.push("Cai Truong Cam Van");
        testStackSring.push("Hoang Le Quang");
        testStackSring.push("Nguyen Huu Nghia");
        testStackSring.push("Nguyen Hoang Bao Ngoc");
        System.out.println("Stack is empty? " + testStackSring.isEmpty());
        System.out.println("Number of stack: " + testStackSring.size());
        System.out.println("Pop element: " + testStackSring.pop());
    }

    public static void stackOfInteger() {
        MyGenericStack<Integer> testStackInteger = new MyGenericStack<>();
        /*
        This is simple way
            testStackInteger.push(1);
            testStackInteger.push(2);
            testStackInteger.push(3);
        So I use the random numbers below instead
        */

//        int name = ThreadLocalRandom.current().nextInt(min, max + 1); // random formatter
        int randomNum = ThreadLocalRandom.current().nextInt(0, 10 + 1);
        for (int i = 0; i <= randomNum; i++) {
            testStackInteger.push(randomNum);
        }

        System.out.println("Stack is empty? " + testStackInteger.isEmpty());
        System.out.println("Number of stack: " + testStackInteger.size());
        System.out.println("Pop element: " + testStackInteger.pop());
    }

    public static void main(String[] args) {
        System.out.println("---Test stack of string---");
        stackOfString();
        System.out.println("---Test stack of number---");
        stackOfInteger();
    }
}
