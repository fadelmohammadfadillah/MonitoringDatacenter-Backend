package com.collega.otomasi_datacenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("ModuleRepository")
public interface ModuleRepository extends JpaRepository<com.collega.otomasi_datacenter.model.Module, Integer> {

    @Query("SELECT m.idModule, s.idSubproduct, m.moduleName, m.profile, s.subproductName FROM Module m JOIN m.idSubproduct s")
    List<Object[]> findAllModuleWithSubproduct();
}