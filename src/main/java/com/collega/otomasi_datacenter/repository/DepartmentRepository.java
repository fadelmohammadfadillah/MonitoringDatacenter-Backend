package com.collega.otomasi_datacenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collega.otomasi_datacenter.model.Department;
import com.collega.otomasi_datacenter.model.Divisi;


@Repository("DepartmentRepository")
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findByDepartmentName(String username);
    List<Department> findByIdDivisi(Divisi idDivisi);
}