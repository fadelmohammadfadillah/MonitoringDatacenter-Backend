package com.collega.otomasi_datacenter.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.collega.otomasi_datacenter.auth.AuthenticationRequest;
import com.collega.otomasi_datacenter.auth.RegisterRequest;
import com.collega.otomasi_datacenter.exception.ErrorResponse;
import com.collega.otomasi_datacenter.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/api/auth/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
            return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).contentType(MediaType.APPLICATION_JSON).body(new ErrorResponse(e.getMessage()));
        }

    }

    @PostMapping("/api/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
        try {
            return ResponseEntity.ok(handleRegistration(request));
        }catch (RuntimeException e) {
            return ResponseEntity.status(401).contentType(MediaType.APPLICATION_JSON).body(new ErrorResponse(e.getMessage()));
        }
    }
    
    private Object handleRegistration(RegisterRequest request){
        switch (request.getUserType()) {
            case OPERATOR:
                return ResponseEntity.ok(authenticationService.registerOperator(request));
            case MANAGER:
                return ResponseEntity.ok(authenticationService.registerManager(request));
            case SUPERVISOR:
                return ResponseEntity.ok(authenticationService.registerSupervisor(request));
            case USER_DIV:
                return ResponseEntity.ok(authenticationService.registerUserDiv(request));
            case USER_DEPT:
                return ResponseEntity.ok(authenticationService.registerUserDept(request));
            default:
                throw new IllegalArgumentException("Invalid User Type");
        }
    }
}
