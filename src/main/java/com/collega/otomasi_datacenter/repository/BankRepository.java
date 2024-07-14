package com.collega.otomasi_datacenter.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collega.otomasi_datacenter.model.Bank;

@Repository("BankRepository")
public interface BankRepository extends JpaRepository<Bank, Integer> {

}