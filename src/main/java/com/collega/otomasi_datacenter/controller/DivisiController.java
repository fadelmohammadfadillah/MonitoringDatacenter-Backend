package com.collega.otomasi_datacenter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.collega.otomasi_datacenter.exception.ErrorResponse;
import com.collega.otomasi_datacenter.model.Divisi;
import com.collega.otomasi_datacenter.service.DivisiService;
import com.collega.otomasi_datacenter.vo.ResponseMessage;

import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequiredArgsConstructor
public class DivisiController {
    private final DivisiService divisiService;

    @PostMapping("/api/user-div/create")
    public ResponseEntity<?> createDivisi(@RequestBody Divisi request) {
        try {
            return ResponseEntity.ok(new ResponseMessage(divisiService.createDivisi(request)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @PutMapping("/api/user-div/update/{id}")
    public ResponseEntity<?> updateDivisi(@PathVariable Integer id, @RequestBody Divisi divisi) {
        try {
            return ResponseEntity.ok(new ResponseMessage(divisiService.updateDivisi(id, divisi)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/api/user-div/delete/{id}")
    public ResponseEntity<?> deleteDivisi(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(new ResponseMessage(divisiService.deleteDivisi(id)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }
        
    // tadinya pengen cobain manggil departement berdasarkan divisi untuk cek relasi
    @PostMapping("/api/user-div/get-all-dept-by-div-name")
    public ResponseEntity<?> getAllDeptByDivName(@RequestBody Divisi request) {
        try {
            return ResponseEntity.ok(divisiService.getDepartmentByIdDivisi(request.getIdDivisi()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @GetMapping("/api/user-div/get-all-div")
    public ResponseEntity<?> getAllDiv() {
        try {
            return ResponseEntity.ok(divisiService.getAllDivisi());
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }
    
    
    
    
}
