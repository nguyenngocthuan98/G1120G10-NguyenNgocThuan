package case_study.models;

public abstract class Services {
    private String idService;
    private String nameService;
    private float usingArea;
    private float priceRent;
    private int maxPeople;
    private String typeRent;

    public Services() {
    }

    public Services(String idService, String nameService, float usingArea, float priceRent, int maxPeople, String typeRent) {
        this.idService = idService;
        this.nameService = nameService;
        this.usingArea = usingArea;
        this.priceRent = priceRent;
        this.maxPeople = maxPeople;
        this.typeRent = typeRent;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public float getUsingArea() {
        return usingArea;
    }

    public void setUsingArea(float usingArea) {
        this.usingArea = usingArea;
    }

    public float getPriceRent() {
        return priceRent;
    }

    public void setPriceRent(float priceRent) {
        this.priceRent = priceRent;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    @Override
    public String toString() {
        return idService + "," +
                nameService + "," +
                usingArea + "," +
                priceRent + "," +
                maxPeople + "," +
                typeRent;
    }

    public String showInfor() {
        return "ID service: " + idService + ", Name service: " + nameService + ", Using area: " + usingArea + ", Price rent: " + priceRent + ", Max people: " + maxPeople + ", Type rent: " + typeRent;
    }
}
