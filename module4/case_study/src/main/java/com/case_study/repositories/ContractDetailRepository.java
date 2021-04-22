package com.case_study.repositories;

import com.case_study.models.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
}
