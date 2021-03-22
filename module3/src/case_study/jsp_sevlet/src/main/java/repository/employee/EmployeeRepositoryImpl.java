package repository.employee;

import model.Division;
import model.Employee;
import model.Position;
import model.User;
import repository.DBConnection;
import service.division.DivisionService;
import service.division.DivisionServiceImpl;
import service.edu_degree.EduDegreeService;
import service.edu_degree.EduDegreeServiceImpl;
import service.position.PositionService;
import service.position.PositionServiceImpl;
import service.user.UserService;
import service.user.UserServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public List<Employee> findAllEmployee() {
        return null;
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public Employee findEmployeeById(int id) {
        return null;
    }

    @Override
    public void update(int id, Employee employee) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Employee> search(String search) {
        return null;
    }

    @Override
    public List<Employee> sortEmployee(String sortBy) {
        return null;
    }
}
