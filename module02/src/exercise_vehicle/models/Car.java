package exercise_vehicle.models;

public class Car extends Vehicles {
    private int numberSit;
    private String typeCar;

    public Car() {
    }

    public Car(String numberId, String manufacturerName, int yearManufacture, String owner, int numberSit, String typeCar) {
        super(numberId, manufacturerName, yearManufacture, owner);
        this.numberSit = numberSit;
        this.typeCar = typeCar;
    }

    public Car(String[] carInfo) {
        super(carInfo[0], carInfo[1], Integer.parseInt(carInfo[2]), carInfo[3]);
        this.numberSit = Integer.parseInt(carInfo[4]);
        this.typeCar = carInfo[5];
    }

    public int getNumberSit() {
        return numberSit;
    }

    public void setNumberSit(int numberSit) {
        this.numberSit = numberSit;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    @Override
    public String toString() {
        return super.toString() + "Number of seats: " + numberSit +
                ", type car: " + typeCar;
    }

    @Override
    public String showInfo() {
        return super.showInfo() + "," + numberSit + "," + typeCar;
    }
}
