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
import com.collega.otomasi_datacenter.model.Bank;
import com.collega.otomasi_datacenter.service.BankService;
import com.collega.otomasi_datacenter.vo.ResponseMessage;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;

    @PostMapping("/api/super-admin/bank/create")
    public ResponseEntity<?> createBank(@RequestBody Bank request) {
        try {
            return ResponseEntity.ok(new ResponseMessage(bankService.createBank(request)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @PutMapping("/api/super-admin/bank/update/{id}")
    public ResponseEntity<?> updateBank(@PathVariable Integer id, @RequestBody Bank request) {
        try {
            return ResponseEntity.ok(new ResponseMessage(bankService.updateBank(id, request)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/api/super-admin/bank/delete/{id}")
    public ResponseEntity<?> deleteBank(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(new ResponseMessage(bankService.deleteBank(id)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }
        
    @GetMapping("/api/super-admin/bank/get-all-bank")
    public ResponseEntity<?> getAllBanks() {
        try {
            return ResponseEntity.ok(bankService.getAllBanks());
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }
}
