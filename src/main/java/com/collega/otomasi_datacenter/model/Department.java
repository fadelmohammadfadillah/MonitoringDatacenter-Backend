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
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DEPARTMENT")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_department")
    private Integer idDepartment;
    
    @ManyToOne
    @JoinColumn(name = "ID_DIVISI")
    private Divisi idDivisi;

    @Column(name = "department_name",unique = true)
    private String departmentName;

    @OneToMany(mappedBy = "idDepartment", cascade = CascadeType.ALL)
    private Set<UserDepartment> userDepartment;
}
