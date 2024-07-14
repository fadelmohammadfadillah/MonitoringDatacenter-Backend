package com.collega.otomasi_datacenter.repository;

import com.collega.otomasi_datacenter.model.Divisi;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository("DivisiRepository")
public interface DivisiRepository extends JpaRepository<Divisi, Integer> {
    Optional<Divisi> findByDivisiName(String divisiName);
}
