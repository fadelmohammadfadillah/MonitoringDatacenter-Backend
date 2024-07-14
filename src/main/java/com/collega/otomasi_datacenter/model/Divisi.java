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
@Table(name = "DIVISI")
public class Divisi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DIVISI")
    private Integer idDivisi;

    @Column(name = "DIVISI_NAME", unique = true)
    private String divisiName;
    
    @OneToMany(mappedBy = "idDivisi", cascade = CascadeType.ALL)
    private Set<UserDivisi> userDivisi;

    // ini error relasi divisi - deparment
    @OneToMany(mappedBy = "idDivisi", cascade = CascadeType.ALL)
    private Set<Department> departments;
}