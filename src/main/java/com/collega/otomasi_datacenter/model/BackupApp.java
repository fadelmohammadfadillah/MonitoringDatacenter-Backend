package com.collega.otomasi_datacenter.model;

import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "backup_app")
public class BackupApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_backup_app")
    private Integer idBackupApp;

    @ManyToOne
    @JoinColumn(name = "id_server_app")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ServerApp idServerApp;

    private String directory;

    @OneToMany(mappedBy = "idBackupApp", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BackupAppMonitoring> backupAppMonitorings;
}
