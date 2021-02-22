package exercise_vehicle.models;

public abstract class Vehicles {
    private String numberId;
    private String manufacturerName;
    private int yearManufacture;
    private String owner;

    public Vehicles() {
    }

    public Vehicles(String numberId, String manufacturerName, int yearManufacture, String owner) {
        this.numberId = numberId;
        this.manufacturerName = manufacturerName;
        this.yearManufacture = yearManufacture;
        this.owner = owner;
    }

    public Vehicles(String[] vehicleInfo) {
        this.numberId = vehicleInfo[0];
        this.manufacturerName = vehicleInfo[1];
        this.yearManufacture = Integer.parseInt(vehicleInfo[2]);
        this.owner = vehicleInfo[3];
    }

    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public int getYearManufacture() {
        return yearManufacture;
    }

    public void setYearManufacture(int yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Number Id: " + numberId + ", manufacturerName: " + manufacturerName +
                ", yearManufacture: " + yearManufacture +
                ", owner: " + owner;
    }

    public String showInfo() {
        return numberId + "," + manufacturerName + "," + yearManufacture + "," + owner;
    }
}
