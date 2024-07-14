package com.collega.otomasi_datacenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collega.otomasi_datacenter.model.ServerDbPath;

@Repository("ServerDbPathRepository")
public interface ServerDbPathRepository extends JpaRepository<ServerDbPath, Integer> {

}
