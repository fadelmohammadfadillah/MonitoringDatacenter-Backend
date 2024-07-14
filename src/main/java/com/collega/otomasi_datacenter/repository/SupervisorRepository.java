package com.collega.otomasi_datacenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collega.otomasi_datacenter.model.Supervisor;

@Repository("SupervisorRepository")
public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {
    Supervisor findByUsername(String username);
}