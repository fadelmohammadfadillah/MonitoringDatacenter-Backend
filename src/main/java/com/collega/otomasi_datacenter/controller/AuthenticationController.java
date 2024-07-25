package com.collega.otomasi_datacenter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.collega.otomasi_datacenter.exception.ErrorResponse;
import com.collega.otomasi_datacenter.service.AuthenticationService;
import com.collega.otomasi_datacenter.vo.AuthenticationRequest;
import com.collega.otomasi_datacenter.vo.RegisterRequest;
import com.collega.otomasi_datacenter.vo.ResponseMessage;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/api/auth/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) throws Exception{
        try {
            return ResponseEntity.ok(authenticationService.authenticate(request));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }

    }

    @PostMapping("/api/super-admin/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
        try {
            return ResponseEntity.ok(new ResponseMessage(handleRegisterRequest(request)));
        }catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    private String handleRegisterRequest(RegisterRequest request){
        String role = request.getRole();
        if (("PO_DEPARTMENT".equals(role)) || ("PO_DIVISI".equals(role))) {
            return authenticationService.registerProductOwner(request);
        }else if("OPERATOR".equals(role)){
            return authenticationService.registerOperator(request);
        }else if("SUPERVISOR".equals(role)){
            return authenticationService.registerSupervisor(request);
        }else{
            throw new RuntimeException("Invalid User Role");
        }
    }
}
