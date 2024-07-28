package com.collega.otomasi_datacenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.collega.otomasi_datacenter.model.Supervisor;

@Repository("SupervisorRepository")
public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {
    Supervisor findByUsername(String username);

    @Query("SELECT s.idSupervisor, d.idDepartment, v.idDivisi, s.name, s.username, s.password, d.departmentName, v.divisiName FROM Supervisor s JOIN s.idDivisi v JOIN s.idDepartment d")
    List<Object[]> findAllSpvWithDeptAndDiv();
}