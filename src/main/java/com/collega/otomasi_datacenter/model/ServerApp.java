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
@Table(name = "server_app")
public class ServerApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_server_app")
    private Integer idServerApp;

    @Column(name = "ip_address", unique = true)
    private String ipAddress;

    @OneToMany(mappedBy = "idServerApp", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ServerAppMonitoring> serverAppMonitorings;

    @OneToMany(mappedBy = "idServerApp", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ServerAppPath> serverAppPaths;

    @OneToMany(mappedBy = "idServerApp", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BackupApp> backupApps;
}
