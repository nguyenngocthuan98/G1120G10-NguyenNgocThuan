package case_study.services;

import case_study.commons.FuncReadWrite;
import case_study.models.Customer;
import case_study.models.Services;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    public void addNewBooking(Customer customer, String serviceId) {
        Services service = null;
        String serviceTypeId = serviceId.substring(0, 4);

        switch (serviceTypeId) {
            case "SVVL":
                service = new VillaManager().findById(serviceId);
                break;
            case "SVHO":
                service = new HouseManager().findById(serviceId);
                break;
            case "SVRO":
                service = new RoomManager().findById(serviceId);
                break;
        }

        Services serviceFinally = service;
        customer.setService(serviceFinally);
        List<String> list = new ArrayList<>();
        String bookingData = customer.toString();
        list.add(bookingData);
        new FuncReadWrite<String>().writeFile("Booking.csv", list, true);
    }
}
