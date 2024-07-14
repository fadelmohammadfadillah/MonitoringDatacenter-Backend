package com.collega.otomasi_datacenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collega.otomasi_datacenter.model.ServerAppPath;

@Repository("ServerAppPathRepository")
public interface ServerAppPathRepository extends JpaRepository<ServerAppPath, Integer> {

}