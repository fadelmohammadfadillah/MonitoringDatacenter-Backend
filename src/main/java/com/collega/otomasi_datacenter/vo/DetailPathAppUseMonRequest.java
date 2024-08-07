package com.collega.otomasi_datacenter.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailPathAppUseMonRequest {
    private Integer idPathAppUseMon;
    private String path;
    private Integer usage;
    private String operatorNotes;
    private String status;
}
