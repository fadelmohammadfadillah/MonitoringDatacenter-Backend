package com.collega.otomasi_datacenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collega.otomasi_datacenter.model.UserDepartment;


@Repository("UserDeptRepository")
public interface UserDeptRepository extends JpaRepository<UserDepartment, Integer> {
    UserDepartment findByUsername(String username);
}
