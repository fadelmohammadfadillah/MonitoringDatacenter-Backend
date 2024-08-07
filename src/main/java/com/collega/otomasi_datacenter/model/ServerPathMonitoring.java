package com.collega.otomasi_datacenter.model;

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
@Table(name = "server_path_monitoring")
public class ServerPathMonitoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_server_path_mon")
    private Integer idServerPathMon;

    @ManyToOne
    @JoinColumn(name = "id_dtl_mon")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DetailMonitoring idDetailMonitoring;

    @ManyToOne
    @JoinColumn(name = "id_server_path")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ServerPath idServerPath;

    @Column(name = "usage")
    private Integer usage;

    @Column(name = "status")
    private String status;

    @Column(name = "operator_notes")
    private String operatorNotes;
}
