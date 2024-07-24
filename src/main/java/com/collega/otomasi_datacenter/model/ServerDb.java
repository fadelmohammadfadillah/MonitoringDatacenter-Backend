package com.collega.otomasi_datacenter.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "server_db")
public class ServerDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_server_db")
    private Integer idServerDb;
    
    @Column(name = "ip_address", unique = true)
    private String ipAddress;

    @OneToMany(mappedBy = "idServerDb", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ServerDbPath> serverDbPaths;

    @OneToMany(mappedBy = "idServerDb", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ServerDbMonitoring> serverDbMonitorings;

    @OneToMany(mappedBy = "idServerDb", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BackupDb> backupDbs;
}
