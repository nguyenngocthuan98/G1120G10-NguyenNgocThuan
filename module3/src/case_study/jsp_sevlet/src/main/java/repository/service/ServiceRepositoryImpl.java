package repository.service;

import model.RentType;
import model.Service;
import model.ServiceType;
import repository.DBConnection;
import service.rent_type.RentTypeService;
import service.rent_type.RentTypeServiceImpl;
import service.service_type.ServiceTypeService;
import service.service_type.ServiceTypeServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository{

    @Override
    public List<Service> findAllService() {
        return null;
    }

    @Override
    public void save(Service service) {

    }

    @Override
    public Service findServiceById(String id) {
        return null;
    }

    @Override
    public void update(String id, Service service) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public List<Service> search(String search) {
        return null;
    }

    @Override
    public List<Service> sortService(String sortBy) {
        return null;
    }
}
