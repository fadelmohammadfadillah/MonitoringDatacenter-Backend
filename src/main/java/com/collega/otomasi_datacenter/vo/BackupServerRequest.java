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
public class BackupServerRequest {
    private Integer idBackupAppMon;
    private Integer idBackupDbMon;
    private String backupType;
    private String ipAddress;
    private String directoryBackup;
    private Time startBackup;
    private Time finishBackup;
    private String status;
    private String operatorNotes;
}
