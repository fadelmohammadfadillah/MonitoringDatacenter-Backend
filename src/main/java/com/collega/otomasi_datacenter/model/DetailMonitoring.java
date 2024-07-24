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
@Table(name = "detail_monitoring")
public class DetailMonitoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dtl_mon")
    private Integer idDetailMonitoring;

    @ManyToOne
    @JoinColumn(name = "id_product")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product idProduct;

    @ManyToOne
    @JoinColumn(name = "id_subproduct")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Subproduct idSubproduct;

    @ManyToOne
    @JoinColumn(name = "id_monitoring")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private EventMonitoring idMonitoring;
    
    @ManyToOne
    @JoinColumn(name = "id_bank")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Bank idBank;

    @OneToMany(mappedBy = "idDetailMonitoring", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BackupAppMonitoring> backupAppMonitorings;

    @OneToMany(mappedBy = "idDetailMonitoring", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BackupDbMonitoring> backupDbMonitorings;

    @OneToMany(mappedBy = "idDetailMonitoring", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ModuleMonitoring> moduleMonitorings;

    @OneToMany(mappedBy = "idDetailMonitoring", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PathAppUseMonitoring> pathAppUseMonitorings;

    @OneToMany(mappedBy = "idDetailMonitoring", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PathDbUseMonitoring> pathDbUseMonitorings;

    @OneToMany(mappedBy = "idDetailMonitoring", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ServerAppMonitoring> serverAppMonitorings;

    @OneToMany(mappedBy = "idDetailMonitoring", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ServerDbMonitoring> serverDbMonitorings;
}
