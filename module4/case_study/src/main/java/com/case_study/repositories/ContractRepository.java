package com.case_study.repositories;

import com.case_study.models.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "SELECT * FROM contract WHERE contract_end_date >= ?1 GROUP BY customer_id", nativeQuery = true)
    Page<Contract> customersUsing(String date, Pageable pageable);
}
