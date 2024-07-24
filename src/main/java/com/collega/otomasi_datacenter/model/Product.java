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
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer idProduct;

    @ManyToOne
    @JoinColumn(name = "id_department")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department idDepartment;

    @Column(name = "product_name", unique=true)
    private String productName;

    @OneToMany(mappedBy = "idProduct", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Subproduct> subproducts;
    
    @OneToMany(mappedBy = "idProduct", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DetailMonitoring> detailMonitorings;
}
