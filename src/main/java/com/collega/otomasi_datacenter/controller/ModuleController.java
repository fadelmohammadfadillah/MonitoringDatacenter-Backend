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
import com.collega.otomasi_datacenter.service.ModuleService;
import com.collega.otomasi_datacenter.vo.ModuleRequest;
import com.collega.otomasi_datacenter.vo.ResponseMessage;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ModuleController {
    private final ModuleService moduleService;

    @PostMapping("/api/super-admin/module/create")
    public ResponseEntity<?> createModule(@RequestBody ModuleRequest request) {
        try {
            return ResponseEntity.ok(new ResponseMessage(moduleService.createModule(request)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @PutMapping("/api/super-admin/module/update/{id}")
    public ResponseEntity<?> updateModule(@PathVariable Integer id, @RequestBody ModuleRequest request) {
        try {
            return ResponseEntity.ok(new ResponseMessage(moduleService.updateModule(id, request)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/api/super-admin/module/delete/{id}")
    public ResponseEntity<?> deleteModule(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(new ResponseMessage(moduleService.deleteModule(id)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }
        
    @GetMapping("/api/super-admin/module/get-all-module")
    public ResponseEntity<?> getAllModule() {
        try {
            return ResponseEntity.ok(moduleService.getAllModule());
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }
}
