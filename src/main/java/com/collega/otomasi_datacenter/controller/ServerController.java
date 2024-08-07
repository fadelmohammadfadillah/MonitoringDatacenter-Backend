package com.collega.otomasi_datacenter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collega.otomasi_datacenter.exception.ErrorResponse;
import com.collega.otomasi_datacenter.service.ServerService;
import com.collega.otomasi_datacenter.vo.ResponseMessage;
import com.collega.otomasi_datacenter.vo.ServerConfigRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ServerController {
    private final ServerService serverService;

    @PostMapping("/api/super-admin/server-config/create")
    public ResponseEntity<?> createServerConfig(@RequestBody ServerConfigRequest request) {
        try {
            return ResponseEntity.ok(new ResponseMessage(serverService.createServerConfig(request)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @PutMapping("/api/super-admin/server-config/update/{id}")
    public ResponseEntity<?> updateServerConfig(@PathVariable Integer id, @RequestBody ServerConfigRequest request) {
        try {
            return ResponseEntity.ok(new ResponseMessage(serverService.updateServerConfig(id, request)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/api/super-admin/server-config/delete/{id}")
    public ResponseEntity<?> deleteServerConfig(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(new ResponseMessage(serverService.deleteServerConfig(id)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }
        
    @GetMapping("/api/super-admin/server-config/get-all-server-config")
    public ResponseEntity<?> getAllServerConfig() {
        try {
            return ResponseEntity.ok(serverService.getAllServerConfig());
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @GetMapping("/api/super-admin/server/get-all-server")
    public ResponseEntity<?> getAllServer() {
        try {
            return ResponseEntity.ok(serverService.getAllServer());
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @PostMapping("/api/super-admin/server/create")
    public ResponseEntity<?> createServer(@RequestBody ServerConfigRequest request) {
        try {
            return ResponseEntity.ok(new ResponseMessage(serverService.createServer(request)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @PutMapping("/api/super-admin/server/update/{id}")
    public ResponseEntity<?> updateServer(@PathVariable Integer id, @RequestBody ServerConfigRequest request) {
        try {
            return ResponseEntity.ok(new ResponseMessage(serverService.updateServer(id, request)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/api/super-admin/server/delete/{id}")
    public ResponseEntity<?> deleteServer(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(new ResponseMessage(serverService.deleteServer(id)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }
}
