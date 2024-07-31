package com.collega.otomasi_datacenter.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerMonitoringRequest {
    private Integer idServerAppMon;
    private Integer idServerDbMon;
    private String serverType;
    private String ipAddress;
    private Integer cpuUsage;
    private Integer ramUsage;
    private Integer diskUsage;
    private String log;
    private String operatorNotes;
}
