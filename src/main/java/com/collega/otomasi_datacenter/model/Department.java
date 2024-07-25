package com.collega.otomasi_datacenter.model;

import java.util.Set;
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
@Table(name = "DEPARTMENT")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DEPARTMENT")
    private Integer idDepartment;
    
    @ManyToOne
    @JoinColumn(name = "ID_DIVISI", nullable = false)
    private Divisi idDivisi;

    @Column(name = "DEPARTMENT_NAME", unique = true)
    private String departmentName;

    @OneToMany(mappedBy = "idDepartment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductOwner> productOwners;

    @OneToMany(mappedBy = "idDepartment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products;
    
    @OneToMany(mappedBy = "idDepartment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Operator> operators;

    @OneToMany(mappedBy = "idDepartment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Supervisor> supervisors;
}
