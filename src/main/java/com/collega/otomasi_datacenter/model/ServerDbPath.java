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
@Table(name = "server_db_path")
public class ServerDbPath {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_server_db_path")
    private Integer idServerDbPath;

    @ManyToOne
    @JoinColumn(name = "id_server_db")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ServerDb idServerDb;

    private String path;

    @OneToMany(mappedBy = "idServerDbPath", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PathDbUseMonitoring> pathDbUseMonitorings;
}
