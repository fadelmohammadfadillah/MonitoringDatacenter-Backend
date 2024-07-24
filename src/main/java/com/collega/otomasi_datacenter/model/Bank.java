package com.collega.otomasi_datacenter.model;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BANK")
    private Integer idBank;

    @Column(name="BANK_NAME", unique = true)
    private String bankName;

    @OneToMany(mappedBy = "idBank", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DetailMonitoring> detailMonitorings;
}
