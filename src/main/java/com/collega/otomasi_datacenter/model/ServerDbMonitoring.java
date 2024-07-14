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
@Table(name = "server_db_monitoring")
public class ServerDbMonitoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_server_db_mon")
    private Integer idServerDbMon;
    @ManyToOne
    @JoinColumn(name = "id_server_db")
    private ServerDb idServerDb;
    @ManyToOne
    @JoinColumn(name = "id_dtl_mon")
    private DetailMonitoring idDetailMonitoring;
    @Column(name = "cpu_usage")
    private Integer cpuUsage;
    @Column(name = "ram_usage")
    private Integer ramUsage;
    @Column(name = "disk_usage")
    private Integer diskUsage;
    @Column(name = "operator_notes")
    private String operatorNotes;
    private String log;
}
