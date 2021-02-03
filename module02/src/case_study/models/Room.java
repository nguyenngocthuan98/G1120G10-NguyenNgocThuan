package case_study.models;

public class Room extends Services {
    private String freeService;

    public Room() {
    }

    public Room(String idService, String nameService, float usingArea, float priceRent, int maxPeople, String typeRent, String freeService) {
        super(idService, nameService, usingArea, priceRent, maxPeople, typeRent);
        this.freeService = freeService;
    }

    public Room(String[] villaInfo) {
        super(villaInfo[0], villaInfo[1], Float.parseFloat(villaInfo[2]), Float.parseFloat(villaInfo[3]), Integer.parseInt(villaInfo[4]), villaInfo[5]);
        this.freeService = villaInfo[6];
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String showInfor() {
        return super.showInfor() + ", " + "Free service: " + freeService + "\n";
    }

    @Override
    public String toString() {
        return super.toString() + "," + freeService;
    }
}
