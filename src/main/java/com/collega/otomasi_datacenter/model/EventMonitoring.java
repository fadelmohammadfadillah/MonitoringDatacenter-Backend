package com.collega.otomasi_datacenter.model;

import java.sql.Date;
import java.sql.Time;
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
@Table(name = "event_monitoring")
public class EventMonitoring {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_monitoring")
    private Integer idMonitoring;
    
    @ManyToOne
    @JoinColumn(name = "id_operator")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Operator idOperator;

    @ManyToOne
    @JoinColumn(name = "id_supervisor")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Supervisor idSupervisor;

    @Column(name = "operator_notes")
    private String operatorNotes;

    @Column(name = "date_mon")
    private Date dateMon;

    @Column(name = "time_mon")
    private Time timeMon;

    @Column(name="approval_status")
    private String approvalStatus;

    @OneToMany(mappedBy = "idMonitoring", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DetailMonitoring> detailMonitorings;
}
