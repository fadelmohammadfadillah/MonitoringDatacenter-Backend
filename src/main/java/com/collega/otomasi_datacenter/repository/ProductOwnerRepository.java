package com.collega.otomasi_datacenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collega.otomasi_datacenter.model.Department;
import com.collega.otomasi_datacenter.model.Divisi;
import com.collega.otomasi_datacenter.model.ProductOwner;

public interface ProductOwnerRepository extends JpaRepository<ProductOwner, Integer> {
    ProductOwner findByUsername(String username);
    List<ProductOwner> findByIdDivisi(Divisi divisi);
    List<ProductOwner> findByIdDepartment(Department idDepartment);
    List<ProductOwner> findByRole(String role);
}
