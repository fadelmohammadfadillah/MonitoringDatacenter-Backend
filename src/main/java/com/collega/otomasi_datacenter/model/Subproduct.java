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
@Table(name = "subproduct")
public class Subproduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subproduct")
    private Integer idSubproduct;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCT")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product idProduct;

    @Column(name = "subproduct_name")
    private String subproductName;

    @OneToMany(mappedBy = "idSubproduct", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Module> modules;

    @OneToMany(mappedBy = "idSubproduct", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DetailMonitoring> detailMonitorings;

    @OneToMany(mappedBy = "idSubproduct", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ModuleMonitoring> moduleMonitorings;
}
