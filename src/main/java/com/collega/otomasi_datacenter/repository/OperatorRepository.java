package com.collega.otomasi_datacenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collega.otomasi_datacenter.model.Operator;

@Repository("OperatorRepository")
public interface OperatorRepository extends JpaRepository<Operator, Integer> {
    Operator findByUsername(String username);
}
