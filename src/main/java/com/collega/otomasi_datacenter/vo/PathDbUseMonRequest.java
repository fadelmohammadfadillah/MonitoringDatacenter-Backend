package com.collega.otomasi_datacenter.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PathDbUseMonRequest {
    private Integer idPathDbUseMon;
    private String subproductName;
    private String ipAddress;
    private String path;
    private Integer usage;
    private String operatorNotes;
    private String status;
}
