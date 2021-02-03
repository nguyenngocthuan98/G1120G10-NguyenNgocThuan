package case_study.models;

public class Villa extends Services {
    private String roomStandard;
    private String descriptionAnotherServices;
    private float poolArea;
    private int numberFloors;

    public Villa() {
    }

    public Villa(String idService, String nameService, float usingArea, float priceRent, int maxPeople, String typeRent, String roomStandard, String descriptionAnotherServices, float poolArea, int numberFloors) {
        super(idService, nameService, usingArea, priceRent, maxPeople, typeRent);
        this.roomStandard = roomStandard;
        this.descriptionAnotherServices = descriptionAnotherServices;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public Villa(String[] villaInfo) {
        super(villaInfo[0], villaInfo[1], Float.parseFloat(villaInfo[2]), Float.parseFloat(villaInfo[3]),
                Integer.parseInt(villaInfo[4]), villaInfo[5]);
        this.roomStandard = villaInfo[6];
        this.descriptionAnotherServices = villaInfo[7];
        this.poolArea = Float.parseFloat(villaInfo[8]);
        this.numberFloors = Integer.parseInt(villaInfo[9]);
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getDescriptionAnotherServices() {
        return descriptionAnotherServices;
    }

    public void setDescriptionAnotherServices(String descriptionAnotherServices) {
        this.descriptionAnotherServices = descriptionAnotherServices;
    }

    public float getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(float poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String showInfor() {
        return super.showInfor() + ", " +
                "Room standard: " + getRoomStandard() +
                ", Description another services: " + getDescriptionAnotherServices() +
                ", Area of pool: " + getPoolArea() +
                ", Number of floors: " + getNumberFloors() + "\n";
    }

    @Override
    public String toString() {
        return super.toString() + ","+
                getRoomStandard() + "," +
                getDescriptionAnotherServices() + "," +
                getPoolArea() + "," +
                getNumberFloors();
    }
}
