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
@Table(name = "module_monitoring")
public class ModuleMonitoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_module_mon")
    private Integer idModuleMon;

    @ManyToOne
    @JoinColumn(name = "id_module")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Module idModule;

    @ManyToOne
    @JoinColumn(name = "id_dtl_mon")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DetailMonitoring idDetailMonitoring;

    @Column(name = "status")
    private String status;

    @Column(name = "operator_notes")
    private String operatorNotes;

    @Column(name = "performa")
    private String performa;

    @Column(name = "log")
    private String log;
}
