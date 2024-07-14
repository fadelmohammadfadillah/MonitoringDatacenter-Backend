package com.collega.otomasi_datacenter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.collega.otomasi_datacenter.service.DivisiService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequiredArgsConstructor
public class SuperAdminController {
    private final DivisiService divisiService;

    @GetMapping("/api/super-admin/hello")
    public String helloSuperAdmin() {
        return "Hello, Super Admin!";
    }

    
    @GetMapping("/api/super-admin/get-all-div")
    public ResponseEntity<?> getAllDiv() {
        return ResponseEntity.ok(divisiService.getAllDivisi());
    }


    
}
