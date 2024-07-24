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
@Table(name = "module")
public class Module {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_module")
    private Integer idModule;

    @ManyToOne
    @JoinColumn(name="id_subproduct")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Subproduct idSubproduct;
    
    @Column(name="module_name")
    private String moduleName;

    @Column(name="profile")
    private String profile;

    @OneToMany(mappedBy = "idModule", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ModuleMonitoring> moduleMonitorings;
}
