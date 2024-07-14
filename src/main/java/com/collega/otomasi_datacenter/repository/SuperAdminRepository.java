package com.collega.otomasi_datacenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collega.otomasi_datacenter.model.SuperAdmin;

@Repository("SuperAdminRepository")
public interface SuperAdminRepository extends JpaRepository<SuperAdmin, Integer>{
    SuperAdmin findByUsername(String username);
}
