package case_study.services;

import case_study.commons.FuncReadWrite;
import case_study.models.Customer;
import case_study.models.Employee;

import java.util.*;

public class EmployeeManager {
    static FuncReadWrite<Customer> funcReadWrite = new FuncReadWrite<>();

    public List<Employee> findAll() {
        List<String[]> list = funcReadWrite.readFile("Employee.csv");
        List<Employee> listEmployee = new ArrayList<>();
        for (String[] lines : list) {
            Employee employee = new Employee(lines);
            listEmployee.add(employee);
        }
        return listEmployee;
    }

    public Map<String, Employee> getEmployeesData() {
        List<Employee> listEmployee = findAll();
        List<String> listKeyId = new ArrayList<>();
        for (Employee empKey : listEmployee) {
            listKeyId.add(empKey.getIdEmployee());
        }
        Map<String, Employee> employeeMap = new LinkedHashMap<>();
        for (int i = 0; i < listKeyId.size(); i++) {
            employeeMap.put(listKeyId.get(i), listEmployee.get(i));
        }
        return employeeMap;
    }

    public Stack<Employee> saveEmployee() {
        List<Employee> employeeList = findAll();
        Stack<Employee> cabinetsEmployer = new Stack<>();
        for (Employee empList : employeeList) {
            cabinetsEmployer.push(empList);
        }
        return cabinetsEmployer;
    }

    public Employee findEmployee(String empIDFind) {
        Employee empFound = null;
        Stack<Employee> listEmployee = saveEmployee();
        for (Employee emp : listEmployee) {
            if (empIDFind.equals(emp.getIdEmployee())) {
                empFound = emp;
            }
        }
        return empFound;
    }

}
