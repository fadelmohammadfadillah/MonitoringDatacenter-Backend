package com.collega.otomasi_datacenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.collega.otomasi_datacenter.model.ServerConfig;


@Repository("ServerConfigRepository")
public interface ServerConfigRepository extends JpaRepository<ServerConfig, Integer>{

    @Query(value = "select " + //
                "sc.id_server_config ," + //
                "sc.id_server ," + //
                "sc.id_server_port ," + //
                "sc.id_subproduct ," + //
                "svr.ip_address ," + //
                "sp.port ," + //
                "s.subproduct_name ," + //
                "svr.server_type " + //
                "from server_config sc " + //
                "join server svr on sc.id_server = svr.id_server " + //
                "join server_port sp on sc.id_server_port = sp.id_server_port " + //
                "join subproduct s on sc.id_subproduct = s.id_subproduct ;", nativeQuery = true)
    List<Object[]> findAllSCWithIpAndNames();
}
