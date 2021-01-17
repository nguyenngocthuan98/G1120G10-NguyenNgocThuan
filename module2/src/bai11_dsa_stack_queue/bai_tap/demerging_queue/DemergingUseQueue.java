package bai11_dsa_stack_queue.bai_tap.demerging_queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
//Cần tổ chức lại dữ liệu sao cho nữ được liệt kê trước nam nhưng vẫn giữ được tính đã sắp theo ngày tháng năm sinh.
public class DemergingUseQueue {
    public static void main(String[] args) {
        ArrayList<Employees> demerge = new ArrayList<>();

        demerge.add(new Employees("thuan", true, "16/09/1998"));
        demerge.add(new Employees("hoang", true, "16/09/1996"));
        demerge.add(new Employees("quang", true, "16/09/1993"));
        demerge.add(new Employees("van", false, "16/09/1997"));
        demerge.add(new Employees("nghia", true, "16/09/1997"));
        demerge.add(new Employees("ngoc", true, "16/09/1997"));
        demerge.add(new Employees("vi", false, "16/09/1992"));

        System.out.println("Before sort by date of birth:");
        for (Employees demergingQueue : demerge) {
            System.out.println(demergingQueue);
        }

        Queue<Employees> male = new ArrayDeque<>();
        Queue<Employees> female = new ArrayDeque<>();
        ComparatorByDate comparate = new ComparatorByDate();
        demerge.sort(comparate);
        for (Employees demergingQueue : demerge) {
            if (!demergingQueue.isGender()) {
                female.offer(demergingQueue);
            } else {
                male.offer(demergingQueue);
            }
        }

        ArrayList<Employees> list = new ArrayList<>();
        while (!female.isEmpty()) {
            list.add(female.poll());
        }
        while (!male.isEmpty()) {
            list.add(male.poll());
        }

        System.out.println("Before sort by date of birth:");
        for (Employees print : list) {
            System.out.println(print);
        }
    }
}
