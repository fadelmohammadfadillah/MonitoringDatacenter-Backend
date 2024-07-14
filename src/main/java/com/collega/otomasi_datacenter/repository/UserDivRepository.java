package com.collega.otomasi_datacenter.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collega.otomasi_datacenter.model.Divisi;
import com.collega.otomasi_datacenter.model.UserDivisi;


@Repository("UserDivRepository")
public interface UserDivRepository extends JpaRepository<UserDivisi, Integer> {
    UserDivisi findByUsername(String username);
    List<UserDivisi> findByIdDivisi(Divisi divisi);
}
