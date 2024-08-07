package com.collega.otomasi_datacenter.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerConfigRequest {
    private Integer idServerConfig;
    private Integer idServer;
    private Integer idServerPort;
    private Integer idSubproduct;
    private String ipAddress;
    private String subproductName;
    private Integer port;
    private String serverType;
}
