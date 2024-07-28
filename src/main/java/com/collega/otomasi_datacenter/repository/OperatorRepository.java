package com.collega.otomasi_datacenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.collega.otomasi_datacenter.model.Operator;

@Repository("OperatorRepository")
public interface OperatorRepository extends JpaRepository<Operator, Integer> {
    Operator findByUsername(String username);

    @Query("SELECT op.idOperator, d.idDepartment, v.idDivisi, op.name, op.username, op.password, d.departmentName, v.divisiName FROM Operator op JOIN op.idDivisi v JOIN op.idDepartment d")
    List<Object[]> findAllOperatorWithDeptAndDiv();
}
