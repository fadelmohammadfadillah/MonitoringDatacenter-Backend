package com.collega.otomasi_datacenter.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PathAppUseMonRequest {
    private Integer idPathAppUseMon;
    private String subproductName;
    private String ipAddress;
}