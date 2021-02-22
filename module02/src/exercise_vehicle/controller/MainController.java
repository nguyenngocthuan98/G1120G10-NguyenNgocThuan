package exercise_vehicle.controller;

//import exercise_vehicle.commons.Validate;

import exercise_vehicle.models.Car;
import exercise_vehicle.models.Motorbike;
import exercise_vehicle.models.Truck;
import exercise_vehicle.services.CarManager;
import exercise_vehicle.services.MotorbikeManager;
import exercise_vehicle.services.TruckManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainController {
    private static final int VEHICLE_TRUCK = 1;
    private static final int VEHICLE_CAR = 2;
    private static final int VEHICLE_MOTORBIKE = 3;

    CarManager carManager = new CarManager();
    TruckManager truckManager = new TruckManager();
    MotorbikeManager motorbikeManager = new MotorbikeManager();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("-*-TRAFFIC VEHICLE MANAGER-*-");
        MainController mainController = new MainController();
        mainController.menubar();
    }

    public void menubar() {
        System.out.print("--VEHICLE MENU--\n\t1.Add new |\t2.Display |\t3.Delete |\t4.Exit\n");
        while (true) {
            System.out.print("Select: ");
            String choose = scanner.nextLine().trim();
            switch (choose) {
                case "1":
                    addVehicle();
                    break;
                case "2":
                    displayVehicle();
                    break;
                case "3":
                    deleteVehicle();
                    break;
                case "4":
                    System.exit(-1);
                    break;
                default:
                    System.out.println("\t--Choice not exist--");
                    break;
            }
        }
    }

    public void addVehicle() {
        System.out.println("--ADD NEW VEHICLE MENU--\n\t1.Truck\t|\t2.Car\t|\t3.Motorbike\t|\t4.Back\t|\t5.Exit");
        while (true) {
            System.out.print("Select: ");
            String choose = scanner.nextLine().trim();
            switch (choose) {
                case "1":
                    addTruck();
                    break;
                case "2":
                    addCar();
                    break;
                case "3":
                    addMotorBike();
                    break;
                case "4":
                    menubar();
                    break;
                case "5":
                    System.exit(-1);
                    break;
                default:
                    System.out.println("\t--Choice not exist--");
                    break;
            }
        }
    }

    public List<String> addVehicle(int typeVehicle) {
        List<String> vehicle = new ArrayList<>();

        String idVehicle;
//        do {
        System.out.print("Enter license plate: ");
        idVehicle = scanner.nextLine();
//        } while (!Validate.validateVehicleID(idVehicle, typeVehicle));
        vehicle.add(idVehicle);

        String manufacturer;
//        do {
        System.out.print("Enter manufacturer: ");
        manufacturer = scanner.nextLine();
//        } while (!Validate.validateVehicleID(manufacturer, typeVehicle));
        vehicle.add(idVehicle);

        String yearManufacture;
//        do {
        System.out.print("Enter year manufacture: ");
        yearManufacture = scanner.nextLine();
//        } while (!Validate.validateVehicleID(yearManufacture, typeVehicle));
        vehicle.add(yearManufacture);

        String owner;
//        do {
        System.out.print("Enter license plate: ");
        owner = scanner.nextLine();
//        } while (!Validate.validateVehicleID(owner, typeVehicle));
        vehicle.add(owner);

        return vehicle;
    }

    public void addTruck() {
        List<String> vehicleTruck = addVehicle(VEHICLE_TRUCK);

        String weight;
//        do {
        System.out.print("Enter license plate: ");
        weight = scanner.nextLine();
//        } while (!Validate.validateVehicleID(weight));
        vehicleTruck.add(weight);

        String[] inputTruckData = vehicleTruck.toArray(new String[0]);
        Truck truck = new Truck(inputTruckData);
        truckManager.add(truck);
    }

    public void addCar() {
        List<String> vehicleCar = addVehicle(VEHICLE_CAR);

        String seat;
//        do {
        System.out.print("Enter license plate: ");
        seat = scanner.nextLine();
//        } while (!Validate.validateVehicleID(seat));
        vehicleCar.add(seat);

        String typeCar;
//        do {
        System.out.print("Enter license plate: ");
        typeCar = scanner.nextLine();
//        } while (!Validate.validateVehicleID(owner));
        vehicleCar.add(typeCar);

        String[] inputCarData = vehicleCar.toArray(new String[0]);
        Car car = new Car(inputCarData);
        carManager.add(car);
    }

    public void addMotorBike() {
        List<String> vehicleMotorbike = addVehicle(VEHICLE_MOTORBIKE);

        String power;
//        do {
        System.out.print("Enter license plate: ");
        power = scanner.nextLine();
//        } while (!Validate.validateVehicleID(power));
        vehicleMotorbike.add(power);

        String[] inputMotorData = vehicleMotorbike.toArray(new String[0]);
        Motorbike motorbike = new Motorbike(inputMotorData);
        motorbikeManager.add(motorbike);
    }

    public void displayVehicle() {
        System.out.println("--DISPLAY VEHICLE MENU--\n\t1.Truck\t|\t2.Car\t|\t3.Motorbike\t|\t4.Back\t|\t5.Exit");
        while (true) {
            System.out.print("Select: ");
            String choose = scanner.nextLine().trim();
            switch (choose) {
                case "1":
                    displayTruck();
                    break;
                case "2":
                    displayCar();
                    break;
                case "3":
                    displayMotorBike();
                    break;
                case "4":
                    menubar();
                    break;
                case "5":
                    System.exit(-1);
                    break;
                default:
                    System.out.println("\t--Choice not exist--");
                    break;
            }
        }
    }

    public List<Truck> displayTruck() {
        List<Truck> listTruck = truckManager.findAll();
        for (int i = 0; i < listTruck.size(); i++) {
            System.out.print((i + 1) + ". " + listTruck.get(i).showInfo());
        }
        return listTruck;
    }

    public List<Car> displayCar() {
        List<Car> listCar = carManager.findAll();
        for (int i = 0; i < listCar.size(); i++) {
            System.out.println((i + 1) + ". " + listCar.get(i).showInfo());
        }
        return listCar;
    }

    public List<Motorbike> displayMotorBike() {
        List<Motorbike> listMotorBike = motorbikeManager.findAll();
        for (int i = 0; i < listMotorBike.size(); i++) {
            System.out.println((i + 1) + ". " + listMotorBike.get(i).showInfo());
        }
        return listMotorBike;
    }

    public void deleteVehicle() {
        String idVehicle;
        System.out.println("--DELETE VEHICLE--\nEnter license plate: ");
        idVehicle = scanner.nextLine().trim();

    }
}
