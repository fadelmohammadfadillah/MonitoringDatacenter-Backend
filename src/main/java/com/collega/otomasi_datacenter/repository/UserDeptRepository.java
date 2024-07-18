package com.collega.otomasi_datacenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collega.otomasi_datacenter.model.Department;
import com.collega.otomasi_datacenter.model.UserDepartment;
import java.util.List;



@Repository("UserDeptRepository")
public interface UserDeptRepository extends JpaRepository<UserDepartment, Integer> {
    UserDepartment findByUsername(String username);
    List<UserDepartment> findByIdDepartment(Department idDepartment);
}
