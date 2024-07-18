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
import com.collega.otomasi_datacenter.service.DepartmentService;
import com.collega.otomasi_datacenter.vo.DepartmentRequest;
import com.collega.otomasi_datacenter.vo.ResponseMessage;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/api/user-dept/create")
    public ResponseEntity<?> createDepartment(@RequestBody DepartmentRequest request) {
        try {
            return ResponseEntity.ok(new ResponseMessage(departmentService.createDepartment(request)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @PutMapping("/api/user-dept/update/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentRequest request) {
        try {
            return ResponseEntity.ok(new ResponseMessage(departmentService.updateDepartment(id, request)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/api/user-dept/delete/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(new ResponseMessage(departmentService.deleteDepartment(id)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @GetMapping("/api/user-dept/get-all-dept")
    public ResponseEntity<?> getAllDepartment() {
        try {
            return ResponseEntity.ok(departmentService.getAllDepartments());
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }
}
