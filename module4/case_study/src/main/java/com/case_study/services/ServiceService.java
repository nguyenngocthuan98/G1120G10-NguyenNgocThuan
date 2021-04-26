package com.case_study.services;

import com.case_study.models.Service;
import org.springframework.validation.Errors;

import java.util.List;

public interface ServiceService {
    List<Service> findAll();

    Service findById(String id);

    void save(Service service);

    String getCurrentDate();

    List<Service> findWithoutServiceUsing(String date);

    void checkServiceId(Service service, Errors errors);

}
