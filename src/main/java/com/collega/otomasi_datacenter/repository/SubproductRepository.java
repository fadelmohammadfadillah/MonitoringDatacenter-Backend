package com.collega.otomasi_datacenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.collega.otomasi_datacenter.model.Subproduct;

@Repository("SubproductRepository")
public interface SubproductRepository extends JpaRepository<Subproduct, Integer> {

    @Query("SELECT s.idSubproduct, p.idProduct, d.idDepartment, s.subproductName, p.productName, d.departmentName FROM Subproduct s JOIN s.idProduct p JOIN p.idDepartment d")
    List<Object[]> findAllSubproductWithProductNameAndDeptName();
}