package com.case_study.repositories;

import com.case_study.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository  extends JpaRepository<Service, String> {
}
