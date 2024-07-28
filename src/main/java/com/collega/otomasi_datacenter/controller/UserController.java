package com.collega.otomasi_datacenter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collega.otomasi_datacenter.exception.ErrorResponse;
import com.collega.otomasi_datacenter.service.UserService;
import com.collega.otomasi_datacenter.vo.ResponseMessage;
import com.collega.otomasi_datacenter.vo.UserRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/api/super-admin/user/get-all-user")
    public ResponseEntity<?> getAllUsers() {
        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @PutMapping("/api/super-admin/user/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserRequest request) {
        try {
            return ResponseEntity.ok(new ResponseMessage(handleUpdateUser(id, request)));
        }catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    private String handleUpdateUser(Integer id, UserRequest request){
        String role = request.getRole();
        if (("PO_DEPARTMENT".equals(role)) || ("PO_DIVISI".equals(role))) {
            return userService.updateProductOwner(id, request);
        }else if("OPERATOR".equals(role)){
            return userService.updateOperator(id, request);
        }else if("SUPERVISOR".equals(role)){
            return userService.updateSupervisor(id, request);
        }else{
            throw new RuntimeException("Invalid User Role");
        }
    }

    @DeleteMapping("/api/super-admin/user/po/delete/{id}")
    public ResponseEntity<?> deleteUserProductOwner(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(new ResponseMessage(userService.deleteProductOwner(id)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/api/super-admin/user/spv/delete/{id}")
    public ResponseEntity<?> deleteUserSupervisor(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(new ResponseMessage(userService.deleteSupervisor(id)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/api/super-admin/user/op/delete/{id}")
    public ResponseEntity<?> deleteUserOperator(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(new ResponseMessage(userService.deleteOperator(id)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

}
