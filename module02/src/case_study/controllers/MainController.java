package case_study.controllers;

import case_study.commons.SortCustomer;
import case_study.commons.Validate;
import case_study.models.*;
import case_study.services.*;

import java.util.*;
import java.util.stream.Collectors;

public class MainController {
    private static final int SERVICE_VILLA = 1;
    private static final int SERVICE_HOUSE = 2;
    private static final int SERVICE_ROOM = 3;

    VillaManager villaManager = new VillaManager();
    HouseManager houseManager = new HouseManager();
    RoomManager roomManager = new RoomManager();
    CustomerManager customerManager = new CustomerManager();
    BookingManager bookingManager = new BookingManager();
    EmployeeManager employeeManager = new EmployeeManager();

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("\nMAIN MENU:\t" +
                    "1.Add new service | " +
                    "2.Show services | " +
                    "3.Add new customer | " +
                    "4.Show information customer | " +
                    "5.Add new booking | " +
                    "6.Show information of employee | " +
                    "7.Cinema manager | " +
                    "8.Find employee | " +
                    "9.Exit" +
                    "\nEnter your choice: ");
            String choose = sc.nextLine().trim();
            switch (choose) {
                case "1":
                    addNewServices();
                    break;
                case "2":
                    showServices();
                    break;
                case "3":
                    addNewCustomer();
                    break;
                case "4":
                    showInformationCustomers();
                    break;
                case "5":
                    addNewBook();
                    break;
                case "6":
                    showInforEmployee();
                    break;
                case "7":
                    manageCinema();
                    break;
                case "8":
                    findEmployee();
                    break;
                case "9":
                    System.exit(-1);
                    break;
                default:
                    System.out.println("\t--This choice not exits!--\n");
                    break;
            }
        }
    }

    public void addNewServices() {
        while (true) {
            System.out.println("\nADD NEW MENU:\t" +
                    "1.Add New Villa | " +
                    "2.Add New House | " +
                    "3.Add New Room | " +
                    "4.Back to menu | " +
                    "5.Exit" +
                    "\nEnter your choice: ");
            String choose = sc.nextLine().trim();
            switch (choose) {
                case "1":
                    addNewVilla();
                    break;
                case "2":
                    addNewHouse();
                    break;
                case "3":
                    addNewRoom();
                    break;
                case "4":
                    displayMainMenu();
                    break;
                case "5":
                    System.exit(-1);
                    break;
                default:
                    System.out.println("\t--This choice not exits!--\n");
                    break;
            }
        }
    }

    public void showServices() {
        while (true) {
            System.out.println("\nSHOW SERVICES MENU:\t" +
                    "1.Show All Villa | " +
                    "2.Show All House | " +
                    "3.Show All Room | \n\t\t\t\t\t" +
                    "4.Show All Name Villa not duplicate | " +
                    "5.Show All Name House not duplicate | " +
                    "6.Show All Name Room not duplicate | \n\t\t\t\t\t" +
                    "7.Back to menu | " +
                    "8.Exit" +
                    "\nEnter your choice: ");
            String choose = sc.nextLine().trim();
            switch (choose) {
                case "1":
                    showAllVilla();
                    break;
                case "2":
                    showAllHouse();
                    break;
                case "3":
                    showAllRoom();
                    break;
                case "4":
                    showAllNameVilla();
                    break;
                case "5":
                    showAllNameHouse();
                    break;
                case "6":
                    showAllNameRoom();
                    break;
                case "7":
                    displayMainMenu();
                    break;
                case "8":
                    System.exit(-1);
                    break;
                default:
                    System.out.println("--This choice not exits!--\n");
                    break;
            }
        }
    }

    public List<String> addNewService(int typeService) {
        List<String> service = new ArrayList<>();

        String idService;
        do {
            System.out.print("Enter id: ");
            idService = sc.nextLine();
        } while (!Validate.validateServiceID(idService, typeService));
        service.add(idService);

        String nameService;
        do {
            System.out.print("Enter name: ");
            nameService = sc.nextLine();
        } while (!Validate.validateString(nameService));
        service.add(nameService);

        String usingArea;
        do {
            System.out.print("Enter using area: ");
            usingArea = sc.nextLine();
        } while (!Validate.validateArea(usingArea));
        service.add(usingArea);

        String priceRent;
        do {
            System.out.print("Enter rent price: ");
            priceRent = sc.nextLine();
        } while (!Validate.validateRentPrice(priceRent));
        service.add(priceRent);

        String maxPeople;
        do {
            System.out.print("Enter max number people: ");
            maxPeople = sc.nextLine();
        } while (!Validate.validateMaxPeople(maxPeople));
        service.add(maxPeople);

        String typeRent;
        System.out.print("Enter type rent: ");
        typeRent = sc.nextLine();
        service.add(typeRent);

        return service;
    }

    public void addNewVilla() {
        List<String> service = addNewService(SERVICE_VILLA);

        String roomStandard;
        do {
            System.out.print("Enter room standard: ");
            roomStandard = sc.nextLine();
        } while (!Validate.validateString(roomStandard));
        service.add(roomStandard);

        String descriptionAnotherServices;
        do {
            System.out.print("Enter description another services: ");
            descriptionAnotherServices = sc.nextLine().trim();
        } while (!Validate.notEmpty(descriptionAnotherServices));
        service.add(descriptionAnotherServices);

        String poolArea;
        do {
            System.out.print("Enter pool area: ");
            poolArea = sc.nextLine();
        } while (!Validate.validateArea(poolArea));
        service.add(poolArea);

        String numberFloors;
        do {
            System.out.print("Enter number of floor: ");
            numberFloors = sc.nextLine();
        } while (!Validate.validateFloors(numberFloors));
        service.add(numberFloors);

        String[] inputVillaData = service.toArray(new String[0]);
        Villa villa = new Villa(inputVillaData);
        villaManager.add(villa);
    }

    public void addNewHouse() {
        List<String> service = addNewService(SERVICE_HOUSE);

        String roomStandard;
        do {
            System.out.print("Enter room standard: ");
            roomStandard = sc.nextLine();
        } while (!Validate.validateString(roomStandard));
        service.add(roomStandard);

        String descriptionAnotherServices;
        do {
            System.out.print("Enter description another services: ");
            descriptionAnotherServices = sc.nextLine().trim();
        } while (!Validate.notEmpty(descriptionAnotherServices));
        service.add(descriptionAnotherServices);

        String numberFloors;
        do {
            System.out.print("Enter number of floor: ");
            numberFloors = sc.nextLine();
        } while (!Validate.validateFloors(numberFloors));
        service.add(numberFloors);

        String[] inputHouseData = service.toArray(new String[0]);
        House house = new House(inputHouseData);
        houseManager.add(house);
    }

    public void addNewRoom() {
        List<String> service = addNewService(SERVICE_ROOM);

        String freeService;
        do {
            System.out.print("Enter free service: ");
            freeService = sc.nextLine();
        } while (!Validate.validateExternalService(freeService));
        service.add(freeService);

        String[] inputRoomData = service.toArray(new String[0]);
        Room room = new Room(inputRoomData);
        roomManager.add(room);
    }

    public List<Villa> showAllVilla() {
        List<Villa> listVilla = villaManager.findAll();
        for (int i = 0; i < listVilla.size(); i++) {
            System.out.print((i + 1) + ". " + listVilla.get(i).showInfor());
        }
        return listVilla;
    }

    public List<House> showAllHouse() {
        List<House> listHouse = houseManager.findAll();
        for (int i = 0; i < listHouse.size(); i++) {
            System.out.print((i + 1) + ". " + listHouse.get(i).showInfor());
        }
        return listHouse;
    }

    public List<Room> showAllRoom() {
        List<Room> listRoom = roomManager.findAll();
        for (int i = 0; i < listRoom.size(); i++) {
            System.out.print((i + 1) + ". " + listRoom.get(i).showInfor());
        }
        return listRoom;
    }

    public void addNewCustomer() {
        String customerName;
        do {
            System.out.print("\nEnter customer name: ");
            customerName = sc.nextLine();
        } while (!Validate.validateString(customerName));

        String customerBirthday;
        do {
            System.out.print("Enter customer birthday (dd/mm/yyyy): ");
            customerBirthday = sc.nextLine();
        } while (!Validate.validateBirthday(customerBirthday));

        String customerGender;
        do {
            System.out.print("Enter customer gender: ");
            customerGender = sc.nextLine();
        } while (!Validate.validateGender(customerGender));

        String customerIdNumber;
        do {
            System.out.print("Enter customer ID-card (XXX XXX XXX): ");
            customerIdNumber = sc.nextLine();
        } while (!Validate.validateIdCard(customerIdNumber));

        String customerPhone;
        do {
            System.out.print("Enter customer phone number: ");
            customerPhone = sc.nextLine();
        } while (!Validate.validatePhone(customerPhone));

        String customerEmail;
        do {
            System.out.print("Enter customer email: ");
            customerEmail = sc.nextLine();
        } while (!Validate.validateEmail(customerEmail));

        String customerType;
        do {
            System.out.print("Enter customer type: ");
            customerType = sc.nextLine();
        } while (!Validate.validateString(customerType));

        String customerAddress;
        do {
            System.out.print("Enter customer address: ");
            customerAddress = sc.nextLine();
        } while (!Validate.validateAddress(customerAddress));

        String[] customerInfo = {customerName, customerBirthday, customerGender, customerIdNumber,
                customerPhone, customerEmail, customerType, customerAddress};
        Customer customer = new Customer(customerInfo);
        customerManager.add(customer);
    }

    public void showInformationCustomers() {
        List<Customer> listCustomer = customerManager.findAll();
        listCustomer.sort(new SortCustomer());
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.print((i + 1) + ". ");
            listCustomer.get(i).showInfor();
        }
    }

    public void addNewBook() {
        //show list customers
        List<Customer> listCustomer = customerManager.findAll();
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.print((i + 1) + ". ");
            listCustomer.get(i).showInfor();
        }
        //choose customer
        System.out.print("Enter number of customer: ");
        int chooseCustomer = Integer.parseInt(sc.nextLine());
        Customer customer = listCustomer.get(chooseCustomer - 1); // get object customer

        String serviceId = null; // id of service has been chosen
        boolean flg = true;

        do {
            System.out.print("\tBOOKING MENU:\t1. Booking Villa | 2. Booking House | 3. Booking Room\nChoose: ");
            int chooseBooking = Integer.parseInt(sc.nextLine()); // choose type service booking
            switch (chooseBooking) {
                case 1:
                    serviceId = bookingVilla();
//                serviceId = customer.getService(villaList.get(chooseVilla - 1));
//                listCustomer.get(chooseBooking - 1).setService(villaList.get(chooseVilla - 1));
                    break;
                case 2:
                    serviceId = bookingHouse();
                    flg = false;

                    break;
                case 3:
                    serviceId = bookingRoom();
                    flg = false;
                    break;
                default:
                    System.out.println("Wrong booking service!");
                    break;
            }
        } while (flg);
        bookingManager.addNewBooking(customer, serviceId);
    }

    public String bookingVilla() {
        List<Villa> villaList = showAllVilla(); // show all of villas have in service villa
        int chooseVilla;
        do {
            System.out.print("Enter villa: ");
            try {
                chooseVilla = Integer.parseInt(sc.nextLine()); // choose 1 in all service villa
                return villaList.get(chooseVilla - 1).getIdService();
            } catch (NumberFormatException e) {
                System.out.println("Must be integer");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Choose wrong!");
            }
        } while (true);
    }

    public String bookingHouse() {
        List<House> houseList = showAllHouse();
        int chooseHouse;
        do {
            System.out.print("Enter house: ");
            try {
                chooseHouse = Integer.parseInt(sc.nextLine());
                return houseList.get(chooseHouse - 1).getIdService();
            } catch (NumberFormatException e) {
                System.out.println("Must be integer");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Choose wrong!");
            }
        } while (true);
    }

    public String bookingRoom() {
        List<Room> roomList = showAllRoom();
        int chooseRoom;
        do {
            System.out.print("Enter villa: ");
            try {
                chooseRoom = Integer.parseInt(sc.nextLine());
                return roomList.get(chooseRoom - 1).getIdService();
            } catch (NumberFormatException e) {
                System.out.println("Must be integer");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Choose wrong!");
            }
        } while (true);
    }

    public void showAllNameVilla() {
        Set<String> listNameVilla = villaManager.findAllName();
        for (String nameVilla : listNameVilla) {
            System.out.println(nameVilla);
        }
    }

    public void showAllNameHouse() {
        Set<String> listNameHouse = houseManager.findAllName();
        for (String nameHouse : listNameHouse) {
            System.out.println(nameHouse);
        }
    }

    public void showAllNameRoom() {
        Set<String> listNameRoom = roomManager.findAllName();
        for (String nameRoom : listNameRoom) {
            System.out.println(nameRoom);
        }
    }

    public void showInforEmployee() {
        Map<String, Employee> employeeMap = employeeManager.getEmployeesData();
        Set<String> keySet = employeeMap.keySet();
        for (String key : keySet) {
            System.out.print(key + ": ");
            employeeMap.get(key).showInfor();
        }
    }

    public void manageCinema() {
        Queue<Customer> customers = new LinkedList<>();
        int numberOfTickets = 10;

        while (true) {
            System.out.print("\nCINEMA MENU:\t" +
                    "1.Buy Cinema Ticket | " +
                    "2.Customers bought | " +
                    "3.Main menu | " +
                    "4.Exit" +
                    "\nEnter choose: ");
            String choose = sc.nextLine().trim();
            switch (choose) {
                case "1":
                    if (customers.size() < numberOfTickets) newBuy(customers);
                    else System.out.println("Tickets're sold out!");
                    break;
                case "2":
                    customersBought(customers);
                    break;
                case "3":
                    displayMainMenu();
                    break;
                case "4":
                    System.exit(-1);
                default:
                    System.out.println("\t--Wrong choose!");
            }
        }
    }

    public void newBuy(Queue<Customer> customers) {
        //show list customers
        List<Customer> listCustomer = customerManager.findAll();
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.print((i + 1) + ". ");
            listCustomer.get(i).showInfor();
        }
        //choose customer
        System.out.print("Enter number of customer: ");
        int chooseCustomer = Integer.parseInt(sc.nextLine());
        Customer customer = listCustomer.get(chooseCustomer - 1); // get object customer
        customers.offer(customer);
        System.out.println("\tBuy success!");
    }

    public void customersBought(Queue<Customer> customers) {
        int i = 1;
        for (Customer customer : customers) {
            System.out.print(i + ". ");
            customer.showInfor();
            i++;
        }
    }

    public void findEmployee() {
        System.out.println("Enter employee ID:");
        String findID = sc.nextLine();
        System.out.println(employeeManager.findEmployee(findID));
    }
}
