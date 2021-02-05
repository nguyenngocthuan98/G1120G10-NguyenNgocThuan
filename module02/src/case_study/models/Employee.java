package case_study.models;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String idEmployee;
    private String nameEmployee;
    private int ageEmployee;
    private String addressEmployee;

    public Employee() {
    }

    public Employee(String idEmployee, String nameEmployee, int ageEmployee, String addressEmployee) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.ageEmployee = ageEmployee;
        this.addressEmployee = addressEmployee;
    }

    public Employee(String[] employeeInfo) {
        this.idEmployee = employeeInfo[0];
        this.nameEmployee = employeeInfo[1];
        this.ageEmployee = Integer.parseInt(employeeInfo[2]);
        this.addressEmployee = employeeInfo[3];
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public int getAgeEmployee() {
        return ageEmployee;
    }

    public void setAgeEmployee(int ageEmployee) {
        this.ageEmployee = ageEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    @Override
    public String toString() {
        return getIdEmployee() + ',' + getNameEmployee() + ',' + getAgeEmployee() + ',' + getAddressEmployee();
    }

    public void showInfor() {
        System.out.println("Name employee: " + getNameEmployee() + ", age employee: " + getAgeEmployee() + ", address employee: " + getAddressEmployee());
    }
}
