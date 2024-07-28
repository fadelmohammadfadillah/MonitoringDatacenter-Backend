package com.collega.otomasi_datacenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.collega.otomasi_datacenter.model.Department;
import com.collega.otomasi_datacenter.model.Divisi;
import com.collega.otomasi_datacenter.model.ProductOwner;

public interface ProductOwnerRepository extends JpaRepository<ProductOwner, Integer> {
    ProductOwner findByUsername(String username);
    List<ProductOwner> findByIdDivisi(Divisi divisi);
    List<ProductOwner> findByIdDepartment(Department idDepartment);
    List<ProductOwner> findByRole(String role);

    @Query("SELECT po.idPO, d.idDepartment, v.idDivisi, po.name, po.username, po.password, po.role, d.departmentName, v.divisiName FROM ProductOwner po JOIN po.idDivisi v LEFT JOIN po.idDepartment d")
    List<Object[]> findAllPOWithDeptNameAndDivName();
}
