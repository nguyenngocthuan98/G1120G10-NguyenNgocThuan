package exercise_vehicle.models;

public class Truck extends Vehicles {
    private double weight;

    public Truck() {
    }

    public Truck(String numberId, String manufacturerName, int yearManufacture, String owner, double payload) {
        super(numberId, manufacturerName, yearManufacture, owner);
        this.weight = payload;

    }

    public Truck(String[] vehicleInfo) {
        super(vehicleInfo[0], vehicleInfo[1], Integer.parseInt(vehicleInfo[2]), vehicleInfo[3]);
        this.weight = Double.parseDouble(vehicleInfo[4]);
    }

    public double getPayload() {
        return weight;
    }

    public void setPayload(double payload) {
        this.weight = payload;
    }


    @Override
    public String toString() {
        return super.toString() + ", Payload: " + weight;
    }

    @Override
    public String showInfo() {
        return super.showInfo() + "," + weight;
    }
}
