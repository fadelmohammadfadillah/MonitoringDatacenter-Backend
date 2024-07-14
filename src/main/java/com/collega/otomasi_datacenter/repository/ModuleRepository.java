package com.collega.otomasi_datacenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ModuleRepository")
public interface ModuleRepository extends JpaRepository<com.collega.otomasi_datacenter.model.Module, Integer> {

}