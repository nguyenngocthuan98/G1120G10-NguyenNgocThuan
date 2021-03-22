package model;

import java.sql.Date;

public class Customer {
    private String customerId;
    private CustomerType customerType;
    private String customerName;
    private Date customerBirthDate;
    private boolean customerGender;
    private String customerIdCard;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;

    public Customer() {
    }

    public Customer(String customerId, CustomerType customerType, String customerName, Date customerBirthDate,
                    boolean customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthDate = customerBirthDate;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthDate() {
        return customerBirthDate;
    }

    public void setCustomerBirthDate(Date customerBirthDate) {
        this.customerBirthDate = customerBirthDate;
    }

    public boolean isCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
