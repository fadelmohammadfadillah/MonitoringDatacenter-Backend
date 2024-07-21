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
import com.collega.otomasi_datacenter.service.SubproductService;
import com.collega.otomasi_datacenter.vo.ResponseMessage;
import com.collega.otomasi_datacenter.vo.SubproductRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SubproductController {
    private final SubproductService subproductService;

    @PostMapping("/api/super-admin/subproduct/create")
    public ResponseEntity<?> createSubproduct(@RequestBody SubproductRequest request) {
        try {
            return ResponseEntity.ok(new ResponseMessage(subproductService.createSubproduct(request)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @PutMapping("/api/super-admin/subproduct/update/{id}")
    public ResponseEntity<?> updateSubproduct(@PathVariable Integer id, @RequestBody SubproductRequest request) {
        try {
            return ResponseEntity.ok(new ResponseMessage(subproductService.updateSubproduct(id, request)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/api/super-admin/subproduct/delete/{id}")
    public ResponseEntity<?> deleteSubproduct(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(new ResponseMessage(subproductService.deleteSubproduct(id)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }
        
    @GetMapping("/api/super-admin/subproduct/get-all-subproduct")
    public ResponseEntity<?> getAllSubproducts() {
        try {
            return ResponseEntity.ok(subproductService.getAllSubroducts());
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }
}
