package com.collega.otomasi_datacenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collega.otomasi_datacenter.model.ModuleMonitoring;

@Repository("ModuleMonitoringRepository")
public interface ModuleMonitoringRepository extends JpaRepository<ModuleMonitoring, Integer> {

}