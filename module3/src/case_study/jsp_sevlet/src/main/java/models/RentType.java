package models;

public class RentType {
    private int rentTypeId;
    private String rentTypeName;
    private int rentTypeCost;

    public RentType() {
    }

    public RentType(int rentTypeId, String rentTypeName, int rentTypeCost) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public int getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(int rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }
}
