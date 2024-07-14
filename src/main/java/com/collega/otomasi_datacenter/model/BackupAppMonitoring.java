package com.collega.otomasi_datacenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "backup_app_monitoring")
public class BackupAppMonitoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_backup_app_mon")
    private Integer idBackupAppMon;
    @ManyToOne
    @JoinColumn(name = "id_backup_app")
    private BackupApp idBackupApp;
    @ManyToOne
    @JoinColumn(name = "id_dtl_mon")
    private DetailMonitoring idDetailMonitoring;
    private String status;
    @Column(name = "operator_notes")
    private String operatorNotes;
    private String log;
}
