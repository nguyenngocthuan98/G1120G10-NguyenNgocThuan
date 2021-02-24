package final_test.controllers;

import final_test.models.SavingLongTerm;
import final_test.models.SavingTerm;
import final_test.models.SavingUnlimited;
import final_test.services.CustomerManager;
import final_test.services.SavingLongTermManager;
import final_test.services.SavingTermManager;
import final_test.services.SavingUnlimitedManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    Scanner sc = new Scanner(System.in);
    private static final int SAVINGNOTE_LONGTERM = 1;
    private static final int SAVINGNOTE_UNLIMITED = 2;
    private static final int SAVINGNOTE_TERM = 3;
    CustomerManager customerManager = new CustomerManager();
    SavingUnlimitedManager savingUnlimitedManager = new SavingUnlimitedManager();
    SavingLongTermManager savingLongTermManager = new SavingLongTermManager();
    SavingTermManager savingTermManager = new SavingTermManager();


    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMenu();
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nCHƯƠNG TRÌNH QUẢN LÝ SỔ TIẾT KIỆM\n"
                    + "CHỌN CHỨC NĂNG:\n"
                    + "1. Thêm mới sổ tiết kiệm\n"
                    + "2. Xóa sổ tiết kiệm\n"
                    + "3. Xem danh sách sổ tiết kiệm\n"
                    + "4. Xem thông tin khách hàng\n"
                    + "5. Tìm kiếm sổ tiết kiệm\n"
                    + "6. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    addNewSavingNote();
                    break;
                case "2":
                    removeSavingNote();
                    break;
                case "3":
                    showAllSavingNote();
                    break;
                case "4":
                    showInfoCustomer();
                    break;
                case "5":
                    searchSavingNote();
                    break;
                case "6":
                    System.exit(0);
                default:
                    System.out.println("VUI LÒNG CHỌN MỘT CHỨC NĂNG TRONG DANH SÁCH");
            }
        }
    }

    public void addNewSavingNote() {
        while (true) {
            System.out.println("\nCHỌN MỘT CHỨC NĂNG TRONG DANH SÁCH SAU:\n"
                    + "1. Thêm sổ tiết kiệm dài hạn\n"
                    + "2. Thêm sổ tiết kiệm ngắn hạn\n"
                    + "3. Trở về menu trước\n"
                    + "4. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    addNewSavingLongNote();
                    break;
                case "2":
                    addNewSavingShortNote();
                    break;
                case "3":
                    displayMenu();
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.out.println("VUI LÒNG CHỌN MỘT CHỨC NĂNG TRONG DANH SÁCH");
            }
        }
    }

    public void addNewSavingShortNote() {
        while (true) {
            System.out.println("\nCHỌN MỘT CHỨC NĂNG TRONG DANH SÁCH SAU:\n"
                    + "1. Thêm sổ tiết kiệm vô thời hạn\n"
                    + "2. Thêm sổ tiết kiệm có thời hạn\n"
                    + "3. Trở về menu trước\n"
                    + "4. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    addNewSavingUnlimited();
                    break;
                case "2":
                    addNewSavingTerm();
                    break;
                case "3":
                    displayMenu();
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.out.println("VUI LÒNG CHỌN MỘT CHỨC NĂNG TRONG DANH SÁCH");
            }
        }
    }

    public List<String> addNewSavingNote(int typeSavingNote) {
        System.out.println("\n==== THÊM SỔ MỚI ====");
        List<String> list = new ArrayList<>();

        String idSavingNote;
//        do {
        System.out.print("NHẬP MÃ SỔ TIẾT KIỆM: ");
        idSavingNote = sc.nextLine();
//        } while (!Validation.validateNoPlate(noPlate, vehicleType));
        list.add(idSavingNote);

        String idCustomer;
        //        do {
        System.out.print("NHẬP MÃ KHÁCH HÀNG: ");
        idCustomer = sc.nextLine();
//        } while (!Validation.validateNoPlate(noPlate, vehicleType));
        list.add(idCustomer);

        String dayOpen;
        //        do {
        System.out.print("NHẬP MÃ NGÀY MỞ SỔ: ");
        dayOpen = sc.nextLine();
//        } while (!Validation.validateNoPlate(noPlate, vehicleType));
        list.add(dayOpen);

        String daySaving;
        //        do {
        System.out.print("NHẬP THỜI GIAN GỬI: ");
        daySaving = sc.nextLine();
//        } while (!Validation.validateNoPlate(noPlate, vehicleType));
        list.add(daySaving);

        String numberOfMoney;
        //        do {
        System.out.print("NHẬP SỐ TIỀN GỬI: ");
        numberOfMoney = sc.nextLine();
//        } while (!Validation.validateNoPlate(noPlate, vehicleType));
        list.add(numberOfMoney);

        String interestRate;
        //        do {
        System.out.print("NHẬP LÃI XUẤT: ");
        interestRate = sc.nextLine();
//        } while (!Validation.validateNoPlate(noPlate, vehicleType));
        list.add(interestRate);

        return list;
    }

    public void addNewSavingLongNote() {
        List<String> list = addNewSavingNote(SAVINGNOTE_LONGTERM);

        String period;
        //        do {
        System.out.print("NHẬP MÃ SỔ TIẾT KIỆM: ");
        period = sc.nextLine();
//        } while (!Validation.validateNoPlate(noPlate, vehicleType));
        list.add(period);

        String offers;
        //        do {
        System.out.print("NHẬP ƯU ĐÃI: ");
        offers = sc.nextLine();
//        } while (!Validation.validateNoPlate(noPlate, vehicleType));
        list.add(offers);

        String[] savingLongTermInfo = list.toArray(new String[0]);
        SavingLongTerm savingLongTerm = new SavingLongTerm(savingLongTermInfo);
        savingLongTermManager.add(savingLongTerm);
    }

    public void addNewSavingUnlimited() {
        List<String> list = addNewSavingNote(SAVINGNOTE_UNLIMITED);

        String[] savingUnlimitedInfo = list.toArray(new String[0]);
        SavingUnlimited savingUnlimited = new SavingUnlimited(savingUnlimitedInfo);
        savingUnlimitedManager.add(savingUnlimited);
    }

    public void addNewSavingTerm() {
        List<String> list = addNewSavingNote(SAVINGNOTE_UNLIMITED);

        String period;
        //        do {
        System.out.print("NHẬP ƯU ĐÃI: ");
        period = sc.nextLine();
//        } while (!Validation.validateNoPlate(noPlate, vehicleType));
        list.add(period);

        String[] savingTermInfo = list.toArray(new String[0]);
        SavingTerm savingTerm = new SavingTerm(savingTermInfo);
        savingTermManager.add(savingTerm);
    }

    public void removeSavingNote() {
    }

    public void showAllSavingNote() {

    }

    public void showInfoCustomer() {
    }

    public void searchSavingNote() {
    }
}
