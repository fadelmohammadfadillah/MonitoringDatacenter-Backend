package com.collega.otomasi_datacenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collega.otomasi_datacenter.model.Server;

public interface ServerRepository extends JpaRepository<Server, Integer> {

}
