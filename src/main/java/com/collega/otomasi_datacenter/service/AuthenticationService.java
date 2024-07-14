package com.collega.otomasi_datacenter.service;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.collega.otomasi_datacenter.auth.AuthenticationRequest;
import com.collega.otomasi_datacenter.auth.AuthenticationResponse;
import com.collega.otomasi_datacenter.auth.RegisterRequest;
import com.collega.otomasi_datacenter.model.Department;
import com.collega.otomasi_datacenter.model.Divisi;
import com.collega.otomasi_datacenter.model.Manager;
import com.collega.otomasi_datacenter.model.Operator;
import com.collega.otomasi_datacenter.model.Supervisor;
import com.collega.otomasi_datacenter.model.UserDepartment;
import com.collega.otomasi_datacenter.model.UserDivisi;
import com.collega.otomasi_datacenter.repository.DepartmentRepository;
import com.collega.otomasi_datacenter.repository.DivisiRepository;
import com.collega.otomasi_datacenter.repository.ManagerRepository;
import com.collega.otomasi_datacenter.repository.OperatorRepository;
import com.collega.otomasi_datacenter.repository.SuperAdminRepository;
import com.collega.otomasi_datacenter.repository.SupervisorRepository;
import com.collega.otomasi_datacenter.repository.UserDeptRepository;
import com.collega.otomasi_datacenter.repository.UserDivRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final SuperAdminRepository superAdminRepository;
    private final ManagerRepository managerRepository;
    private final SupervisorRepository supervisorRepository;
    private final OperatorRepository operatorRepository;
    private final UserDivRepository userDivRepository;
    private final UserDeptRepository userDeptRepository;
    private final DivisiRepository divisiRepository;
    private final DepartmentRepository departmentRepository;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailService userDetailService;

    public AuthenticationResponse registerOperator(RegisterRequest request){
        try {
            var operator = Operator.builder()
                .name(request.getName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
            operatorRepository.save(operator);
            var jwtToken = jwtUtil.generateToken(operator);
            return AuthenticationResponse.builder().jwtToken(jwtToken).build();
        } catch (DataIntegrityViolationException e) {
            // System.out.println("username telah terpakai!");
            throw new RuntimeException("Username tersebut sudah terpakai!", e);
        }
    }

    public AuthenticationResponse registerManager(RegisterRequest request){
        try {
            var manager = Manager.builder()
                .name(request.getName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
            managerRepository.save(manager);
            var jwtToken = jwtUtil.generateToken(manager);
            return AuthenticationResponse.builder().jwtToken(jwtToken).build();
        } catch (DataIntegrityViolationException e) {
            // System.out.println("username telah terpakai!");
            throw new RuntimeException("Username tersebut sudah terpakai!", e);
        }
    }

    public AuthenticationResponse registerSupervisor(RegisterRequest request){
        try {
            var supervisor = Supervisor.builder()
                .name(request.getName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
            supervisorRepository.save(supervisor);
            var jwtToken = jwtUtil.generateToken(supervisor);
            return AuthenticationResponse.builder().jwtToken(jwtToken).build();
        } catch (DataIntegrityViolationException e) {
            // System.out.println("username telah terpakai!");
            throw new RuntimeException("Username tersebut sudah terpakai!", e);
        }
    }

    public AuthenticationResponse registerUserDiv(RegisterRequest request){
        try {
            Divisi divisi = divisiRepository.findById(request.getIdDivisi())
            .orElseThrow(() -> new RuntimeException("Divisi dengan kode " + request.getIdDivisi()+ " tidak tersedia!"));
            var userDiv = UserDivisi.builder()
                .name(request.getName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .idDivisi(divisi)
                .build();
            userDivRepository.save(userDiv);
            var jwtToken = jwtUtil.generateToken(userDiv);
            return AuthenticationResponse.builder().jwtToken(jwtToken).build();
        } catch (DataIntegrityViolationException e) {
            // System.out.println("username telah terpakai!");
            throw new RuntimeException("Username tersebut sudah terpakai!", e);
        }
    }

    public AuthenticationResponse registerUserDept(RegisterRequest request){
        try {
            Department deparment = departmentRepository.findById(request.getIdDepartment())
                .orElseThrow(() -> new RuntimeException("Divisi dengan kode " + request.getIdDepartment()+ " tidak tersedia!"));
            var userDept = UserDepartment.builder()
                .name(request.getName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .idDepartment(deparment)
                .build();
            userDeptRepository.save(userDept);
            var jwtToken = jwtUtil.generateToken(userDept);
            return AuthenticationResponse.builder().jwtToken(jwtToken).build();
        } catch (DataIntegrityViolationException e) {
            // System.out.println("username telah terpakai!");
            throw new RuntimeException("Username tersebut sudah terpakai!", e);
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        try {
            // System.out.println("mencoba login!");
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            // System.out.println("Salah password!");
            throw new RuntimeException("Username atau Password salah!", e);
        }
        final UserDetails userDetails = userDetailService.loadUserByUsername(request.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return AuthenticationResponse.builder().jwtToken(jwt).build();
    }
}
