package bai11_dsa_stack_queue.bai_tap.demerging_queue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class ComparatorByDate implements Comparator<Employees> {
    @Override
    public int compare(Employees o1, Employees o2) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = formatDate.parse(o1.getDateOfBirth());
            date2 = formatDate.parse(o2.getDateOfBirth());
            return date1.compareTo(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
