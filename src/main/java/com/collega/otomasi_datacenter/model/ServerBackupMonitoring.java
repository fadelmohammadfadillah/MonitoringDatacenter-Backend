package com.collega.otomasi_datacenter.model;

import java.sql.Time;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
@Table(name = "server_backup_monitoring")
public class ServerBackupMonitoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_server_backup_mon")
    private Integer idServerBackupMon;

    @ManyToOne
    @JoinColumn(name = "id_server_backup")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ServerBackup idServerBackup;

    @ManyToOne
    @JoinColumn(name = "id_dtl_mon")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DetailMonitoring idDetailMonitoring;

    @Column(name = "status")
    private String status;

    @Column(name = "operator_notes")
    private String operatorNotes;
    
    @Column(name= "start_backup")
    private Time startBackup;

    @Column(name= "finish_backup")
    private Time finishBackup;
}
