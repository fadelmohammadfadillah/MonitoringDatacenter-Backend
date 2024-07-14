package com.collega.otomasi_datacenter.repository;

import com.collega.otomasi_datacenter.model.BackupApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("BackupAppRepository")
public interface BackupAppRepository extends JpaRepository<BackupApp, Integer> {

}
