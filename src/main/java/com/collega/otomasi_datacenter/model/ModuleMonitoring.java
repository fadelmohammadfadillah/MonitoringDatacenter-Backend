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
@Table(name = "module_monitoring")
public class ModuleMonitoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_module_mon")
    private Integer idModuleMon;
    @ManyToOne
    @JoinColumn(name = "id_subproduct")
    private Subproduct idSubproduct;
    @ManyToOne
    @JoinColumn(name = "id_module")
    private Module idModule;
    @ManyToOne
    @JoinColumn(name = "id_dtl_mon")
    private DetailMonitoring idDetailMonitoring;
    private String status;
    @Column(name = "operator_notes")
    private String operatorNotes;
    private String performa;
    private String log;
}
