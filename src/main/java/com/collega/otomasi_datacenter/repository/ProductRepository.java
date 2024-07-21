package com.collega.otomasi_datacenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.collega.otomasi_datacenter.model.Product;

@Repository("ProductRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p.idProduct, d.idDepartment, p.productName, d.departmentName FROM Product p JOIN p.idDepartment d")
    List<Object[]> findAllProductsWithDepartmentNames();
}