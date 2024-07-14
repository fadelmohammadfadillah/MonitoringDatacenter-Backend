package com.collega.otomasi_datacenter.repository;

import com.collega.otomasi_datacenter.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("ManagerRepository")
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    Manager findByUsername(String username);
}
