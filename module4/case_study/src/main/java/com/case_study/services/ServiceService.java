package com.case_study.services;

import com.case_study.models.Service;

import java.util.Date;
import java.util.List;

public interface ServiceService {
    List<Service> findAll();

    Service findById(String id);

    void save(Service service);

    String getCurrentDate();

    List<Service> findWithoutServiceUsing(String date);
}
