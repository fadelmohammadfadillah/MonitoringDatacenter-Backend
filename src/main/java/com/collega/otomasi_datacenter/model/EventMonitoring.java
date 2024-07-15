package com.collega.otomasi_datacenter.model;

import java.sql.Date;
import java.sql.Time;

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
@Table(name = "event_monitoring")
public class EventMonitoring {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_monitoring")
    private Integer idMonitoring;
    @ManyToOne
    @JoinColumn(name = "id_operator")
    private Operator idOperator;
    @ManyToOne
    @JoinColumn(name = "id_supervisor")
    private Supervisor idSupervisor;
    @ManyToOne
    @JoinColumn(name = "id_manager")
    private Manager idManager;
    @Column(name = "operator_notes")
    private String operatorNotes;
    @Column(name = "date_mon")
    private Date dateMon;
    @Column(name = "time_mon")
    private Time timeMon;
    @Column(name="approval_status")
    private String approvalStatus;
}
