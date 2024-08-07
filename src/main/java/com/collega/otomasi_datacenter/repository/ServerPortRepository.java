package com.collega.otomasi_datacenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collega.otomasi_datacenter.model.ServerPort;


public interface ServerPortRepository extends JpaRepository<ServerPort, Integer> {
    ServerPort findByPort(Integer port);
}
