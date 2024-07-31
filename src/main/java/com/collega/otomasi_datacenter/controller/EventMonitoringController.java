package com.collega.otomasi_datacenter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.collega.otomasi_datacenter.exception.ErrorResponse;
import com.collega.otomasi_datacenter.service.EventMonitoringService;
import com.collega.otomasi_datacenter.vo.BackupServerRequest;
import com.collega.otomasi_datacenter.vo.ServerMonitoringRequest;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequiredArgsConstructor
public class EventMonitoringController {
    private final EventMonitoringService eventMonitoringService;

    @GetMapping("/api/supervisor/em/get-all-em")
    public ResponseEntity<?> getAllEventMonitoring() {
        try {
            return ResponseEntity.ok(eventMonitoringService.getAllEventMonitoring());
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }
    
    @GetMapping("/api/supervisor/em/{id}/module-monitoring")
    public ResponseEntity<?> getModuleMonitoringByIdMon(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(eventMonitoringService.getAllModuleMonByIdMon(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @GetMapping("/api/supervisor/em/{id}/path-app-use-monitoring")
    public ResponseEntity<?> getPathAppUseMonByIdMon(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(eventMonitoringService.getAllPathAppUseMonByIdMon(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }    
    
    @GetMapping("/api/supervisor/em/{id}/path-db-use-monitoring")
    public ResponseEntity<?> getPathDbUseMonByIdMon(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(eventMonitoringService.getAllPathDbUseMonByIdMon(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @GetMapping("/api/supervisor/em/{id}/backup-monitoring")
    public ResponseEntity<?> getBackupServerMonByIdMon(@PathVariable Integer id) {
        try {
            // add fetch data backup server app
            List<BackupServerRequest> backupServerRequest = eventMonitoringService.getAllBackupAppMonByIdMon(id);
             // add fetch data backup server db
            backupServerRequest.addAll(eventMonitoringService.getAllBackupDbMonByIdMon(id));
            return ResponseEntity.ok(backupServerRequest);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @GetMapping("/api/supervisor/em/{id}/server-monitoring")
    public ResponseEntity<?> getServerMonByIdMon(@PathVariable Integer id) {
        try {
            // fetch data server app mon
            List<ServerMonitoringRequest> serverMonitoringRequests = eventMonitoringService.getAllServerAppMonByIdMon(id);
            // add fetch data server db
            serverMonitoringRequests.addAll(eventMonitoringService.getAllServerDbMonByIdMon(id));
            return ResponseEntity.ok(serverMonitoringRequests);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }
}
