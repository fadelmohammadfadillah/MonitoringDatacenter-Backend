package com.collega.otomasi_datacenter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.collega.otomasi_datacenter.exception.ErrorResponse;
import com.collega.otomasi_datacenter.service.DivisiService;
import com.collega.otomasi_datacenter.vo.DivisiRequest;

import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequiredArgsConstructor
public class DivisiController {
    private final DivisiService divisiService;

    @PostMapping("/api/user-div/create")
    public ResponseEntity<?> createDivisi(@RequestBody DivisiRequest request) {
        try {
            return ResponseEntity.ok(divisiService.createDivisi(request));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).contentType(MediaType.APPLICATION_JSON).body(new ErrorResponse(e.getMessage()));
        }
    }
    
    @PostMapping("/api/user-div/get-all-dept-by-div-name")
    public ResponseEntity<?> getAllDeptByDivName(@RequestBody DivisiRequest request) {
        try {
            return ResponseEntity.ok(divisiService.getDepartmentByDivisiName(request.getDivisiName()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).contentType(MediaType.APPLICATION_JSON).body(new ErrorResponse(e.getMessage()));
        }
    }

    // tadinya pengen cobain manggil departement berdasarkan divisi untuk cek relasi
    
    
    
}
