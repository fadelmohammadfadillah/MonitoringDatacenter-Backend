package com.collega.otomasi_datacenter.vo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventMonitoringRequest {
    private String bankName;
    private String dateMon;
    private List<EventDetailRequest> details;
}