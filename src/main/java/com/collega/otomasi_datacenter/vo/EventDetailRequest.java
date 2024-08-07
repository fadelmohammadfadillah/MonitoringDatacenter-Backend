package com.collega.otomasi_datacenter.vo;

import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDetailRequest {
    private Integer idMonitoring;
    private String operatorName;
    private String dateMon;
    private Time timeMon;
    private String approvalStatus;
}
