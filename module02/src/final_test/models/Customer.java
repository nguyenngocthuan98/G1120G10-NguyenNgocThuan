package final_test.models;

public class Customer {
    private String id;
    private String name;
    private String dayOfBirth;
    private String gender;
    private String phoneNumber;
    private String address;

    public Customer() {
    }

    public Customer(String id, String name, String dayOfBirth, String gender, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Customer(String[] customerInfo) {
        this.id = customerInfo[0];
        this.name = customerInfo[1];
        this.dayOfBirth = customerInfo[2];
        this.gender = customerInfo[3];
        this.phoneNumber = customerInfo[4];
        this.address = customerInfo[5];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return id +
                ',' + name +
                ',' + dayOfBirth +
                ',' + gender +
                ',' + phoneNumber +
                ',' + address;
    }
}
