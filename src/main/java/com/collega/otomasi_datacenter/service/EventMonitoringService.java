package com.collega.otomasi_datacenter.service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.collega.otomasi_datacenter.repository.DetailMonitoringRepository;
import com.collega.otomasi_datacenter.vo.BackupServerRequest;
import com.collega.otomasi_datacenter.vo.EventDetailRequest;
import com.collega.otomasi_datacenter.vo.EventMonitoringRequest;
import com.collega.otomasi_datacenter.vo.ModuleMonitoringRequest;
import com.collega.otomasi_datacenter.vo.PathAppUseMonRequest;
import com.collega.otomasi_datacenter.vo.PathDbUseMonRequest;
import com.collega.otomasi_datacenter.vo.ServerMonitoringRequest;

@Service
public class EventMonitoringService {
    @Autowired
    private DetailMonitoringRepository detailMonitoringRepository;

    public List<EventMonitoringRequest> getAllEventMonitoring(){
        List<Object[]> results = detailMonitoringRepository.findAllDtlMon();
        Map<String, EventMonitoringRequest> emRequestMap = new HashMap<>();
        for (Object[] result : results){
            Integer idMonitoring = (Integer) result[0];
            String bankName = (String) result[1];
            Date dateMon = (Date) result[2];
            LocalTime timeMon = (LocalTime) result[3];
            String operatorName = (String) result[4];
            String approvalStatus = (String) result[5];
            EventDetailRequest detail = EventDetailRequest.builder()
                                        .idMonitoring(idMonitoring)
                                        .operatorName(operatorName)
                                        .dateMon(dateMon)
                                        .timeMon(timeMon)
                                        .approvalStatus(approvalStatus)
                                        .build();
            String key = bankName + dateMon.toString();
            System.out.println(key);
            if (!emRequestMap.containsKey(key)){
                EventMonitoringRequest emRequest = EventMonitoringRequest.builder()
                                                .bankName(bankName)
                                                .dateMon(dateMon)
                                                .detail(new ArrayList<>())
                                                .build();
                emRequestMap.put(key, emRequest);
            }

            emRequestMap.get(key).getDetail().add(detail);            
        }
        return new ArrayList<>(emRequestMap.values());
    }

    public List<ModuleMonitoringRequest> getAllModuleMonByIdMon(Integer idMonitoring){
        List<Object[]> results = detailMonitoringRepository.findAllModuleMonByIdMon(idMonitoring);
        return results.stream().map(result -> {
            ModuleMonitoringRequest moduleMonRequest = ModuleMonitoringRequest.builder()
                                        .idModuleMon((Integer) result[0])
                                        .moduleName((String) result[1])
                                        .status((String) result[2])
                                        .performa((String) result[3])
                                        .log((String) result[4])
                                        .operatorNotes((String) result[5])
                                        .build();
            return moduleMonRequest;
        })
        .collect(Collectors.toList());
    }

    public List<PathAppUseMonRequest> getAllPathAppUseMonByIdMon(Integer idMonitoring){
        List<Object[]> results = detailMonitoringRepository.findAllPathAppUseMonByIdMon(idMonitoring);
        return results.stream().map(result -> {
            PathAppUseMonRequest pathAppUseMonRequest = PathAppUseMonRequest.builder()
                                        .idPathAppUseMon((Integer) result[0])
                                        .subproductName((String) result[1])
                                        .ipAddress((String) result[2])
                                        .path((String) result[3])
                                        .usage((Integer) result[4])
                                        .operatorNotes((String) result[5])
                                        .status((String) result[6])
                                        .build();
            return pathAppUseMonRequest;
        })
        .collect(Collectors.toList());
    }

    public List<PathDbUseMonRequest> getAllPathDbUseMonByIdMon(Integer idMonitoring){
        List<Object[]> results = detailMonitoringRepository.findAllPathDbUseMonByIdMon(idMonitoring);
        return results.stream().map(result -> {
            PathDbUseMonRequest pathDbUseMonRequest = PathDbUseMonRequest.builder()
                                        .idPathDbUseMon((Integer) result[0])
                                        .subproductName((String) result[1])
                                        .ipAddress((String) result[2])
                                        .path((String) result[3])
                                        .usage((Integer) result[4])
                                        .operatorNotes((String) result[5])
                                        .status((String) result[6])
                                        .build();
            return pathDbUseMonRequest;
        })
        .collect(Collectors.toList());
    }
    
    public List<BackupServerRequest> getAllBackupAppMonByIdMon(Integer idMonitoring){
        List<Object[]> results = detailMonitoringRepository.findAllBackupAppMonByIdMon(idMonitoring);
        return results.stream().map(result -> {
            BackupServerRequest backupServerRequest = BackupServerRequest.builder()
                                        .idBackupAppMon((Integer) result[0])
                                        .ipAddress((String) result[1])
                                        .directoryBackup((String) result[2])
                                        .startBackup((Time) result[3])
                                        .finishBackup((Time) result[4])
                                        .operatorNotes((String) result[5])
                                        .status((String) result[6])
                                        .backupType("APP")
                                        .build();
            return backupServerRequest;
        })
        .collect(Collectors.toList());
    }

    public List<BackupServerRequest> getAllBackupDbMonByIdMon(Integer idMonitoring){
        List<Object[]> results = detailMonitoringRepository.findAllBackupDbMonByIdMon(idMonitoring);
        return results.stream().map(result -> {
            BackupServerRequest backupServerRequest = BackupServerRequest.builder()
                                        .idBackupDbMon((Integer) result[0])
                                        .ipAddress((String) result[1])
                                        .directoryBackup((String) result[2])
                                        .startBackup((Time) result[3])
                                        .finishBackup((Time) result[4])
                                        .operatorNotes((String) result[5])
                                        .status((String) result[6])
                                        .backupType("DB")
                                        .build();
            return backupServerRequest;
        })
        .collect(Collectors.toList());
    }

    public List<ServerMonitoringRequest> getAllServerAppMonByIdMon(Integer idMonitoring){
        List<Object[]> results = detailMonitoringRepository.findAllServerAppMonByIdMon(idMonitoring);
        return results.stream().map(result -> {
            ServerMonitoringRequest serverMonRequest = ServerMonitoringRequest.builder()
                                        .idServerAppMon((Integer) result[0])
                                        .ipAddress((String) result[1])
                                        .cpuUsage((Integer) result[2])
                                        .ramUsage((Integer) result[3])
                                        .diskUsage((Integer) result[4])
                                        .log((String) result[5])
                                        .operatorNotes((String) result[6])
                                        .serverType("APP")
                                        .build();
            return serverMonRequest;
        })
        .collect(Collectors.toList());
    }

    public List<ServerMonitoringRequest> getAllServerDbMonByIdMon(Integer idMonitoring){
        List<Object[]> results = detailMonitoringRepository.findAllServerDbMonByIdMon(idMonitoring);
        return results.stream().map(result -> {
            ServerMonitoringRequest serverMonRequest = ServerMonitoringRequest.builder()
                                        .idServerDbMon((Integer) result[0])
                                        .ipAddress((String) result[1])
                                        .cpuUsage((Integer) result[2])
                                        .ramUsage((Integer) result[3])
                                        .diskUsage((Integer) result[4])
                                        .log((String) result[5])
                                        .operatorNotes((String) result[6])
                                        .serverType("DB")
                                        .build();
            return serverMonRequest;
        })
        .collect(Collectors.toList());
    }
}
