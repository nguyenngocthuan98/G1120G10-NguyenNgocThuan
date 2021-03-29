package model;

import java.sql.Date;

public class Contract {
    private int contractId;
    private Date contractStartDate;
    private Date contractStartEnd;
    private int contractDeposit;
    private int contractTotalMoney;
    private Employee employee;
    private Customer customer;
    private Service service;

    public Contract() {
    }

    public Contract(Date contractStartDate, Date contractStartEnd, int contractDeposit, int contractTotalMoney,
                    Employee employee, Customer customer, Service service) {
        this.contractStartDate = contractStartDate;
        this.contractStartEnd = contractStartEnd;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }

    public Contract(int contractId, Date contractStartDate, Date contractStartEnd, int contractDeposit,
                    int contractTotalMoney, Employee employee, Customer customer, Service service) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractStartEnd = contractStartEnd;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractStartEnd() {
        return contractStartEnd;
    }

    public void setContractStartEnd(Date contractStartEnd) {
        this.contractStartEnd = contractStartEnd;
    }

    public int getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(int contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public int getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(int contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}