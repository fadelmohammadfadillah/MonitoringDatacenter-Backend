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
@Table(name = "path_app_use_monitoring")
public class PathAppUseMonitoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_path_app_use_mon")
    private Integer idPathAppUseMon;
    @ManyToOne
    @JoinColumn(name = "id_dtl_mon")
    private DetailMonitoring idDetailMonitoring;
    @ManyToOne
    @JoinColumn(name = "id_server_app_path")
    private ServerAppPath idServerAppPath;
    private Integer usage;
}
