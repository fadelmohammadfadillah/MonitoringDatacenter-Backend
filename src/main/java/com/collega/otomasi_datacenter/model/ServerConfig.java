package com.collega.otomasi_datacenter.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
@Table(name = "server_config")
public class ServerConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_server_config")
    private Integer idServerSubProductConfig;

    @ManyToOne
    @JoinColumn(name = "id_server", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Server idServer;

    @ManyToOne
    @JoinColumn(name = "id_server_port")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ServerPort idServerPort;

    @ManyToOne
    @JoinColumn(name = "id_subproduct")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Subproduct idSubproduct;
}
