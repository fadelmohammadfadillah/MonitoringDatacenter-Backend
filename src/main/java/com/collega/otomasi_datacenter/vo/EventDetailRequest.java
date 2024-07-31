package com.collega.otomasi_datacenter.vo;

import java.time.LocalTime;
import java.util.Date;

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
    private Date dateMon;
    private LocalTime timeMon;
    private String approvalStatus;
}
