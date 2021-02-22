package exercise_vehicle.models;

public class Motorbike extends Vehicles {
    private double power;

    public Motorbike() {
    }

    public Motorbike(String numberId, String manufacturerName, int yearManufacture, String owner, double power) {
        super(numberId, manufacturerName, yearManufacture, owner);
        this.power = power;
    }

    public Motorbike(String[] vehicleInfo) {
        super(vehicleInfo[0], vehicleInfo[1], Integer.parseInt(vehicleInfo[2]), vehicleInfo[3]);
        this.power = Double.parseDouble(vehicleInfo[4]);
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return super.toString() + ", Power: " + power;
    }

    @Override
    public String showInfo() {
        return super.showInfo() + "," + power;
    }
}
