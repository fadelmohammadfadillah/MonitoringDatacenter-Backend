package com.collega.otomasi_datacenter.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModuleMonitoringRequest {
    private Integer idModuleMon;
    private String moduleName;
    private String status;
    private String performa;
    private String log;
    private String operatorNotes;
}
